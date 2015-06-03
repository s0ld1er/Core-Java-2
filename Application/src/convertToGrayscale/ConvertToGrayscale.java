package convertToGrayscale;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class ConvertToGrayscale {

    private static final void ConvertImageToGrayscale(Path imgPath) throws IOException {

        Color imgColor, newColor;
        final File inputImage = new File(imgPath.toString());
        final BufferedImage bufferImage = ImageIO.read(inputImage);

        final int imgHeight = bufferImage.getHeight();
        final int imgWidth = bufferImage.getWidth();

        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {

                // getting the RBG color of each pixel at (i,j) position
                imgColor = new Color(bufferImage.getRGB(i, j));

                // Luma coding in video systems from
                // http://en.wikipedia.org/wiki/Grayscale
                // converting the R,B and G color of each pixel

                int colorSum = (int) (imgColor.getRed() * 0.2126) + (int) (imgColor.getBlue() * 0.0722)
                        + (int) (imgColor.getGreen() * 0.7152);

                // getting the new color from the convertion
                newColor = new Color(colorSum, colorSum, colorSum);

                // setting the new color to the specified pixel
                bufferImage.setRGB(i, j, newColor.getRGB());
            }
        }

        final File outputImage = new File("inputFileGrayscale.jpg");

        // the img would be either jpg, bmp or png so there are three cases of
        // how the output file should be written.
        if (imgPath.toString().endsWith(".jpg"))
            ImageIO.write(bufferImage, "jpg", outputImage);
        else if (imgPath.toString().endsWith(".bmp"))
            ImageIO.write(bufferImage, "bmp", outputImage);
        else if (imgPath.toString().endsWith(".png"))
            ImageIO.write(bufferImage, "png", outputImage);

    }

    static public void main(String args[]) throws Exception {

        // to test the program put the path of your image in to the
        // pathToPicture file
        Path pathToPicture = Paths.get("D:/test.jpg");
        ConvertImageToGrayscale(pathToPicture);
    }
}