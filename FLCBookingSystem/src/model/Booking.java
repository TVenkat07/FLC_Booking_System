package model;

public class Booking {
    private int bookingId;
    private Member member;
    private Lesson lesson;
    private Review review;

    public Booking(int bookingId, Member member, Lesson lesson) {
        this.bookingId = bookingId;
        this.member = member;
        this.lesson = lesson;
    }

    public Member getMember() { return member; }
    public Lesson getLesson() { return lesson; }

    public void setReview(Review review) {
        this.review = review;
    }

    public Review getReview() {
        return review;
    }
}