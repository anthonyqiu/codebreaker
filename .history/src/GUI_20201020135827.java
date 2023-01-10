import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{

    public GUI(){
        setTitle("CODE BREAKER");
        setSize(400, 400);
        JTextField menu = new JTextField("Menu");
        JButton playerGuess = new JButton("Player Guess");
        setVisible(true);
    }
    
}
