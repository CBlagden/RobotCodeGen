package org.usfirst.frc.team3309.gen.renderers;

import org.apache.velocity.app.Velocity;
import org.usfirst.frc.team3309.gen.specs.SubsystemSpec;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class RobotRenderer extends Renderer {

    @Override
    public void render(Object object) {
        ArrayList<SubsystemSpec> subsystems =(ArrayList<SubsystemSpec>) object;
        context.put("subsystems", subsystems);
        PrintWriter pw = new PrintWriter(System.out);
        Velocity.mergeTemplate("Robot.vm", Charset.defaultCharset().name(), context, pw);
        pw.flush();
    }
}
