package babysitting.nannyservice;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.requests.SearchNanniesRequest;
import babysitting.nannyservice.responses.CoreError;
import babysitting.nannyservice.responses.SearchNannyResponse;
import babysitting.nannyservice.services.SearchNanniesService;
import babysitting.nannyservice.services.validators.SearchNanniesRequestValidator;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SearchNanniesServiceTest {

    @Mock
    private JpaNannyRepository repository;
    @Mock
    private SearchNanniesRequestValidator validator;
    @InjectMocks
    private SearchNanniesService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidatorFails() {
        SearchNanniesRequest request = new SearchNanniesRequest(null, null);
        List<CoreError> errors = new ArrayList<>();
        errors.add(new CoreError("id", "must not be empty!"));
        errors.add(new CoreError("city", "must not be empty!"));
        Mockito.when(validator.validate(request)).thenReturn(errors);

        SearchNannyResponse response = service.execute(request);
        assertTrue(response.hasErrors());
        assertEquals(response.getErrors().size(), 2);

        Mockito.verify(validator).validate(request);
        Mockito.verify(validator).validate(any());
        Mockito.verifyNoInteractions(repository);
    }

    @Test
    public void shouldSearchByCity() {
        SearchNanniesRequest request = new SearchNanniesRequest("Riga");
        Mockito.when(validator.validate(request))
                .thenReturn(new ArrayList<>());

        List<Nanny> nannies = new ArrayList<>();
        User user = new User();
        nannies.add(new Nanny("qualification", "Riga", user, "bio", 3));
        Mockito.when(repository.findByCity("Riga")).thenReturn(nannies);

        SearchNannyResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        assertEquals(response.getNannies().size(), 1);
        assertEquals(response.getNannies().get(0).getCity(), "Riga");
        assertEquals(response.getNannies().get(0).getQualification(), "qualification");

    }


}




