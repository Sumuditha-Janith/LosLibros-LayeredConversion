package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Publisher;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class PublisherDTO {

    private String publisherId;
    private String publisherName;

    public PublisherDTO(Publisher publisher) {
        this.publisherId = publisher.getPublisherId();
        this.publisherName = publisher.getPublisherName();
    }

}
