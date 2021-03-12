package socialnetwork.domain.validators;

import socialnetwork.domain.SpecialOffer;
import socialnetwork.domain.SpecialOffer;

public class SpecialOfferValidator implements Validator<SpecialOffer> {
    @Override
    public void validate(SpecialOffer entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getHotelID() == null || entity.getHotelID() < 0){
            errors += "Id hotel invalid!\n";
        }

        if(!(entity.getPercents() >= 1 && entity.getPercents()<=100)){
            errors += "Procent invalid!\n";
        }

        if(entity.getStartDate() == null){
            errors += "Data de start invalida!\n";
        }

        if(entity.getEndDate() == null){
            errors += "Data de final invalida!\n";
        }

        if(entity.getStartDate().isAfter(entity.getEndDate())){
            errors += "Data de start nu poate fi dupa data de final!\n";
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }

    }
}
