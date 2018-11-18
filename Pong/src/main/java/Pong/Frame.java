
package Pong;

import javax.swing.JFrame;

public class Frame extends JFrame {
    
    public Frame() {
        setTitle("Counterfeit Pong");
        setSize(1200, 800);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    } 
    
    public void start() {
        add(new Panel());
        setVisible(true);
    }
    
}
