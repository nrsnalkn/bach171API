package pojos.herokuapp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingResponseBodyPojo {

    private BookingPojo booking;

    public BookingResponseBodyPojo() {
    }

    public BookingResponseBodyPojo(BookingPojo booking) {

        this.booking = booking;
    }





    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "BookingresponseBodyPojo{" +
                ", booking=" + booking +
                '}';
    }
}

