package socialnetwork.repository.file;

import socialnetwork.domain.Reservation;
import socialnetwork.domain.Reservation;
import socialnetwork.domain.validators.ValidationException;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Constants;
import socialnetwork.utils.Type;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationFile extends AbstractFileRepository<Double, Reservation>{

    public ReservationFile(String fileName, Validator<Reservation> validator) {
        super(fileName, validator);
    }

    @Override
    public Reservation extractEntity(List<String> attributes) {
        Reservation Reservation = new Reservation(Long.parseLong(attributes.get(1)),Double.parseDouble(attributes.get(2)), LocalDateTime.parse(attributes.get(3), Constants.DATE_TIME_FORMATTER), Integer.parseInt(attributes.get(4)));
        Reservation.setId(Double.parseDouble(attributes.get(0)));

        return Reservation;
    }

    @Override
    protected String createEntityAsString(Reservation entity) {
        return entity.getId()+";"+ entity.getClientID()+";"+entity.getHotelID()+";"+entity.getStartDate().format(Constants.DATE_TIME_FORMATTER)+";"+entity.getNoNights();
    }
}
