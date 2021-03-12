package socialnetwork.domain.validators;

import socialnetwork.domain.Reservation;
import socialnetwork.domain.Reservation;
import socialnetwork.domain.Reservation;

public class ReservationValidator implements Validator<Reservation> {
    @Override
    public void validate(Reservation entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getHotelID() == null || entity.getHotelID() < 0){
            errors += "Id hotel invalid!\n";
        }

        if(entity.getClientID() == null || entity.getClientID() < 0){
            errors += "Id client invalid!\n";
        }

        if(!(entity.getNoNights() >= 1)){
            errors += "Numar nopti invalid!\n";
        }


        if(entity.getStartDate() == null){
            errors += "Data de start invalida!\n";
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }

    }
}
