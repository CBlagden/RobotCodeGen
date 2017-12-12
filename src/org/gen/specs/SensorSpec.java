package org.gen.specs;

public class SensorSpec implements Spec {

    private String name;
    private int port;
    private Sensors type = Sensors.NoSensor;

    public enum Sensors {
        NoSensor,
        EncoderSensor,
        CounterSensor,
        ADXRS450_Gyro,
        AnalogInput,
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getType() {
        return type.name();
    }

    @Override
    public void setType(String type) {
        this.type = Sensors.valueOf(type);
    }

}
