package service;

import model.*;

import java.util.*;

public class FLCSystem {
    private List<Member> members;
    private Timetable timetable;
    private int bookingCounter = 1;
    private int reviewCounter = 1;

    public FLCSystem() {
        members = new ArrayList<>();
        timetable = new Timetable();
    }

    public void addMember(Member m) {
        members.add(m);
    }

    public void addLesson(Lesson l) {
        timetable.addLesson(l);
    }

    public boolean bookLesson(Member member, Lesson lesson) {
        if (lesson.isFull()) return false;

        for (Booking b : member.getBookings()) {
            if (b.getLesson().getDay().equals(lesson.getDay()) &&
                b.getLesson().getTimeSlot().equals(lesson.getTimeSlot())) {
                return false;
            }
        }

        Booking booking = new Booking(bookingCounter++, member, lesson);
        member.addBooking(booking);
        lesson.addBooking(booking);
        return true;
    }

    public boolean addReview(Booking booking, int rating, String comment) {
        if (booking.getReview() != null) return false;

        Review review = new Review(reviewCounter++, rating, comment);
        booking.setReview(review);
        return true;
    }

    public void generateReport1() {
        for (Lesson lesson : timetable.getAllLessons()) {
            int count = lesson.getBookings().size();
            double avg = lesson.getBookings().stream()
                    .filter(b -> b.getReview() != null)
                    .mapToInt(b -> b.getReview().getRating())
                    .average().orElse(0);

            System.out.println("Lesson: " + lesson.getExcercise()
                    + " | Members: " + count
                    + " | Avg Rating: " + avg);
        }
    }

    public void generateReport2() {
        Map<Excercise, Double> incomeMap = new HashMap<>();

        for (Lesson lesson : timetable.getAllLessons()) {
            double income = lesson.getBookings().size() * lesson.getPrice();
            incomeMap.put(lesson.getExcercise(),
                    incomeMap.getOrDefault(lesson.getExcercise(), 0.0) + income);
        }

        Excercise best = Collections.max(incomeMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println("Highest income exercise: " + best);
    }
}