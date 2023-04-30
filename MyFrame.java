import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits the application when closed

        this.setTitle("Fridge"); //sets the frame title

        this.setSize(420,420); //sets the size of the frame (width x height)

        this.setVisible(true); //makes the frame visible

        ImageIcon image = new ImageIcon("AIcon.png");
        this.setIconImage(image.getImage()); //change icon of frame

        this.getContentPane().setBackground(new Color(88,9,1)); //changes background

        MyLabel myLabel = new MyLabel();
        this.add(myLabel);
    }
}
