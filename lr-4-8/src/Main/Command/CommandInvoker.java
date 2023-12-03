package Main.Command;


import java.util.Map;

// Клас, який виконує команди
public class CommandInvoker {
    public void executeCommand(Command command) {
        command.execute();
    }
    public void setCommands(Map<Integer, Command> commands) {
    }
}
