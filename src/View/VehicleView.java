package View;

import javax.swing.*;

// import Controller.VehicleController;
import Model.UpdateListener;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 *  Write more actionListeners and wire the rest of the buttons
 **/

public class VehicleView extends JFrame implements UpdateListener{
    private final int X;
    private final int Y;
    // The controller member
    // VehicleController carC;


    private DrawPanel drawPanel;
    private DrawPanel controlPanel = new DrawPanel();
    private DrawPanel gasPanel = new DrawPanel();


    // Constructor
    public VehicleView(String framename,/*  VehicleController cc, */ int x, int y){
        // this.carC = cc;
        this.drawPanel = new DrawPanel(x, y);
        this.X = x;
        this.Y = y;
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    //  Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y+240));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initFinished() {
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
    }

    public void initControllPanel(ArrayList<JButton> btns) {
        // for (JButton btn : btns) {
        for (int i = 0; i < btns.size(); i++) {
            this.controlPanel.add(btns.get(i),i);
        }
        this.controlPanel.setLayout(new GridLayout(2,4));

        this.controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        this.controlPanel.setBackground(Color.CYAN);
    }

    public void addStartStopButtons(JButton start, JButton stop) {
        start.setBackground(Color.blue);
        start.setForeground(Color.green);
        start.setPreferredSize(new Dimension(X/5-15,200));
        this.add(start);

        stop.setBackground(Color.red);
        stop.setForeground(Color.black);
        stop.setPreferredSize(new Dimension(X/5-15,200));
        this.add(stop);
    }

    public void addItem(int x, int y, String imagePath) {
        drawPanel.addImage(x, y, imagePath);
    }

    public void update() {
        drawPanel.repaint();
    }

    public void initGasPanel(JSpinner gasSpinner, JLabel gasLabel) {
        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
    }
}