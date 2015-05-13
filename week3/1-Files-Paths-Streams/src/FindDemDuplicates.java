import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class FindDemDuplicates {
    private static final ArrayList<File> listOfAllFiles = new ArrayList<File>();
    private static final ArrayDeque<File> helpStack = new ArrayDeque<File>();

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        File dir = new File("D:/testData");
        System.out.println(listDuplicatingFiles(dir));
    }
    public static final ArrayList<File> listDuplicatingFiles(File dir) throws IOException, NoSuchAlgorithmException {

        helpStack.push(dir);

        while (!helpStack.isEmpty()) {
            File child = helpStack.pop();
            if (child.isDirectory()) {
                for (File f : child.listFiles())
                    helpStack.push(f);
            } else if (child.isFile()) {
                listOfAllFiles.add(child);
            }

        }

        return listOfAllFiles;
    }

    
}
