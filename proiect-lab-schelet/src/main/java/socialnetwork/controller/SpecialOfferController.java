package socialnetwork.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;
import socialnetwork.domain.*;
import socialnetwork.service.SuperService;
//import socialnetwork.utils.events.MembruChangeEvent;
//import socialnetwork.utils.events.MessageChangeEvent;
import socialnetwork.utils.observer.Observer;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class SpecialOfferController //implements Observer<MessageChangeEvent, MembruChangeEvent>
{


    private HotelDTO hotelDTO;
    private SuperService service;
    private Client client;

    private ObservableList<SpecialOfferDTO> offerModel = FXCollections.observableArrayList();
    private ObservableList<Reservation> reservationModel = FXCollections.observableArrayList();

    @FXML
    private TableView<SpecialOfferDTO> tableView;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnID;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnNume;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnLocatie;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnPercent;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnStart;
    @FXML
    private TableColumn<SpecialOfferDTO,String> tableColumnEnd;
    @FXML
    private Button buttonCauta;
    @FXML
    private DatePicker datePickerStart;
    @FXML
    private DatePicker datePickerEnd;
    @FXML
    private TableView<Reservation> tableViewRezervari;
    @FXML
    private TableColumn<Reservation,String> tableColumnIDRe;
    @FXML
    private TableColumn<Reservation,String> tableColumnIDC;
    @FXML
    private TableColumn<Reservation,String> tableColumnIDH;
    @FXML
    private TableColumn<Reservation,String> tableColumnStartRe;
    @FXML
    private TableColumn<Reservation,String> tableColumnNoNights;


    public void setPage(HotelDTO hotelDTO, SuperService service, Client client) {
        this.hotelDTO = hotelDTO;
        this.service = service;
        this.client = client;
        // service.getMesajService().addObserver(this);
        // service.getMembruService().addObserver(this);
        initModel();
    }


    @FXML
    public void initialize() {
        tableColumnID.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("OfferID"));
        tableColumnNume.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("HotelName"));
        tableColumnLocatie.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("Location"));
        tableColumnStart.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("StartDate"));
        tableColumnEnd.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("EndDate"));
        tableColumnPercent.setCellValueFactory(new PropertyValueFactory<SpecialOfferDTO, String>("Percents"));
        tableView.setItems(offerModel);

        tableColumnIDRe.setCellValueFactory(new PropertyValueFactory<Reservation, String>("Id"));
        tableColumnIDC.setCellValueFactory(new PropertyValueFactory<Reservation, String>("ClientID"));
        tableColumnIDH.setCellValueFactory(new PropertyValueFactory<Reservation, String>("HotelID"));
        tableColumnStartRe.setCellValueFactory(new PropertyValueFactory<Reservation, String>("StartDate"));
        tableColumnNoNights.setCellValueFactory(new PropertyValueFactory<Reservation, String>("NoNights"));
        tableViewRezervari.setItems(reservationModel);
    }

    private void initModel() {

        offerModel.setAll(service.getOfferService().getSpecialOfferHotel(hotelDTO.getID()));
        reservationModel.setAll(service.getReservationService().getAllForClient(client));
    }

    @FXML
    public void handleCautaButton(){
        LocalDate start_date = datePickerStart.getValue();
        LocalDate end_date = datePickerEnd.getValue();

        if(start_date != null && end_date != null)
        {
            offerModel.setAll(service.getOfferService().getSpecialOfferDate(start_date.atTime(00,00,00), end_date.atTime(00,00,00), hotelDTO.getID()));

        }else{
            MessageAlert.showErrorMessage(null, "Alegeti data corecta!");
        }
    }

    @FXML
    public void handleRezervaButton(){
        SpecialOfferDTO specialOfferDTO = tableView.selectionModelProperty().get().getSelectedItem();
        Long daysBetweenDates= Duration.between(specialOfferDTO.getStartDate(), specialOfferDTO.getEndDate()).toDays();

        Reservation reservation = new Reservation(client.getId(), specialOfferDTO.getHotelID(), specialOfferDTO.getStartDate(), Integer.parseInt(daysBetweenDates.toString()));
        service.getReservationService().addReservation(reservation, client);
        initModel();
    }
}
