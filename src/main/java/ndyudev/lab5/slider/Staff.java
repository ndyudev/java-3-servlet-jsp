package ndyudev.lab5.slider;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Staff {
    private String fullName;
    private int age;
    private boolean gender;
    private Date recruit;
    private String country;
    private String photo;
    private int[] hobbies;
    private double salary; 
}
