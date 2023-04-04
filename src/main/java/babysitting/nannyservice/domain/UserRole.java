package babysitting.nannyservice.domain;

public enum UserRole {
    ADMIN("admin"),
    NANNY("nanny"),
    PARENT("parent");

    private String role;

    UserRole(String role) {
        this.role = role;
    }
}

