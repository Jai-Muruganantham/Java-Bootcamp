package babysitting.nannyservice.domain;


import jakarta.persistence.*;

    @Entity
    @Table(name = "nannies")
    public class Nanny {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(name = "qualification", nullable = false)
        private String qualification;

        @Column(name = "location_city", nullable = false)
        private String locationCity;

      //  @OneToOne
      //  @JoinColumn(name = "user_id") //check if annotation ok
      //  private User user;

        @Column (name = "user_id", nullable = false)
        private Long user_id;

        public Nanny() {}

        public Nanny(String firstName, String lastName, String qualification, String locationCity, Long user_id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.qualification = qualification;
            this.locationCity = locationCity;
            this.user_id = user_id;
        }


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getLocationCity() {
            return locationCity;
        }

        public void setLocationCity(String locationCity) {
            this.locationCity = locationCity;
        }

        public Long getUser_id() {
            return user_id;
        }

        public void setUser_id(Long user_id) {
            this.user_id = user_id;
        }

        @Override
        public String toString() {
            return "Nanny{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", qualification='" + qualification + '\'' +
                    ", locationCity='" + locationCity + '\'' +
                    ", user_id=" + user_id +
                    '}';
        }
    }


