package org.gen.renderers;

import org.apache.velocity.app.Velocity;
import org.gen.specs.SubsystemSpec;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class RobotRenderer extends Renderer {

    @Override
    public void render(Object object) {
        ArrayList<SubsystemSpec> subsystems =(ArrayList<SubsystemSpec>) object;
        context.put("subsystems", subsystems);
        PrintWriter pw = new PrintWriter(System.out);
        Velocity.mergeTemplate("org/gen/templates/Robot.vm", Charset.defaultCharset().name(), context, pw);
        pw.flush();
    }
}
