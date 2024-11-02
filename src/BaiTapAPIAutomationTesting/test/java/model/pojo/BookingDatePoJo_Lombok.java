package model.pojo;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class BookingDatePoJo_Lombok {
    private String checkin;
    private String checkout;
}
