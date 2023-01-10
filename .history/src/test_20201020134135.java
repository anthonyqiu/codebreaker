import javax.swing.*;//You need these two libraries to do the GUI stuff
import java.awt.*;

public class test extends JFrame //You are telling Java that this is a GUI application
{ 
  
  // *** CREATE THE GUI COMPONENTS: Here we are only creating the following: Buttons, Labels, and Text field
  
  
  // **********                      
  
  // *** CONSTRUCTOR - Has the same name as the class and it runs once (when the program begins)
  // This is were the GUI should be configured.
  
  public test() //This section adds the components on to the frame
  { 
    setTitle("Hello World!");  //Set the window title or  frame
    setSize(640, 480);         //Set the dimensions of
    
    //Flow layout fills each row with the GUI components that you add and it will
    //go to the next row when the previour row fills up -- WE WILL TALK ABOUT THIS IN THE NEXT FEW TUTORIALS    
    FlowLayout fl1 = new FlowLayout(); //used to organize window
    
    setLayout(fl1);                    //organize the layout for the whole frame 
    
    /*add(okButton);          // add the button to the frame
    add(nameLabel);         // add the label to the frame
    add(nameField);         // add the text field to the frame 
    setVisible(true);       // display the gui on the screen
    */
  }
    
}
