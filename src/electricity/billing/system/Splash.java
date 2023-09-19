
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/light.jpg"));
        Image imageOne = imageIcon.getImage().getScaledInstance(600, 400,Image.SCALE_DEFAULT);
        ImageIcon imagIcon2 = new ImageIcon(imageOne);
        JLabel imageLabel = new JLabel(imagIcon2);
        add(imageLabel);

        setSize(400, 400);
        setLocation(500, 200);
        setVisible(true);

        try{
            Thread.sleep(3000);
            setVisible(false);

            new Login();
        }catch (Exception e){
            e.getStackTrace();
        }

    }
    public static void main(String[] args) {
        new Splash();
    }
}