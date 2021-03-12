package socialnetwork.domain.validators;

import socialnetwork.domain.Client;

public class ClientValidator implements Validator<Client> {
    @Override
    public void validate(Client entity) throws ValidationException {
        String errors = "";

        if(entity.getId() == null || entity.getId() < 0){
            errors += "Id invalid!\n";
        }

        if(entity.getName() == null || "".equals(entity.getName())){
            errors += "Nume invalid!\n";
        }

        if(!(entity.getFidelityGrade() >= 1 &&  entity.getFidelityGrade() <= 100 )){
            errors += "Fidelitate invalida!\n";
        }


        if(!(entity.getVarsta() >= 0 && entity.getVarsta() <= 150 )){
            errors += "Varsta invalida!\n";
        }

        if(!errors.equals("")){
            throw new ValidationException(errors);
        }

    }
}
