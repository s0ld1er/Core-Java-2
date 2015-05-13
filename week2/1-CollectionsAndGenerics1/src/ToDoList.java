import java.util.Comparator;
import java.util.PriorityQueue;

public class ToDoList {
    float totalTime;
    float timeNeeded = 0;
    Task task = new Task();
    PriorityQueue<Task> tasks = new PriorityQueue<Task>(10, new Comparator<Task>() {
        @Override
        public int compare(Task firstTask, Task secTask) {
            return firstTask.getPriority() < secTask.getPriority() ? 1
                    : firstTask.getPriority() > secTask.getPriority() ? -1 : 0;
        }
    });

    public ToDoList(float totalTime) {
        this.totalTime = totalTime;
    }

    public ToDoList(int pr) {
        task.setPriority(pr);
    }

    public void addTask(Task t) {
        this.task = t;
        tasks.offer(t);
        timeNeeded += t.getTimeToDo();
    }

    void markFinished(Task t) {
        if (canFinish()) {
            tasks.remove(t);
            timeNeeded -= t.getTimeToDo();
        }
    }

    void markCancelled(Task t) {
        tasks.remove(t);
        timeNeeded -= t.getTimeToDo();
    }

    String getTop() {
        return tasks.peek().getName();
    }

    boolean canFinish() {
        return getRemainigTime() > 0;
    }

    public double getRemainigTime() {
        return totalTime - getTimeNeeded();
    }

    public double getTimeNeeded() {
        return this.timeNeeded;
    }

}

class Task {
    private int priority;
    private float timeToDo;
    String name;

    public Task(float timeToDo) {
        this.timeToDo = timeToDo;
    }

    public Task(int pr) {
        this.priority = pr;
    }

    public Task() {

    }

    public double getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getTimeToDo() {
        return this.timeToDo;
    }

    public void setTimeToDo(float timeToDo) {
        this.timeToDo = timeToDo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class StudyForAlgebraTask extends Task {
    public StudyForAlgebraTask(int hours) {
        this.setName("Study for damn algebra !");
        this.setPriority(10);
        this.setTimeToDo(1);
    }
}

class LearnGeometryTask extends Task {
    public LearnGeometryTask() {
        this.setName("Study for damn geometry !");
        this.setPriority(6);
        this.setTimeToDo(4);
    }
}

class GoOutTask extends Task {
    public GoOutTask(float priority) {
        this.setName("Hf ^^");
        this.setPriority(3);
        this.setTimeToDo(1);
    }
}

class SleepTask extends Task {
    public SleepTask() {
        this.setName("Finally !");
        this.setPriority(8);
        this.setTimeToDo(2);
    }
}