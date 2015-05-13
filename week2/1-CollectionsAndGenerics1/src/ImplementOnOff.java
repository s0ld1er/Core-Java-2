import java.util.Collection;

public class ImplementOnOff {
    private Collection<Integer> coll;

    public ImplementOnOff(Collection<Integer> collection) {
        this.coll = collection;
    }

    public void add(int element) {
        if (coll.contains(element))
            coll.remove(element);
        else
            coll.add(element);
    }

    public String toString() {
        return this.coll.toString();
    }

}
