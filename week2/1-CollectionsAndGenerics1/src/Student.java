
public class Student {
    private String name;
    private int grade;

    public Student(String string, int i) {
        this.name = string;
        this.grade = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void add(String name, int grade) {
        this.grade = grade;
        this.name = name;
        
    }

    @Override
    public String toString() {
        return "[name = " + name + ", grade = " + grade + " ]";
    }

}

