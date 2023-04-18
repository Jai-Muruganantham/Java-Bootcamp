package babysitting.nannyservice.requests;

public class AddNewNannyRequest {

    private Integer userid;
    private String city;
    private String qualification;
    private String bio;
    private Integer experience;

    public AddNewNannyRequest(){}

    public AddNewNannyRequest(Integer userid, String city, String qualification, String bio, Integer experience) {
        this.userid = userid;
        this.city = city;
        this.qualification = qualification;
        this.bio = bio;
        this.experience = experience;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "AddNewNannyRequest{" +
                "userid=" + userid +
                ", city='" + city + '\'' +
                ", qualification='" + qualification + '\'' +
                ", bio='" + bio + '\'' +
                ", experience=" + experience +
                '}';
    }
}
