package ndyudev.lab7.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
public class Employee {
	String id;
	String fullname;
	String password;
	Boolean gender;
	Date birthday;
	String photo;
	Double salary;
	String departmentid;
}
