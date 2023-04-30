import javax.swing.*;

public class MyLabel extends JLabel {

    public MyLabel() {
        this.setText("Smart Fridge"); //sets the text on the label

        ImageIcon image = new ImageIcon("FridgeIcon.jpg");
        this.setIcon(image);

        this.setHorizontalTextPosition(this.CENTER);
    }

}
