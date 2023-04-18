package babysitting.nannyservice.domain;


import jakarta.persistence.*;

    @Entity
    @Table(name = "nannies")
    public class Nanny {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;


        @Column(name = "qualification", nullable = false)
        private String qualification;

        @Column(name = "city", nullable = false)
        private String city;

        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "userid")
        private User user;

        @Column(name = "bio", columnDefinition = "TEXT")
        private String bio;

        @Column(name = "experience")
        private int experience;


        public Nanny() {}


        public Nanny(String qualification, String city, User user, String bio, int experience) {
            this.qualification = qualification;
            this.city = city;
            this.user = user;
            this.bio = bio;
            this.experience = experience;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public int getExperience() {
            return experience;
        }

        public void setExperience(int experience) {
            this.experience = experience;
        }


    }


