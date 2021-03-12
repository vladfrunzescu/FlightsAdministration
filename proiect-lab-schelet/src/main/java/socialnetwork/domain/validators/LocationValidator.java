package socialnetwork.domain.validators;

import socialnetwork.domain.Client;
import socialnetwork.domain.Location;

public class LocationValidator implements Validator<Location> {
    @Override
    public void validate(Location entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getLocationName() == null || "".equals(entity.getLocationName())){
            errors += "Nume locatie invalid!\n";
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }

    }
}
