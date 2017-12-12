package org.usfirst.frc.team3309.gen.specs;

import java.util.ArrayList;

public class SubsystemSpec {

    private String name;
    private ArrayList<MotorSpec> motors = new ArrayList<>();
    private ArrayList<SensorSpec> sensors = new ArrayList<>();
    private AlgorithmSpec algorithmSpec = new AlgorithmSpec();
    private ArrayList<ActionSpec> actions = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void addMotor(MotorSpec motorSpec) {
        motors.add(motorSpec);
    }

    public MotorSpec getMotor(int i) {
        return motors.get(i);
    }

    public void setMotors(ArrayList<MotorSpec> motors) {
        this.motors = motors;
    }

    public ArrayList<MotorSpec> getMotors() { return motors; }


    public void addSensor(SensorSpec sensorSpec) { sensors.add(sensorSpec); }

    public SensorSpec getSensor(int i) {
        return sensors.get(i);
    }

    public ArrayList<SensorSpec> getSensors() {
        return sensors;
    }

    public void setSensors(ArrayList<SensorSpec> sensors) {
        this.sensors = sensors;
    }


    public AlgorithmSpec getAlgorithmSpec() {
        return algorithmSpec;
    }

    public void setAlgorithmSpec(AlgorithmSpec algorithmSpec) {
        this.algorithmSpec = algorithmSpec;
    }


    public ArrayList<ActionSpec> getActions() {
        return actions;
    }

    public void setActions(ArrayList<ActionSpec> actions) {
        this.actions = actions;
    }

    public void addAction(ActionSpec actionSpec) { actions.add(actionSpec); }
}
