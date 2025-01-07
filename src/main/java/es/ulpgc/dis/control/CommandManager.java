package es.ulpgc.dis.control;

import es.ulpgc.dis.view.ImageDisplay;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager(ImageDisplay display) {
        commands.put("Next", new NextImageCommand(display));
        commands.put("Prev", new PrevImageCommand(display));
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
