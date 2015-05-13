import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static Set<String> allWords = new HashSet<String>();

    public static void generateWords() {
        String thisLine = null;
        try {
            InputStream fis = new FileInputStream("D:/enable1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            while ((thisLine = br.readLine()) != null) {
                allWords.add(thisLine.toLowerCase());
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(allWords.size());
    }

    public static void main(String[] args) {
        ToDoList todo = new ToDoList(11f); // 11 hours remaining!
        todo.addTask(new LearnGeometryTask()); // default priority, smaller than
                                               // 10
        todo.addTask(new GoOutTask(1.5f)); // default priority, smaller than 10
        todo.addTask(new SleepTask()); // straight 8 hours, of course!
        todo.addTask(new StudyForAlgebraTask(10)); // maximum priority!

        if (todo.canFinish()) {
            System.out.println("I can totaly cope with those shit");
        } else {
            System.out.println("I am ...god damn screwed");
        }

        System.out.println(todo.getTop()); // StudyForAlgebraTask
        System.out.println(todo.getTimeNeeded()); // sum of the time needed for
                                                  // every task added in todo
                                                  // list
        System.out.println(todo.getRemainigTime());
        todo.markCancelled(todo.tasks.peek());
        System.out.println(todo.getRemainigTime());
        System.out.println(todo.tasks);

        generateWords();
        String test = "Ajb vnf guj luqv akjvojufq  . Sk qkkj egvfs Rkhfwu Lumemu'q "
                + "akhhfjvq kj vnf ohifjbojc essoxew kg Dofck Ckqve , nfsf'q Ffsjejbk Tkssfq "
                + "vk qnkr vnf ohifvukuq zkujc dkz nkr ov'q bkjf    Iv'q vnf qehf fxfsz quhhfs . "
                + "Nk-kjf neq fxfs coxfj hf ejzvnojc kj e iwevf . Tnfz hebf hf akhifvf gks hz iweaf "
                + "vnf xfsz hkhfjv I ckv ojvk vnf gosqv vfeh; vnev'q rnev vnfz veucnv hf ejb ov'ww df "
                + "vnev rez ujvow I wfexf . Tnf nocnfs puewovz iwezfsq vnev akhf - ejb Dofck Ckqve oq "
                + "puewovz - vnf csfevfs vnf akhifvovokj roww df ejb vnf dfvvfs ov'ww df gks vnf vfeh "
                + ".Ajb gfes jkv ( ks , ewvfsjevoxfwz , bkj'v cfv vkk ftaovfb)  , Tkssfq neq jk iwejq "
                + "vk vuam veow ejb suj ejb wfexf noq iezanfamq dfnojb .    I bkj'v nexf ejz iwejq vk "
                + "hkxf erez socnv jkr .    Ig rf woqvfjfb vk eww vnf suhkusq rf'b nexf 50 iwezfsq . Nkr'"
                + "q jkv vnf socnv vohf vk df vnojmojc edkuv Cnfwqfe . I'h qusf vnf awud oq rksmojc vk "
                + "ohiskxf vnf vfeh , duv eww vnev hevvfsq socnv jkr oq vnf Wkswb Cui .Om , vnev dov edkuv "
                + "vnf iwezfsq hebf hf anuamwf .  Noaf kjf , Ffsjejbk .Nkr , oj ej obfew rkswb , rf "
                + "rkuwb ifsneiq cfv vnfqf rksbq gskh Lumemu , rnkh rf'b womf vk dfakhf wfcfjbesz ev Cnfwqfe .  "
                + "Buv rf bkj'v woxf oj ej obfew rkswb , ejb ojqvfeb rf cfv vnfqf rksbq gskh Tkssfq , "
                + "rnkh rf'b womf vk dfakhf e wkjc-gksckvvfj hfhksz ev Cnfwqfe .  Aweq .Tnev dfojc qeob , "
                + "qojaf ov'q deqoaewwz ej ohikqqodwf vk veqm vk sob kusqfwxfq kg vnf gwki , ev wfeqv "
                + "nf'q ckv vnf socnv evvovubf .  Hussez?";
        String orig = test;
        StringBuilder ne = new StringBuilder();
        for (char c : test.toCharArray()) {
            if (!Character.isAlphabetic(c))
                ne.append(c);
            else if (Character.isUpperCase(c))
                ne.append(c);
            else if (c == 'a')
                ne.append('c');
            else if (c == 'b')
                ne.append('d');
            else if (c == 'c')
                ne.append('g');
            else if (c == 'd')
                ne.append('b');
            else if (c == 'e')
                ne.append('a');
            else if (c == 'f')
                ne.append('e');
            else if (c == 'g')
                ne.append('f');
            else if (c == 'h')
                ne.append('m');
            else if (c == 'i')
                ne.append('p');
            else if (c == 'j')
                ne.append('n');
            else if (c == 'k')
                ne.append('o');
            else if (c == 'l')
                ne.append('j');
            else if (c == 'm')
                ne.append('k');
            else if (c == 'n')
                ne.append('h');
            else if (c == 'o')
                ne.append('i');
            else if (c == 'p')
                ne.append('q');
            else if (c == 'q')
                ne.append('s');
            else if (c == 'r')
                ne.append('w');
            else if (c == 's')
                ne.append('r');
            else if (c == 't')
                ne.append('&');
            else if (c == 'u')
                ne.append('u');
            else if (c == 'v')
                ne.append('t');
            else if (c == 'w')
                ne.append('l');
            else if (c == 'x')
                ne.append('v');
            else if (c == 'y')
                ne.append('%');
            else if (c == 'z')
                ne.append('y');
        }

        System.out.println(ne);
        System.out.println();
        System.out.println();
        System.out.println(orig);
        System.out.println();

        String[] words = test.split("[^a-zA-Z0-9]");
        for (String s : words) {
            if (s.contains("t")) {
                System.out.println(s);
            }
        }
        System.out.println();
        String longestWord = "tkssfq";
        String longzzzRepl = "*orres";

        for (String s : allWords) {
            if (s.length() == 4 && s.contains("ust"))
                System.out.println(s);
        }

    }
}
