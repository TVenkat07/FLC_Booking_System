package model;

import java.util.ArrayList;
import java.util.List;

public class Lesson {
    private int lessonId;
    private Excercise exerciseType;
    private String day;
    private String timeSlot;
    private double price;
    private int capacity = 4;
    private List<Booking> bookings;

    public Lesson(int lessonId, Excercise exerciseType, String day, String timeSlot, double price) {
        this.lessonId = lessonId;
        this.exerciseType = exerciseType;
        this.day = day;
        this.timeSlot = timeSlot;
        this.price = price;
        this.bookings = new ArrayList<>();
    }

    public boolean isFull() {
        return bookings.size() >= capacity;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public List<Booking> getBookings() { return bookings; }
    public Excercise getExcercise() { return exerciseType; }
    public double getPrice() { return price; }
    public String getDay() { return day; }
    public String getTimeSlot() { return timeSlot; }
}