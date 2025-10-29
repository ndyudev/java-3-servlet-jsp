package ndyudev.asm.topic2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private String masv;
	private String hoten;
	private int namsinh;
	private Boolean gioitinh;
	private String makhoa;
}
