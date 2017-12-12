package org.gen.specs;

public class MotorSpec implements Spec{

    private int port;
    private String name = "";
    private String type = "";
    public enum MotorSensors {
        NoSensor,
        AnalogEncoder,
        QuadEncoder
    }
    private MotorSensors motorSensor = MotorSensors.AnalogEncoder;

    public void setPort(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setMotorSensor(String motorSensor) {
       this.motorSensor = MotorSensors.valueOf(motorSensor);
    }

    public String getMotorSensor() {
        return motorSensor.name();
    }
}
