package model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CreateBookPOJO_AnhTester {
    private String name;
    private int category_id;
    private long price;
    private String release_date;
    private boolean status;
    private List image_ids;
}
