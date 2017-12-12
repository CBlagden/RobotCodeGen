package org.usfirst.frc.team3309.gen.renderers;

import org.apache.velocity.app.Velocity;
import org.usfirst.frc.team3309.gen.specs.SubsystemSpec;

import java.io.PrintWriter;
import java.nio.charset.Charset;

public class SubsystemRenderer extends Renderer {

    @Override
    public void render(Object object) {
        SubsystemSpec subsystemSpec = (SubsystemSpec) object;
        context.put("className", subsystemSpec.getName());
        context.put("motors", subsystemSpec.getMotors());
        context.put("sensors", subsystemSpec.getSensors());
        context.put("algorithm", subsystemSpec.getAlgorithmSpec());
        context.put("actions", subsystemSpec.getActions());
        PrintWriter pw = new PrintWriter(System.out);
        Velocity.mergeTemplate("Subsystem.vm", Charset.defaultCharset().name(), context, pw);
        pw.flush();
    }
}
