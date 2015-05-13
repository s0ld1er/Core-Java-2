package annotaion;

import java.util.ArrayList;
import java.util.List;


public class RelatedClass extends ClassInfoTest {
    public static void main(String[] args) {
        List<String> lt = new ArrayList<String>();
        lt.add("sd");
        lt.add("sfsffsafd");
        lt.add("sdfsafsafa");
        lt.add("sdfsafafsaffaaffsaafsa");
        lt.add("sd");
        lt.add("sd");
        lt.add("sd");
        lt.add("sd");
        System.out.println(lt);
    }
    @Override
    public String toString() {
        return RelatedClass.class.getName();
    }
}
