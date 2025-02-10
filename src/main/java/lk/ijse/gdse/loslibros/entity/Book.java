package lk.ijse.gdse.loslibros.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {
    private String bookId;
    private String bookName;
    private String authId;
    private String catId;
    private String pubId;
    private String supId;
    private String bookPrice;
    private String bookQuantity;
}