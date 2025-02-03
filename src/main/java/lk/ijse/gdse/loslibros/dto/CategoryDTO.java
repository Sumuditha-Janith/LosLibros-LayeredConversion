package lk.ijse.gdse.loslibros.dto;

import lk.ijse.gdse.loslibros.entity.Category;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CategoryDTO {

    private String categoryId;
    private String categoryName;

    public CategoryDTO(Category category) {
        this.categoryId = category.getCategoryId();
        this.categoryName = category.getCategoryName();
    }

}
