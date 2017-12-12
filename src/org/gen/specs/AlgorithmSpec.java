package org.gen.specs;

public class AlgorithmSpec implements Spec {

    private String name;
    public enum Algorithms {
        DriveCheezyDriveEquation,
        DriveArcadeEquation,
        PIDPositionController,
        PIDVelocityController,
        PIDControllerWithFeedForward,
        BlankController
    }

    private Algorithms type = Algorithms.BlankController;

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
        this.type = Algorithms.valueOf(type);
    }

    @Override
    public String getType() {
        return type.name();
    }

}
