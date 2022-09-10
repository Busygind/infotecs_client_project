import commands.HelpCommand;
import utils.ConnectionController;
import utils.ConnectionStatus;
import utils.ConsoleWorker;
import utils.DataController;

import java.util.Objects;

public class App {
    public static void main(String[] args) {

        ConnectionController cc = new ConnectionController();
        ConsoleWorker consoleWorker = new ConsoleWorker();
        consoleWorker.greet();
        ConnectionStatus connectionStatus = null;
        while (!Objects.equals(connectionStatus, ConnectionStatus.SUCCESS)) {
            connectionStatus = cc.getUserDataAndConnect();
            System.out.println(connectionStatus.getMessage());
        }
        DataController dataController = cc.getDataController();
        HelpCommand commandsList = new HelpCommand();
        commandsList.execute(dataController);
        consoleWorker.listenCommands(dataController);

    }
}

