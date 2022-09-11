package utils;

import commands.*;

import java.util.Scanner;

public class ConsoleWorker {

    private static final Scanner SCANNER = new Scanner(System.in);
    private boolean isRunning;

    public ConsoleWorker() {
        this.isRunning = true;
    }

    public void greet() {
        System.out.println("Welcome to the console client to work with the students database!");
    }

    /**
     * Method that listen commands from console until the command is called
     *
     * @param dataController data controller used to save and update data
     */
    public void listenCommands(DataController dataController) {
        while (isRunning) {
            try {
                AbstractCommand command = readCommand();
                if (command == null) {
                    System.out.println("Unfortunately, there is no such command. Enter one of the existing commands.");
                    continue;
                }
                command.execute(dataController);
                if (dataController.getServerController().saveData(dataController.getStudents()).equals(ConnectionStatus.MALFORMED_HOST)) {
                    isRunning = false;
                    System.out.println("Server closed, connection lost");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Argument is incorrect or empty!");
            }
        }
    }

    private AbstractCommand readCommand() {
        System.out.println("Enter command: ");
        String[] commandLine = SCANNER.nextLine().split(" ");
        String command = commandLine[0];
        String arg = null;
        if (commandLine.length > 1) {
            arg = commandLine[1];
        }
        switch (command) {
            case "list":
                return new ListCommand();
            case "exit":
                isRunning = false;
                return new ExitCommand();
            case "info":
                if (arg == null) {
                    throw new IllegalArgumentException();
                }
                return new InfoCommand(arg);
            case "add":
                if (arg == null) {
                    throw new IllegalArgumentException();
                }
                return new AddCommand(arg);
            case "delete":
                if (arg == null) {
                    throw new IllegalArgumentException();
                }
                return new DeleteCommand(arg);
            default:
                return null;
        }
    }
}
