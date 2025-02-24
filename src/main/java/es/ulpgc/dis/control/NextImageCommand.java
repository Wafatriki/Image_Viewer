package es.ulpgc.dis.control;

import es.ulpgc.dis.view.ImageDisplay;

public class NextImageCommand implements Command {
    private final ImageDisplay display;

    public NextImageCommand(ImageDisplay display) {
        this.display = display;
    }

    @Override
    public void execute() {
        display.show(display.image().next());
    }
}