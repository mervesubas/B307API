package pojos;

public class HerOkuAppPostResponsePojo {

    private Integer bookingid;
    private HerOkuAppGetResponsePojo booking;

    public HerOkuAppPostResponsePojo() {
    }

    public HerOkuAppPostResponsePojo(Integer bookingid, HerOkuAppGetResponsePojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public HerOkuAppGetResponsePojo getBooking() {
        return booking;
    }

    public void setBooking(HerOkuAppGetResponsePojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerOkuAppPostResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}