package org.usfirst.frc.team3309.gen.renderers;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.usfirst.frc.team3309.gen.specs.ControllerSpec;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ControlsRenderer extends Renderer{

    @Override
    public void render(Object object) {
        ArrayList<ControllerSpec> controllerSpecs = (ArrayList<ControllerSpec>) object;
        context.put("teamName", "3309");
        context.put("controllers", controllerSpecs);
        PrintWriter pw = new PrintWriter(System.out);
        Velocity.mergeTemplate("Controls.vm", Charset.defaultCharset().name(), context, pw);
        pw.flush();
    }

}
