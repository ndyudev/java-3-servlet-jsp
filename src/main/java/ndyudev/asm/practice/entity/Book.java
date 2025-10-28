package ndyudev.asm.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String idBook;
    private String nameBook;
    private double priceBook;
    private int yearBook;
    private String idCategory;
}