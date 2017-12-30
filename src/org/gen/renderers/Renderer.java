package org.gen.renderers;

import org.apache.velocity.VelocityContext;

import java.io.File;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Renderer {

    protected VelocityContext context;
    protected final String teamName = "3309";
    private DateFormat format = new SimpleDateFormat();
    protected PrintWriter pw;
    protected File javaFile;
    public static String rootPath = "";

    protected Renderer() {
        context = new VelocityContext();
        context.put("teamName", teamName);
        context.put("date", format.format(new Date()));
    }

    protected abstract void render(Object object);

}
