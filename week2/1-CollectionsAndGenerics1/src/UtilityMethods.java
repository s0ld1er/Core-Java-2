import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UtilityMethods {

    public Map<String, Integer> countWords(String text) {
        Map<String, Integer> myMap = new LinkedHashMap<String, Integer>();
        String[] words = text.split("[^a-zA-Z0-9]");
        for (String w : words) {
            if (!myMap.containsKey(w))
                myMap.put(w, 1);
            else
                myMap.put(w, myMap.get(w) + 1);
        }
        return myMap;
    }

    public String mapReader(HashMap<? extends Object, ? extends Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (Entry<? extends Object, ? extends Object> entry : map.entrySet()) {
            sb.append(" ");
            sb.append(entry.getKey());
            sb.append(":");
            sb.append(entry.getValue());
            sb.append(",");

        }
        sb.replace(sb.length() - 1, sb.length(), " ");
        sb.append("}");
        return sb.toString();

    }

    @SuppressWarnings("unchecked")
    public Set<Integer> returnDuplicates(Set<Integer>... sets) {
        Set<Integer> duplicates = new HashSet<Integer>();

        for (Set<Integer> i : sets)
            duplicates.addAll(i);

        for (Set<Integer> i : sets)
            duplicates.retainAll(i);

        return duplicates;
    }

    public static <T> void findFirstUnique(Collection<T> collection) {
        List<T> colAsList = new ArrayList<T>(collection.size());
        List<T> list = new ArrayList<T>();
        colAsList.addAll(collection);

        for (int i = 0; i < colAsList.size(); i++) {
            if (!list.contains(colAsList.get(i)))
                list.add(colAsList.get(i));
            else
                list.remove(colAsList.get(i));
        }

        System.out.println(list.get(0));
    }

    public <T> void rotate(Collection<T> collection, int rotateStep) {
        ArrayDeque<T> rotated = new ArrayDeque<T>(collection.size());
        rotated.addAll(collection);

        if (rotateStep > 0)
            for (int i = 0; i < rotateStep; i++)
                rotated.push(rotated.removeLast());
        else
            for (int i = rotateStep; i < 0; i++)
                rotated.addLast(rotated.pop());

        System.out.println(rotated);
    }
}
