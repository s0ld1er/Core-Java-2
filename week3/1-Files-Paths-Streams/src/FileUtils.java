import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUtils {
    public static void main(String[] args) throws Exception {
        File f = new File("D:/tester.txt");
        compress(f);

    }

    private FileUtils() {
    }

    public static void compress(File filePath) throws IOException {
        String file = readFrom(filePath);
        Map<String, Integer> mapOfFile = new LinkedHashMap<String, Integer>();
        StringBuilder newFile = new StringBuilder();
        String[] allWords = file.toLowerCase().split(" ");
        int currentWord = 1;
        ArrayList<String> words = new ArrayList<String>();
        
        for (String s : allWords) {
            words.add(s.replaceAll(" ",""));

        }
//        for(String s : words){
//
//            }
        words.add("dadadadadsasd");
        System.out.println(Arrays.toString(words.toArray()));
        System.out.println();
    }

    public static void fixBrokenStuff(Path path) throws IOException {
        Deque<File> stek = new ArrayDeque<File>();
        stek.push(path.toFile());

        while (!stek.isEmpty()) {
            File child = stek.pop();
            if (Files.isSymbolicLink(child.toPath()) && !Files.exists(Files.readSymbolicLink(child.toPath())))
                System.out.println(child.getAbsolutePath());

            if (child.isDirectory())
                for (File f : child.listFiles())
                    stek.push(f);
            else
                continue;

        }

    }

    public static String reduceFilePath(Path path) {
        return path.normalize().toString();
    }

    public static void fixEncoding(Path path) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        bytes = new String(bytes, "Windows-1251").getBytes("UTF-8");
        Files.write(path, bytes);
    }

    public static Map<String, String> parseProperties(File file) throws IOException {
        Map<String, String> parsed = new HashMap<String, String>();
        String st = readFrom(file);
        StringBuilder curKey = new StringBuilder();
        StringBuilder curVal = new StringBuilder();
        st = st.replaceAll(" ", "");
        BufferedReader bufReader = new BufferedReader(new StringReader(st));
        String curLine = null;
        while ((curLine = bufReader.readLine()) != null) {
            if (curLine.isEmpty())
                continue;

            int firstIndexOfEquals = curLine.indexOf("=");
            curKey.append(curLine.substring(0, firstIndexOfEquals));
            curVal.append(curLine.substring(firstIndexOfEquals + 1, curLine.length()));

            parsed.put(curKey.toString(), curVal.toString());
            curKey.setLength(0);
            curVal.setLength(0);
            System.out.println(curLine);
        }

        return parsed;
    }

    public static String readFrom(Path path) throws IOException {
        return readFrom(new File(path.toString()));
    }

    public static String readFrom(File file) throws IOException {
        StringBuilder allLines = new StringBuilder();
        String currentLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((currentLine = br.readLine()) != null) {
            allLines.append(currentLine + "\n");
        }
        br.close();
        return allLines.toString();
    }

    public static File writeTo(String text) throws IOException {
        File f = new File("D:/testData/writed.txt");
        if (!f.exists())
            f.createNewFile();
        FileOutputStream fos = new FileOutputStream("D:/testData/writed.txt");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        bw.write(text);
        bw.newLine();
        bw.close();

        return f;
    }

    public WordCountResult wordCount(Path path) throws IOException {
        return wordCount(new File(path.toString()));
    }

    public static WordCountResult wordCount(File file) throws IOException {
        WordCountResult wc = new WordCountResult(file);
        StringBuilder allLines = new StringBuilder();
        String currentLine = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        while ((currentLine = br.readLine()) != null) {
            wc.lineCount++;
            wc.charCount += currentLine.length();
            allLines.append(currentLine + "\n");
        }
        br.close();
        wc.wordCount = allLines.length() - allLines.toString().replace(" ", "").length() + 1;
        return wc;

    }

}

class WordCountResult {
    public int lineCount = 0;
    public int wordCount = 0;
    public int charCount = 0;

    public WordCountResult(File file) {
    }

    public WordCountResult(Path path) {
    }

    int getLineCount() {
        return this.lineCount;
    }

    int getWordCount() {
        return this.wordCount;
    }

    int getCharacterCount() {
        return this.charCount;
    }
}
