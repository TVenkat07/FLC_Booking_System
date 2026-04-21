package main;

import model.*;
import service.FLCSystem;

public class main {
    public static void main(String[] args) {
        FLCSystem system = new FLCSystem();

        Member m1 = new Member(1, "Alice");
        Member m2 = new Member(2, "Bob");

        system.addMember(m1);
        system.addMember(m2);

        Lesson l1 = new Lesson(1, Excercise.YOGA, "Saturday", "Morning", 10);
        Lesson l2 = new Lesson(2, Excercise.ZUMBA, "Sunday", "Evening", 12);

        system.addLesson(l1);
        system.addLesson(l2);

        system.bookLesson(m1, l1);
        system.bookLesson(m2, l1);

        Booking b = m1.getBookings().get(0);
        system.addReview(b, 5, "Great!");

        system.generateReport1();
        system.generateReport2();
    }
}
