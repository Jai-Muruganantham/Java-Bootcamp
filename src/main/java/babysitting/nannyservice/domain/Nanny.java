package babysitting.nannyservice.domain;


import jakarta.persistence.*;

    @Entity
    @Table(name = "nannies")
    public class Nanny {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "firstName", nullable = false)
        private String firstName;

        @Column(name = "lastName", nullable = false)
        private String lastName;

        @Column(name = "qualification", nullable = false)
        private String qualification;

        @Column(name = "locationCity", nullable = false)
        private String locationCity;

        @Column (name = "userId", nullable = false)
        private Long userId;

      //  @OneToOne
      //  @JoinColumn(name = "user_id") //check if annotation ok
      //  private User user;



        public Nanny() {}

        public Nanny(Long id, String firstName, String lastName, String qualification, String locationCity, Long userId) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.qualification = qualification;
            this.locationCity = locationCity;
            this.userId = userId;
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

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        @Override
        public String toString() {
            return "Nanny{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", qualification='" + qualification + '\'' +
                    ", locationCity='" + locationCity + '\'' +
                    ", userId=" + userId +
                    '}';
        }
    }


