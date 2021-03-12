package socialnetwork.repository.file;

import socialnetwork.domain.Client;
import socialnetwork.domain.Client;
import socialnetwork.domain.validators.ValidationException;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Constants;
import socialnetwork.utils.Hobbies;
import socialnetwork.utils.Type;

import java.time.LocalDateTime;
import java.util.List;

public class ClientFile extends AbstractFileRepository<Long, Client>{

    public ClientFile(String fileName, Validator<Client> validator) {
        super(fileName, validator);
    }

    @Override
    public Client extractEntity(List<String> attributes) {

        Hobbies hobby;

        if(attributes.get(4).equals("READING")){
            hobby=Hobbies.READING;
        }else

        if(attributes.get(4).equals("MUSIC")){
            hobby=Hobbies.MUSIC;
        }else

        if(attributes.get(4).equals("HIKING")){
            hobby=Hobbies.HIKING;
        }else
            if(attributes.get(4).equals("WALKING")){
            hobby=Hobbies.WALKING;
        }else
            if(attributes.get(4).equals("EXTREMESPORTS")){
                hobby=Hobbies.EXTREMESPORTS;
            }else

        {
            throw new ValidationException("hobby incorect!");
        }

        Client client = new Client(attributes.get(1), Integer.parseInt(attributes.get(2)), Integer.parseInt(attributes.get(3)), hobby);
        client.setId(Long.parseLong(attributes.get(0)));
        return client;
    }

    @Override
    protected String createEntityAsString(Client entity) {
        return entity.getId()+";"+entity.getName()+";"+entity.getFidelityGrade()+";"+entity.getVarsta()+";"+entity.getHobby();
    }
}




