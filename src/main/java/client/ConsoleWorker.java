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
        System.out.println("Добро пожаловать в консольный клиент кафедрального сервера с базой данных студентов!");
    }

    public void listenCommands(DataController dataController) {
        while (isRunning) {
            try {
                AbstractCommand command = readCommand();
                if (command == null) {
                    System.out.println("К сожалению, такой команды нет. Введите одну из существующих команд.");
                    continue;
                }
                command.execute(dataController);
                dataController.getConnection().saveData(dataController.getStudents());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private AbstractCommand readCommand() {
        System.out.println("Введите команду: ");
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
                    throw new IllegalArgumentException("Это команда требует аргумент! Попробуйте еще раз");
                }
                return new InfoCommand(arg);
            case "add":
                if (arg == null) {
                    throw new IllegalArgumentException("Это команда требует аргумент! Попробуйте еще раз");
                }
                return new AddCommand(arg);
            case "delete":
                if (arg == null) {
                    throw new IllegalArgumentException("Это команда требует аргумент! Попробуйте еще раз");
                }
                return new DeleteCommand(arg);
            default:
                return null;
        }
    }

}
