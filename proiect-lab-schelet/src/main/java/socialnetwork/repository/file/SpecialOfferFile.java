package socialnetwork.repository.file;

import socialnetwork.domain.SpecialOffer;
import socialnetwork.domain.SpecialOffer;
import socialnetwork.domain.validators.ValidationException;
import socialnetwork.domain.validators.Validator;
import socialnetwork.utils.Constants;
import socialnetwork.utils.Type;

import java.time.LocalDateTime;
import java.util.List;

public class SpecialOfferFile extends AbstractFileRepository<Double, SpecialOffer>{

    public SpecialOfferFile(String fileName, Validator<SpecialOffer> validator) {
        super(fileName, validator);
    }

    @Override
    public SpecialOffer extractEntity(List<String> attributes) {
        SpecialOffer SpecialOffer = new SpecialOffer(Double.parseDouble(attributes.get(1)), LocalDateTime.parse(attributes.get(2), Constants.DATE_TIME_FORMATTER),  LocalDateTime.parse(attributes.get(3), Constants.DATE_TIME_FORMATTER), Integer.parseInt(attributes.get(4)));
        SpecialOffer.setId(Double.parseDouble(attributes.get(0)));

        return SpecialOffer;
    }

    @Override
    protected String createEntityAsString(SpecialOffer entity) {
        return entity.getId()+";"+entity.getHotelID()+";"+entity.getStartDate().format(Constants.DATE_TIME_FORMATTER)+";"+entity.getEndDate().format(Constants.DATE_TIME_FORMATTER)+";"+entity.getPercents();
    }
}
