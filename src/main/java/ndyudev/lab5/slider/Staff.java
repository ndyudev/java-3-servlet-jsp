package ndyudev.lab5.slider;

import java.util.Date;

public class Staff {
    private String fullName;
    private int age;
    private boolean gender;
    private Date recruit;
    private String country;
    private String photo;
    private int[] hobbies;
    private double salary;

    // 🔹 Constructor không tham số
    public Staff() {
    }

    // 🔹 Constructor đầy đủ
    public Staff(String fullName, int age, boolean gender, Date recruit, String country, String photo, int[] hobbies, double salary) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.recruit = recruit;
        this.country = country;
        this.photo = photo;
        this.hobbies = hobbies;
        this.salary = salary;
    }

    // 🔹 Getter & Setter
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getRecruit() {
        return recruit;
    }

    public void setRecruit(Date recruit) {
        this.recruit = recruit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(int[] hobbies) {
        this.hobbies = hobbies;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // 🔹 Optional: toString() cho debug dễ
    @Override
    public String toString() {
        return "Staff{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", recruit=" + recruit +
                ", country='" + country + '\'' +
                ", photo='" + photo + '\'' +
                ", salary=" + salary +
                '}';
    }
}
