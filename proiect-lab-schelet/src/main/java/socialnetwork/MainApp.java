package socialnetwork;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import socialnetwork.config.ApplicationContext;
import socialnetwork.controller.ProfileController;
import socialnetwork.domain.*;
import socialnetwork.domain.validators.*;
import socialnetwork.repository.Repository;
import socialnetwork.repository.file.*;
import socialnetwork.service.*;
import socialnetwork.utils.Hobbies;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainApp extends Application {
    SuperService service;
    public static List<Client> clienti = new ArrayList<>();
    public static String[] argumente;

    public static void main(String[] args) {
        argumente = args;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        String fileNameLocation=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.location");
        Repository<Double, Location> locationFileRepository = new LocationFile(fileNameLocation
                , new LocationValidator());

        String fileNameHotel=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.hotel");
        Repository<Double, Hotel> hotelFileRepository = new HotelFile(fileNameHotel
                , new HotelValidator());

        String fileNameSpecialOffer=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.specialOffer");
        Repository<Double, SpecialOffer> specialOfferRepository = new SpecialOfferFile(fileNameSpecialOffer
                , new SpecialOfferValidator());

        String fileNameClient=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.client");
        Repository<Long, Client> clientRepository = new ClientFile(fileNameClient
                , new ClientValidator());

        String fileNameReservation=ApplicationContext.getPROPERTIES().getProperty("data.socialnetwork.reservation");
        Repository<Double, Reservation> reservationRepository = new ReservationFile(fileNameReservation
                , new ReservationValidator());


        LocationService locationService = new LocationService(locationFileRepository);
        HotelService hotelService = new HotelService(hotelFileRepository);
        OfferService offerService =  new OfferService(specialOfferRepository);
        ReservationService reservationService =  new ReservationService(reservationRepository);

        service = new SuperService(hotelService, locationService, offerService, reservationService);
        service.getHotelService().setLocationService(locationService);

        service.getOfferService().setHotelService(hotelService);
        service.getOfferService().setLocationService(locationService);

        for(String arg : argumente){
            clienti.add(clientRepository.findOne(Long.parseLong(arg)));
        }

        for(Client c : clienti) {
            Stage stage = new Stage();
            this.openPage(stage, "/views/profilView.fxml", c);
        }
    }

    public void openPage(Stage dialogStage, String path, Object o) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(path));
            AnchorPane root = loader.load();
            dialogStage.setTitle("Page for " + ((Client)o).getName());
           // dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setWidth(700);
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            ProfileController newProfileController = loader.getController();
            newProfileController.setPage((Client)o, service);
            dialogStage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}