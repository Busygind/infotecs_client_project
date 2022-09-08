package client;

import commands.HelpCommand;

public class App {
    public static void main(String[] args) {

        ConnectionController cc = new ConnectionController();
        ConsoleWorker consoleWorker = new ConsoleWorker();
        consoleWorker.greet();
        DataController dataController = cc.connectToServer();
        HelpCommand commandsList = new HelpCommand();
        commandsList.execute(dataController);
        consoleWorker.listenCommands(dataController);

    }
}

