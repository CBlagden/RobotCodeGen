package org.gen.renderers;

import org.apache.velocity.app.Velocity;
import org.gen.specs.SubsystemSpec;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class RobotRenderer extends Renderer {

    @Override
    public void render(Object object) {
        ArrayList<SubsystemSpec> subsystems =(ArrayList<SubsystemSpec>) object;
        context.put("subsystems", subsystems);
        javaFile = new File("org/usfirst/frc/team"+teamName+"/robot/Robot.java");
        if (!javaFile.getParentFile().exists()) {
            javaFile.getParentFile().mkdirs();
        }
        try {
            javaFile.createNewFile();
            pw = new PrintWriter(javaFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Velocity.mergeTemplate("org/gen/templates/Robot.vm", Charset.defaultCharset().name(), context, pw);
        pw.flush();
    }
}
