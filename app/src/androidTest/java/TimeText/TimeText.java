/*
 * This is a test 
 * 11/4
 */
package TimeText;

import TestPackages.MessageTest;
import TestPackages.TimeTest;
import javax.swing.GroupLayout;
import javax.swing.JFrame;

/**
 *
 * @author Kade / Laura
 */
public class TimeText {

   /**
    * Creates the GUI and does all the set up for TimeText.
    */
   private static void createAndDisplayGUI() {
      JFrame frame = new JFrame("Time Text");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Between these comments are the code you originally had in the main method.
      // I like to keep the main method just a simple runnable that calls a helper
      // method.
      TimeTest time = new TimeTest();
      MessageTest message = new MessageTest();
      time.testTimeClass();
      message.TestMessage();
      //end;

      GUI gui = new GUI();
      GroupLayout layout = new GroupLayout(frame.getContentPane());
      frame.getContentPane().setLayout(layout);
      layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(gui.getTabPane()));
      layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(gui.getTabPane()));
      frame.pack();
      frame.setVisible(true);
   }

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      javax.swing.SwingUtilities.invokeLater(() -> {
         createAndDisplayGUI();
      });
   }

}
