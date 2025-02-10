package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Book;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookDTO {
    private String bookId;
    private String bookName;
    private String authId;
    private String catId;
    private String pubId;
    private String supId;
    private String bookPrice;
    private String bookQuantity;

    public BookDTO(Book book) {
        this.bookId = book.getBookId();
        this.bookName = book.getBookName();
        this.authId = book.getAuthId();
        this.catId = book.getCatId();
        this.pubId = book.getPubId();
        this.supId = book.getSupId();
        this.bookPrice = book.getBookPrice();
        this.bookQuantity = book.getBookQuantity();
    }
}