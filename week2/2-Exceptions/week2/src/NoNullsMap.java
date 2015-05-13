import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class NoNullsMap extends HashMap<Object, Object> {
    Map<Object, Object> myMap = new HashMap<Object, Object>();

    public Object put(Object key, Object value) {
        if (key != null && value != null)
            myMap.put(key, value);
        else
            throw new IllegalArgumentException();
        return value;
    }

    public Object get(Object atKey) {
        if (myMap.containsKey(atKey))
            return myMap.get(atKey);
        else
            throw new IllegalAccessError();

    }

    
    @Override
    public String toString() {
        return myMap.toString();
    }
}
