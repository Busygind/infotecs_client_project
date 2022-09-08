package client;

import commands.*;

import java.util.Scanner;

public class ConsoleWorker {

    private static final Scanner SCANNER = new Scanner(System.in);
    private boolean isRunning;

    public ConsoleWorker() {
        this.isRunning = true;
    }

    public void greet() {
        System.out.println("Welcome to the console client of the server with the students database!!");
    }

    protected void listenCommands(DataController dataController) {
        while (isRunning) {
            try {
                AbstractCommand command = readCommand();
                if (command == null) {
                    System.out.println("Unfortunately, there is no such command. Enter one of the existing commands.");
                    continue;
                }
                command.execute(dataController);
                dataController.getServerController().saveData(dataController.getStudents());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
                    throw new IllegalArgumentException("This command requires an argument! Try again");
                }
                return new InfoCommand(arg);
            case "add":
                if (arg == null) {
                    throw new IllegalArgumentException("This command requires an argument! Try again");
                }
                return new AddCommand(arg);
            case "delete":
                if (arg == null) {
                    throw new IllegalArgumentException("This command requires an argument! Try again");
                }
                return new DeleteCommand(arg);
            default:
                return null;
        }
    }
}
