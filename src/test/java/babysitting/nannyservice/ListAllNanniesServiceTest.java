package babysitting.nannyservice;

import babysitting.nannyservice.domain.Nanny;
import babysitting.nannyservice.domain.User;
import babysitting.nannyservice.repositories.JpaNannyRepository;
import babysitting.nannyservice.requests.ListAllNanniesRequest;
import babysitting.nannyservice.responses.ListAllNanniesResponse;
import babysitting.nannyservice.services.ListAllNanniesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ListAllNanniesServiceTest {

    @Mock
    private JpaNannyRepository repository;

    @InjectMocks
    ListAllNanniesService service;

    @Test
    public void shouldListAllNannies() {
        ListAllNanniesRequest request = new ListAllNanniesRequest();
        Nanny nanny1 = new Nanny();
        Nanny nanny2 = new Nanny();
        Mockito.when(repository.findAll())
                .thenReturn(List.of(nanny1, nanny2));

        ListAllNanniesResponse response = service.execute(request);

        assertEquals(response.getNannies().size(),2);

    }

}
