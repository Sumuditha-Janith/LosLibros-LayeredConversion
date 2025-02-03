package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Author;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AuthorDTO {

    private String authorId;
    private String authorName;

    public AuthorDTO(Author author) {
        this.authorId = author.getAuthorId();
        this.authorName = author.getAuthorName();
    }
}
