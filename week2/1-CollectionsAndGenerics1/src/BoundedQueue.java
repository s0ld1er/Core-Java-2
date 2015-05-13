import java.util.ArrayDeque;

public class BoundedQueue implements Queue {
    private ArrayDeque<Integer> bound = new ArrayDeque<Integer>();
    private int size = 0;

    public BoundedQueue(int maxElements) {
        this.size = maxElements;
    }

    public void offer(int element) {
        if (bound.size() < size())
            bound.add(element);
        else {
            bound.removeFirst();
            bound.add(element);
        }
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return this.bound.toString();
    }
}
