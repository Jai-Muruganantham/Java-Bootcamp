package babysitting.nannyservice.domain;


import jakarta.persistence.*;

    @Entity
    @Table(name = "nannies")
    public class Nanny {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "surname", nullable = false)
        private String surname;

        @Column(name = "qualification", nullable = false)
        private String qualification;

        @Column(name = "city", nullable = false)
        private String city;

        @Column (name = "userid", nullable = false)
        private Long userid;

      //  @OneToOne
      //  @JoinColumn(name = "user_id") //check if annotation ok
      //  private User user;



        public Nanny() {}

        public Nanny(Long id, String name, String surname, String qualification, String city, Long userid) {
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.qualification = qualification;
            this.city = city;
            this.userid = userid;
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

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public Long getUserid() {
            return userid;
        }

        public void setUserid(Long userid) {
            this.userid = userid;
        }

        @Override
        public String toString() {
            return "Nanny{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", qualification='" + qualification + '\'' +
                    ", city='" + city + '\'' +
                    ", userid=" + userid +
                    '}';
        }
    }


