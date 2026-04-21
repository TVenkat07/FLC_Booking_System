package model;

import java.util.ArrayList;
import java.util.List;

public class Timetable {
    private List<Lesson> lessons;

    public Timetable() {
        lessons = new ArrayList<>();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public List<Lesson> getLessonsByDay(String day) {
        List<Lesson> result = new ArrayList<>();
        for (Lesson l : lessons) {
            if (l.getDay().equalsIgnoreCase(day)) {
                result.add(l);
            }
        }
        return result;
    }

    public List<Lesson> getLessonsByExercise(Excercise type) {
        List<Lesson> result = new ArrayList<>();
        for (Lesson l : lessons) {
            if (l.getExcercise() == type) {
                result.add(l);
            }
        }
        return result;
    }

    public List<Lesson> getAllLessons() {
        return lessons;
    }
}