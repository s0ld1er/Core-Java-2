package listDuplicatingFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ListDuplicatingFiles {

    private static final ArrayList<File> listOfAllFiles = new ArrayList<File>();
    private static final ArrayList<String> fileNames = new ArrayList<String>();
    private static final ArrayDeque<File> helpStack = new ArrayDeque<File>();

    @SuppressWarnings("resource")
    private static final boolean compareTwoFiles(File firstFile, File secondFile) throws IOException,
            NoSuchAlgorithmException {

        final FileReader fileReaderOne = new FileReader(firstFile);
        final FileReader fileReaderTwo = new FileReader(secondFile);

        final BufferedReader readerOne = new BufferedReader(fileReaderOne);
        final BufferedReader readerTwo = new BufferedReader(fileReaderTwo);

        String firstFileLine = null;
        String secondFileLine = null;

        while (true) {
            firstFileLine = readerOne.readLine();
            secondFileLine = readerTwo.readLine();

            if (firstFileLine == null)
                return (secondFileLine == null ? true : false);

            if (!firstFileLine.equals(secondFileLine))
                return false;
        }

    }

    private static final ArrayList<File> listDuplicatingFiles(File dir) throws IOException, NoSuchAlgorithmException {

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

    private static final ArrayList<String> removeDuplicates(ArrayList<File> listOfArrayList)
            throws NoSuchAlgorithmException, IOException {

        for (int i = 0; i < listOfAllFiles.size(); i++) {
            File curFile = listOfAllFiles.get(i);
            final long curFileSize = curFile.length();

            for (int j = 0; j < listOfAllFiles.size(); j++) {
                File otFile = listOfAllFiles.get(j);
                final long otFileSize = otFile.length();

                if (i != j && curFileSize == otFileSize)
                    if (compareTwoFiles(curFile, otFile))
                        listOfAllFiles.remove(curFile);
            }
        }

        for (File f : listOfAllFiles) {
            fileNames.add(f.getName());
        }

        return fileNames;

    }

    public static final void main(String[] args) throws IOException, NoSuchAlgorithmException {
        File currentDir = new File("D:/java");
        long start = System.currentTimeMillis();
        System.out.println(removeDuplicates(listDuplicatingFiles(currentDir)));
        System.out.println(System.currentTimeMillis() - start);
    }
}
