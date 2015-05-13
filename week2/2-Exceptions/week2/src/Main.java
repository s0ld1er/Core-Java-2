
public class Main {
    public static void main(String[] args) {
        NoNullsMap nn = new NoNullsMap();
        System.out.println(nn.put("kor", 2));
        //nn.put(null, 2);
        System.out.println(nn.put(25, "wgat"));
        //nn.put(0.2, null);
        
        System.out.println(nn.toString());

    }
}
