package babysitting.nannyservice.services;

import babysitting.nannyservice.domain.Booking;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.repositories.UserRepository;
import babysitting.nannyservice.requests.AddNewNannyRequest;
import babysitting.nannyservice.responses.AddNewNannyResponse;
import babysitting.nannyservice.responses.CoreError;
import babysitting.nannyservice.services.validators.AddNewNannyRequestValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import babysitting.nannyservice.domain.Nanny;

import java.util.List;

@Service
@Transactional
public class AddNewNannyService {

    @Autowired
    private JpaNannyRepository nannyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddNewNannyRequestValidator validator;

    public AddNewNannyResponse execute(AddNewNannyRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddNewNannyResponse(errors);
        }

        Nanny nanny = new Nanny();
        User user = userRepository.findById(request.getUserid()).orElseThrow(() -> new RuntimeException("User not found"));

        nanny.setUser(user);
        nanny.setBio(request.getBio());
        nanny.setCity(request.getCity().trim());
        nanny.setExperience(request.getExperience());
        nanny.setQualification(request.getQualification());


        nannyRepository.save(nanny);

        return new AddNewNannyResponse(nanny);
    }


}
