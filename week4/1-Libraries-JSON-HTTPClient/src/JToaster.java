import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.nitido.utils.toaster.Toaster;


public class JToaster {
    public static void main(String[] args) throws IOException {
        Toaster jt = new Toaster();
        BufferedImage bm = ImageIO.read(new File("D:/3f5a00acf72df93528b6bb7cd0a4fd0c.jpeg"));
        
        jt.setBackgroundImage(bm);
        jt.setToasterHeight(bm.getHeight());
        jt.setToasterWidth(bm.getWidth());
        jt.showToaster("Very wow ^_^");
        
        
    }
}
