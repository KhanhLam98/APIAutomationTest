package model.pojo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BookingPoJo_Lombok {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatePoJo_Lombok bookingdates;
    private String additionalneeds;
}
