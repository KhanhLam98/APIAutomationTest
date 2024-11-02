package model.pojo;

public class BookingDate {
    private String checkin;
    private String checkout;

    //Constructor
    public BookingDate() {
    }

    public BookingDate(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    //Getter & Setter

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
