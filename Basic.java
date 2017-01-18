import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Dimension;

public class Basic extends JFrame{

   public  Basic(){
        this.setSize(640,480); 
        this.setVisible(true);  //will be invisible otherwise
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //this centers the window in the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        setLocation(x, y);
    }

    public static void main(String args[]){
        new Basic();
    }

}
