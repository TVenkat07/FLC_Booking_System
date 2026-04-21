import model.*;
import service.FLCSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FLCSystemTest {

    @Test
    void testBookingSuccess() {
        FLCSystem system = new FLCSystem();
        Member m = new Member(1, "Test");
        Lesson l = new Lesson(1, Excercise.YOGA, "Sat", "Morning", 10);

        system.addMember(m);
        system.addLesson(l);

        assertTrue(system.bookLesson(m, l));
    }
}