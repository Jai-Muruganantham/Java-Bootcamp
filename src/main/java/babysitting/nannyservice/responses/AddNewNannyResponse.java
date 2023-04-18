package babysitting.nannyservice.responses;

import babysitting.nannyservice.domain.Nanny;

import java.util.List;

public class AddNewNannyResponse extends CoreResponse {

    private Nanny newNanny;

    public AddNewNannyResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddNewNannyResponse(Nanny newNanny) {
        this.newNanny = newNanny;
    }

    public Nanny getNewNanny() {
        return newNanny;
    }
}
