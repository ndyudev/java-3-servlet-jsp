package ndyudev.lab2.cau4;

public class User {
    private String fullname;
    private boolean gender;
    private String country;

    public User() {
    }

    public User(String fullname, boolean gender, String country) {
        this.fullname = fullname;
        this.gender = gender;
        this.country = country;
    }

    // Getter & Setter
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
