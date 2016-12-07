import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ReadImage
{
    final static String spec = "http://www.mkyong.com/image/mypic.jpg";

    public static void main( String[] args )
    {
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
        frame.setSize(600, 600);
        JPanel contentPane = new JPanel(){
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                AffineTransform at = AffineTransform.getTranslateInstance(100, 100);
                at.rotate(Math.toRadians(45));
                BufferedImage Apple = (BufferedImage) inPut(spec);
                Graphics2D g2d = (Graphics2D) g;
                g2d.drawImage(Apple, at, null);
                g2d=(Graphics2D)g;
                g2d.setColor(Color.BLACK);
                g2d.drawLine(20, 20, 360, 20);
            }
        };
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
