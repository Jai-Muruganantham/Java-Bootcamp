package babysitting.nannyservice.responses;

import babysitting.nannyservice.domain.Nanny;

import java.util.List;

public class ListAllNanniesResponse {

    private List<Nanny> nannies;

    public ListAllNanniesResponse(List<Nanny> nannies) {
        this.nannies = nannies;
    }

    public List<Nanny> getNannies(){
        return nannies;
    }
}
