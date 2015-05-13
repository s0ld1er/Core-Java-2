import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class FileDownloader {

    public static void main(String[] args) throws IOException {
        URL linkToFile = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
        String fileName = "Coca cola pic.jpg";

        InputStream inStream = new BufferedInputStream(linkToFile.openStream());
        ByteArrayOutputStream outFile = new ByteArrayOutputStream();

        byte[] buffer = new byte[4096];
        int n = 0;
        while ((n = inStream.read(buffer)) != -1) {
            outFile.write(buffer, 0, n);
        }
        outFile.close();
        inStream.close();

        byte[] response = outFile.toByteArray();

        FileOutputStream outputFile = new FileOutputStream(fileName);
        outputFile.write(response);
        outputFile.close();

        System.out.println("The downloaded file is " + response.length + " bytes long");

    }

}
