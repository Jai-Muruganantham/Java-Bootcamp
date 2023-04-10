package babysitting.nannyservice.responses;

import babysitting.nannyservice.domain.Nanny;

import java.util.List;

public class SearchNannyResponse extends CoreResponse {

    private List<Nanny> nannies;


    public SearchNannyResponse(List<CoreError> errors) {
        super(errors);
    }

    public SearchNannyResponse(List<Nanny> nannies, boolean success ) {
        super(success);
        this.nannies = nannies;
    }


    public List<Nanny> getNannies(){return nannies;}

}
