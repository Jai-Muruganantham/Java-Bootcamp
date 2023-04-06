package babysitting.nannyservice.responses;

import babysitting.nannyservice.domain.Nanny;

import java.util.List;

public class SearchNannyResponse extends CoreResponse {

    private List<Nanny> nannies;

    public SearchNannyResponse (List<Nanny> nannies, List<CoreError> errors){
        super(errors);
        this.nannies = nannies;
    }


    public List<Nanny> getNannies(){return nannies;}

}
