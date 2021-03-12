package socialnetwork.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import socialnetwork.domain.*;
import socialnetwork.service.SuperService;
import socialnetwork.utils.Hobbies;
import socialnetwork.utils.observer.Observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class ProfileController //implements Observer<MessageChangeEvent, MembruChangeEvent>
{
    private Client client;
    private SuperService service;

    private ObservableList<HotelDTO> hotelModel = FXCollections.observableArrayList();
    private ObservableList<SpecialOfferDTO> ofertaModel = FXCollections.observableArrayList();

    @FXML
    private TableView<HotelDTO> tableViewHotel;
    @FXML
    private TableColumn<HotelDTO,String> tableColumnHotelID;
    @FXML
    private TableColumn<HotelDTO,String> tableColumnLocationName;
    @FXML
    private TableColumn<HotelDTO,String> tableColumnHotelName;
    @FXML
    private TableColumn<HotelDTO,String> tableColumnNoRooms;
    @FXML
    private TableColumn<HotelDTO,String> tableColumnPrice;
    @FXML
    private TableColumn<HotelDTO,String> tableColumnType;
    @FXML
    private Label labelNume;
    @FXML
    private ComboBox<Location> comboBoxLocatie;
    @FXML
    private TableView<SpecialOfferDTO> tableViewOferte;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnHotel;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnLocatie;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnStart;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnEnd;


    public void setPage(Client client, SuperService service) {
        this.client = client;
        this.service = service;
        initModel();
        service.getReservationService().addProfile(this);
    }


    @FXML
    public void initialize() {
        tableColumnHotelID.setCellValueFactory(new PropertyValueFactory<HotelDTO, String>("ID"));
        tableColumnHotelName.setCellValueFactory(new PropertyValueFactory<HotelDTO, String>("HotelName"));
        tableColumnLocationName.setCellValueFactory(new PropertyValueFactory<HotelDTO, String>("Location"));
        tableColumnNoRooms.setCellValueFactory(new PropertyValueFactory<HotelDTO, String>("NoRooms"));
        tableColumnPrice.setCellValueFactory(new PropertyValueFactory<HotelDTO, String>("PricePerNight"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<HotelDTO, String>("Type"));
        tableViewHotel.setItems(hotelModel);

        tableColumnHotel.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("HotelName"));
        tableColumnLocatie.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("Location"));
        tableColumnStart.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("StartDate"));
        tableColumnEnd.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("EndDate"));
        tableViewOferte.setItems(ofertaModel);
    }

    private void initModel() {

        Iterable<HotelDTO> hoteluri = service.getHotelService().TransformaDTO(service.getHotelService().getAll());
        List<HotelDTO> hotelList = StreamSupport
                .stream(hoteluri.spliterator(), false)
                .collect(Collectors.toList());


        hotelModel.setAll(hotelList);
        ofertaModel.setAll(service.getOfferService().getSpecialOfferClient(client));

        labelNume.setText(client.getName());
        initVisualObjects();
    }

    private void initVisualObjects() {
        List<Location> all_location = StreamSupport
                .stream(service.getLocationService().getAll().spliterator(), false)
                .collect(Collectors.toList());
        ObservableList<Location> observableList = FXCollections.observableArrayList(all_location);
        comboBoxLocatie.setItems(observableList);
        comboBoxLocatie.setCellFactory(new Callback<ListView<Location>, ListCell<Location>>() {
            @Override
            public ListCell<Location> call(ListView<Location> param) {
                return new ListCell<Location>() {
                    @Override
                    protected void updateItem(Location item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item == null || empty) {
                            setText(null);
                        } else {
                            setText("Nume: " + item.getLocationName());
                        }
                    }
                };
            }
        });

        comboBoxLocatie.setConverter(new StringConverter<Location>() {
            @Override
            public String toString(Location locatie) {
                if (locatie == null) {
                    return null;
                }
                else {
                    return "Nume: " + locatie.getLocationName();
                }
            }
            @Override
            public Location fromString(String string) {
                return null;
            }
        });
    }

    @FXML
    public void handleFiltratiButton(){
        Location selectedLocation = comboBoxLocatie.selectionModelProperty().get().getSelectedItem();
        if(selectedLocation != null)
        {
            hotelModel.setAll(service.getHotelService().getHotelLocatie(selectedLocation));

        }else{
            MessageAlert.showErrorMessage(null, "Nu a fost selectat niciun camp din comboBox!");
        }
    }

    @FXML
    public void handleMouseClicked(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/specialOfferView.fxml"));
            AnchorPane root = loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Pagina");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.setWidth(700);
            Scene scene = new Scene(root);
            dialogStage.setScene(scene);
            SpecialOfferController newOfferController = loader.getController();
            newOfferController.setPage(tableViewHotel.getSelectionModel().getSelectedItem(), service, client);
            dialogStage.show();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void mesaj(Client client){
        if(this.client.getHobby().equals(client.getHobby()) && this.client != client) {
            MessageAlert.showErrorMessage(null, "Clientul " + client.getName() + " cu hobby-ul " + client.getHobby() + " a facut rezervare la un hotel!");
        }
    }
}
