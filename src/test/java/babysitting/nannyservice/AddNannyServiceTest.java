package babysitting.nannyservice;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.repositories.UserRepository;
import babysitting.nannyservice.requests.AddNewNannyRequest;
import babysitting.nannyservice.responses.AddNewNannyResponse;
import babysitting.nannyservice.responses.CoreError;
import babysitting.nannyservice.services.AddNewNannyService;
import babysitting.nannyservice.services.validators.AddNewNannyRequestValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class AddNannyServiceTest {

    @Mock
    private JpaNannyRepository nannyRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AddNewNannyRequestValidator validator;

    @InjectMocks
    AddNewNannyService service;

    @Test
    public void shouldAddNannyToDatabase() {
        AddNewNannyRequest request = new AddNewNannyRequest(61, "Riga", "yyy", "bio", 5);
        Mockito.when(validator.validate(request))
                .thenReturn(List.of());
        Mockito.when(userRepository.findById(request.getUserid())).thenReturn(Optional.of(new User()));
        AddNewNannyResponse response = service.execute(request);

        assertFalse(response.hasErrors());
        assertNotNull(response.getNewNanny());
        Nanny nanny = response.getNewNanny();
        Mockito.verify(nannyRepository).save(nanny);

    }

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {
        AddNewNannyRequest request = new AddNewNannyRequest(0, null, null, null, 0);
        CoreError error = new CoreError("city", "must not me empty");
        Mockito.when(validator.validate(request))
                .thenReturn(List.of(error));

        AddNewNannyResponse response = service.execute(request);

        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "city");
        assertEquals(response.getErrors().get(0).getMessage(), "must not me empty");
    }

}
