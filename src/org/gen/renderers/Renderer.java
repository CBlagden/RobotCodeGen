package org.gen.renderers;

import org.apache.velocity.VelocityContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Renderer {

    protected VelocityContext context;
    private final String teamName = "3309";
    private DateFormat format = new SimpleDateFormat();

    protected Renderer() {
        context = new VelocityContext();
        context.put("teamName", teamName);
        context.put("date", format.format(new Date()));
    }

    abstract void render(Object object);

}
