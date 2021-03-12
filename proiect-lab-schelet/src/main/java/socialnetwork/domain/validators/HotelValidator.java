package socialnetwork.domain.validators;

import socialnetwork.domain.Hotel;

public class HotelValidator implements Validator<Hotel> {
    @Override
    public void validate(Hotel entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getLocationID() == null || entity.getLocationID() < 0){
            errors += "Id locatie invalid!\n";
        }

        if(entity.getHotelName() == null || "".equals(entity.getHotelName())){
            errors += "Nume hotel invalid!\n";
        }

        if(!(entity.getNoRooms() >= 0)){
            errors += "Numar camere invalid!\n";
        }


        if(!(entity.getPricePerNight() >= 0 )){
            errors += "Pret invalid!\n";
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }

    }
}
