package org.gen.specs;

public class ActionSpec implements Spec {

    private String name;
    private double threshold;
    private String mMotor;
    private String mSensor;
    private String controller;
    private String value;
    private boolean isReverse;
    public enum InputTypes {
        NoButton,
        AButton,
        BButton,
        XButton,
        YButton,
        Bumper_Left,
        Bumper_Right,
        Trigger_Left,
        Trigger_Right,
        BackButton,
        StartButton,
        getX_Left,
        getX_Right,
        getY_Left,
        getY_Right,
        POV_press,
        POV_top,  // 0 degress
        POV_right, // 90 degress
        POV_bottom, // 180 degrees
        POV_left,// 270 degrees
    }
    private InputTypes type = InputTypes.NoButton;

    // Only for inputs that are not binary.
    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isReverse() {
        return isReverse;
    }

    public void setReverse(boolean reverse) {
        isReverse = reverse;
    }

    public String getmMotor() {
        return mMotor;
    }

    public String getmSensor() {
        return mSensor;
    }

    public void setmSensor(String mSensor) {
        this.mSensor = mSensor;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public void setmMotor(String mMotor) {
        this.mMotor = mMotor;
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
        this.type = InputTypes.valueOf(type);
    }

    @Override
    public String getType() {
        String returnType = type.name();
        if (returnType.contains("Bumper_Left")) {
            returnType = "Bumper(Hand.kLeft)";
        } else if (returnType.contains("Bumper_Right")) {
            returnType = "Bumper(Hand.kRight";
        } else if (returnType.contains("Trigger_Left")) {
            returnType = "TriggerAxis(Hand.kLeft)";
        } else if (returnType.contains("Trigger_Right")) {
            returnType = "TriggerAxis(Hand.kRight)";
        } else if (returnType.contains("getX_Left")) {
            returnType = "X(Hand.kLeft)";
        } else if (returnType.contains("getX_Right")) {
            returnType = "X(Hand.kRight)";
        } else if (returnType.contains("getY_Left")) {
            returnType = "Y(Hand.kLeft)";
        } else if (returnType.contains("getY_Right")) {
            returnType = "Y(Hand.kRight)";
        } else if (returnType.contains("POV_press")) {
            returnType = "POV";
        } else if (returnType.contains("POV_top")) {
            returnType = "POV() == 0";
        } else if (returnType.contains("POV_right")) {
            returnType = "POV() == 90";
        } else if (returnType.contains("POV_bottom")) {
            returnType = "POV() == 180";
        } else if (returnType.contains("POV_left")) {
            returnType = "POV() == 270";
        }
        return returnType;
    }

    public boolean isBinary(String input) {
        if (input.contains("Trigger") || input.contains("getX") || input.contains("getY")) {
            return false;
        }
        return true;
    }
}
