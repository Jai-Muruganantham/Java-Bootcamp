package babysitting.nannyservice.requests;

public class SearchNanniesRequest {

    private Long id;
    private String name;
    private String city;

    public SearchNanniesRequest() {
    }

    public SearchNanniesRequest(String name, String city) {
        this.name = name;
        this.city = city;
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

    public SearchNanniesRequest(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isNameProvided() {
        return this.name != null && !this.name.isEmpty();
    }

    public boolean isCityProvided() {
        return this.city != null && !this.city.isEmpty();
    }

    public boolean isIdProvided() {
        return this.id != null && this.id > 0;
    }

}
