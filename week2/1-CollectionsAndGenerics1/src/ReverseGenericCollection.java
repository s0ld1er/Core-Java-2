import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class ReverseGenericCollection {

    public static void reverse(Collection<Object> collection) {
        Deque<Object> reverser = new ArrayDeque<Object>();

        for (Object i : collection)
            reverser.push(i);

        collection.clear();

        while (!reverser.isEmpty())
            collection.add(reverser.pop());
    }
}
