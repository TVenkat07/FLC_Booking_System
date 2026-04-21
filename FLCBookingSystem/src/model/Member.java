package model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int memberId;
    private String name;
    private List<Booking> bookings;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.bookings = new ArrayList<>();
    }

    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public List<Booking> getBookings() { return bookings; }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
}