package babysitting.nannyservice.requests;

public class SearchNanniesRequest {

    private Long id;
    private String city;

    public SearchNanniesRequest() {
    }


    public SearchNanniesRequest(String city) {
        this.city = city;
    }

    public SearchNanniesRequest(Long id) {
        this.id = id;
    }

    public SearchNanniesRequest(Long id, String city) {
        this.id = id;
        this.city = city;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public boolean isCityProvided() {
        return this.city != null && !this.city.isEmpty();
    }

    public boolean isIdProvided() {
        return this.id != null && this.id > 0;
    }

}
