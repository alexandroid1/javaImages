import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ReadImage
{
    public static void main( String[] args )
    {
        String spec = "http://www.mkyong.com/image/mypic.jpg";
        Image image = inPut(spec);
        outPut(image);
    }

    private static Image inPut(String spec) {
        Image image = null;
        try {
            URL url = new URL(spec);
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static void outPut(Image image) {
        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
}
