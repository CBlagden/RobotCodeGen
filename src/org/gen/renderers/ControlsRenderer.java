package org.gen.renderers;

import org.apache.velocity.app.Velocity;
import org.gen.specs.ControllerSpec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ControlsRenderer extends Renderer {

    @Override
    public void render(Object object) {
        ArrayList<ControllerSpec> controllerSpecs = (ArrayList<ControllerSpec>) object;
        context.put("controllers", controllerSpecs);
        javaFile = new File(rootPath + "org/usfirst/frc/team"+ teamName+"/driverstation/Controls.java");
        if (!javaFile.getParentFile().exists()) {
            javaFile.getParentFile().mkdirs();
        }
        try {
            javaFile.createNewFile();
            pw = new PrintWriter(javaFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Velocity.mergeTemplate("org/gen/templates/Controls.vm", Charset.defaultCharset().name(), context, pw);
        pw.flush();
    }

}
