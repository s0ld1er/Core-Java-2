import java.util.Comparator;

public class GradeCompa implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.getGrade() > b.getGrade() ? 1 : a.getGrade() < b.getGrade() ? -1 : compareGr(a, b);
    }

    public int compareGr(Student a, Student b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}