package socialnetwork.repository.file;

import socialnetwork.domain.Hotel;
import socialnetwork.domain.validators.ValidationException;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Type;

import java.util.List;

public class HotelFile extends AbstractFileRepository<Double, Hotel>{

    public HotelFile(String fileName, Validator<Hotel> validator) {
        super(fileName, validator);
    }

    @Override
    public Hotel extractEntity(List<String> attributes) {
        Type tip;

        if(attributes.get(5).equals("FAMILY")){
            tip=Type.FAMILY;
        }else

        if(attributes.get(5).equals("TEENAGERS")){
            tip=Type.TEENAGERS;
        }else

        if(attributes.get(5).equals("OLDPEOPLE")){
            tip=Type.OLDPEOPLE;
        }else
        {
            throw new ValidationException("Tip incorect!");
        }


        Hotel hotel = new Hotel(Double.parseDouble(attributes.get(1)), attributes.get(2), Integer.parseInt(attributes.get(3)), Double.parseDouble(attributes.get(4)), tip);
        hotel.setId(Double.parseDouble(attributes.get(0)));

        return hotel;
    }

    @Override
    protected String createEntityAsString(Hotel entity) {
        return entity.getId()+";"+entity.getLocationID()+";"+entity.getHotelName()+";"+entity.getNoRooms()+";"+entity.getPricePerNight()+";"+entity.getType();
    }
}
