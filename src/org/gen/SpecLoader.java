package org.gen;

import org.apache.commons.configuration2.HierarchicalConfiguration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.ImmutableNode;
import org.apache.velocity.app.Velocity;
import org.gen.renderers.ControlsRenderer;
import org.gen.renderers.SubsystemRenderer;
import org.gen.specs.*;
import org.gen.renderers.RobotRenderer;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

public class SpecLoader {

    private ArrayList<ControllerSpec> controllers = new ArrayList<>();
    private ArrayList<SubsystemSpec> subsystems = new ArrayList<>();

    public void load(String specFile) {
        Parameters params = new Parameters();
        File propertiesFile = new File(specFile);
        FileBasedConfigurationBuilder<XMLConfiguration> builder =
                new FileBasedConfigurationBuilder<>(XMLConfiguration.class)
                .configure(params.xml()
                .setFile(propertiesFile));
        try {

            HierarchicalConfiguration<ImmutableNode> config = builder.getConfiguration();

            for (HierarchicalConfiguration<ImmutableNode> controller : config.childConfigurationsAt("controllers")) {
                ControllerSpec controlsSpec = new ControllerSpec();
                controlsSpec.setName(controller.getString("name"));
                controlsSpec.setPort(controller.getInt("port"));
                controlsSpec.setType(controller.getString("type"));
                controllers.add(controlsSpec);
            }

            for (HierarchicalConfiguration<ImmutableNode> subsystem : config.childConfigurationsAt("subsystems")) {

                SubsystemSpec subsystemSpec = new SubsystemSpec();
                subsystemSpec.setName(subsystem.getString("name"));

                for (HierarchicalConfiguration<ImmutableNode> motors : subsystem.childConfigurationsAt("motors")) {
                    MotorSpec motor = new MotorSpec();
                    motor.setName(motors.getString("name"));
                    motor.setPort(motors.getInt("port"));
                    motor.setType(motors.getString("type"));
                    motor.setMotorSensor(motors.getString("sensor"));
                    subsystemSpec.addMotor(motor);
                }

               // There should only be one algorithm.
               for (HierarchicalConfiguration<ImmutableNode> algorithm : subsystem.childConfigurationsAt("algorithms")) {
                   AlgorithmSpec algorithmSpec = new AlgorithmSpec();
                   algorithmSpec.setName(algorithm.getString("name"));
                   algorithmSpec.setType(algorithm.getString("type"));
                   subsystemSpec.setAlgorithmSpec(algorithmSpec);
               }

               for (HierarchicalConfiguration<ImmutableNode> sensor : subsystem.childConfigurationsAt("sensors")) {
                    SensorSpec sensorSpec = new SensorSpec();
                    sensorSpec.setName(sensor.getString("name"));
                    sensorSpec.setType(sensor.getString("type"));
                    sensorSpec.setPort(sensor.getInt("port"));
                    subsystemSpec.addSensor(sensorSpec);
               }

               for (HierarchicalConfiguration<ImmutableNode> action : subsystem.childConfigurationsAt("actions")) {
                    ActionSpec actionSpec = new ActionSpec();
                    actionSpec.setmMotor(action.getString("m-motor"));
                    actionSpec.setmSensor(action.getString("m-sensor"));
                    actionSpec.setThreshold(action.getDouble("threshold"));
                    actionSpec.setName(action.getString("name"));
                    actionSpec.setType(action.getString("type"));
                    actionSpec.setController(action.getString("controller"));
                    actionSpec.setValue(action.getString("value"));
                    actionSpec.setReverse(action.getBoolean("reverse"));
                    subsystemSpec.addAction(actionSpec);
               }

               subsystems.add(subsystemSpec);

            }

        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SpecLoader specLoader = new SpecLoader();
        specLoader.load("/Users/Chase.Blagden/IdeaProjects/RobotCodeGen/src/spec.xml");
        Properties p = new Properties();
        p.setProperty("resource.loader", "class");
        p.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(p);
        RobotRenderer robotRenderer = new RobotRenderer();
        ControlsRenderer controlsRenderer = new ControlsRenderer();
        SubsystemRenderer subsystemRenderer = new SubsystemRenderer();
        for (SubsystemSpec subsystemSpec : specLoader.subsystems) {
            subsystemRenderer.render(subsystemSpec);
        }
   //   controlsRenderer.render(specLoader.controllers);
   //   robotRenderer.render(specLoader.subsystems);
    }

}
