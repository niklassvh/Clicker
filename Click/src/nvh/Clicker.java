package nvh;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Random;
public class Clicker {

    public static int clickRate = 10000;

    public static void main(String[] args) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //center of screen
        double width = screenSize.getWidth()/2;
        double height = screenSize.getHeight()/2;
        double distanceX = width/2;
        double distanceY = width/5;
        // up, right, down, left. inverted Y axis
        double[][] direction = {{height -distanceY,width},{height,width +distanceX},{height + distanceY,width},{height,width - distanceX}};
        int arrCount = 0;
        Random rand = new Random();
        System.out.println("Auto clicker to prevent disconnect in games");
        try {
            Robot robot = new Robot();
            while(true) {
                Thread.sleep(clickRate);
                robot.mouseMove((int)direction[arrCount][1],(int)direction[arrCount][0]);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                System.out.println( "x: " +  (int)direction[arrCount][1] + "  y:"+ (int)direction[arrCount][0]);
                arrCount++;

                if (arrCount == 4)
                    arrCount = 0;
            }

        }
        catch(InterruptedException ex){
            System.out.println("Thread error");
        }
        catch (AWTException awt){
            System.out.println("Error with Robot");
        }
    }




    public void onPressEscape(){






    }
}
