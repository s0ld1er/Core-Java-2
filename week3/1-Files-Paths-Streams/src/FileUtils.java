import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayDeque;
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
        String fileToText = readFrom(filePath);
        String[] allWords = fileToText.split(" ");
        StringBuilder newFileContent = new StringBuilder();
        Map<String, Integer> mapOfWords = new LinkedHashMap<String, Integer>();

        int wordInd = 0;
        for (String w : allWords) {
            if (!mapOfWords.containsKey(w)) {
                mapOfWords.put(w, wordInd);
                wordInd++;
            }
        }

        newFileContent.append("Original text : ").append(fileToText).append(System.lineSeparator());
        newFileContent.append("Compresssed : ");

        for (String word : allWords) {
            String compressedWord = "~" + mapOfWords.get(word) + " ";
            newFileContent.append(compressedWord);
        }

        newFileContent.append(System.lineSeparator()).append("Legend: " + mapOfWords.toString());
        Path pathToWrite = Paths.get("D:/file.compr");
        writeTo(pathToWrite, newFileContent.toString());
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
            allLines.append(currentLine + System.lineSeparator());
        }
        br.close();
        return allLines.toString();
    }

    public static void writeTo(File file, String text) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(text);
        bw.close();
    }

    public static void writeTo(Path path, String text) throws IOException {
        File file = path.toFile();
        writeTo(file, text);
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
            allLines.append(currentLine + System.lineSeparator());
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
