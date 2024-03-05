package Application;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import View.VehicleView;
import Controller.VehicleController;

public class VehicleUI {
    
    private JSpinner gasSpinner = new JSpinner();
    private JLabel gasLabel = new JLabel("Amount of gas");

    private int gasAmount = 0;
    private final JButton gasButton = new JButton("Gas");
    private final JButton brakeButton = new JButton("Brake");
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    private final JButton liftBedButton = new JButton("Scania Lift Bed");
    private final JButton lowerBedButton = new JButton("Scania Lower Bed");
    private final JButton startButton = new JButton("Start all cars");
    private final JButton stopButton = new JButton("Stop all cars");
    private final JButton addCarButton =  new JButton("Add a random car");
    private final JButton removeCarButton = new JButton("Remove a random car");
    private final VehicleView view;
    private final VehicleController carC;


    public VehicleUI(VehicleView view, VehicleController carC) {
        this.view = view;
        this.carC = carC;
        // initWidgets();
    }

    public void initWidgets(){
        SpinnerModel spinnerModel =
                new SpinnerNumberModel(99, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.startAllEngines();
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.stopAllEngines();
            }
        });

        ArrayList<JButton> btns = new ArrayList<>();

        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.gas(gasAmount);
            }
        });
        btns.add(gasButton);

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turnTurboOn();
            }
        });
        btns.add(turboOnButton);


        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.liftBed();
            }
        });
        btns.add(liftBedButton);

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.brake(gasAmount);
            }
        });
        btns.add(brakeButton);

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.turnTurboOff();
            }
        });
        btns.add(turboOffButton);
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carC.lowerBed();
            }
        });
        btns.add(lowerBedButton);

        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {carC.addRandomVehicle();}
        });
        removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {carC.removeRandomVehicle();}
        });
        
        view.initGasPanel(gasSpinner, gasLabel);
        view.initControllPanel(btns);
        view.addStartStopButtons(startButton, stopButton);
        view.packWidgets();
    }
}
