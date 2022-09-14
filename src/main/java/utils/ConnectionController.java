package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConnectionController {

    /**
     * Default server port
     */
    private static final int PORT = 21;
    private static final Scanner scanner = new Scanner(System.in);
    private DataController dataController;

    public DataController getDataController() {
        return dataController;
    }

    /**
     * Method that handling all exceptions during connection
     *
     * @param login    user login to connect
     * @param password user password to connect
     * @param host     server hostname
     * @return connection status as an object
     */
    public ConnectionStatus connectToServer(String login, String password, String host) {
        try {
            ServerRequestsController serverRequestsController = new ServerRequestsController(login, password, host, PORT);
            dataController = new DataController(serverRequestsController);
            return ConnectionStatus.SUCCESS;
        } catch (UnknownHostException e) {
            return ConnectionStatus.UNKNOWN_HOST;
        } catch (NumberFormatException e) {
            return ConnectionStatus.INCORRECT_DATA_IN_FILE;
        } catch (IllegalArgumentException e) {
            return ConnectionStatus.INCORRECT_LOGIN;
        } catch (MalformedURLException e) {
            return ConnectionStatus.MALFORMED_HOST;
        } catch (NullPointerException e) {
            return ConnectionStatus.NULL_POINTER;
        } catch (FileNotFoundException e) {
            return ConnectionStatus.FILE_NOT_FOUND;
        } catch (IOException e) {
            return ConnectionStatus.WRONG_PASSWORD;
        }
    }

    /**
     * Method to recursive invoking connect method
     *
     * @return connection status which is getting from connect method
     */
    public ConnectionStatus getUserDataAndConnect() {
        System.out.println("Enter server IP-address: ");
        String host = scanner.nextLine().split(" ")[0];
        System.out.println("Enter login: ");
        String login = scanner.nextLine().split(" ")[0];
        System.out.println("Enter password: ");
        String password = scanner.nextLine().split(" ")[0];

        return connectToServer(login, password, host);
    }
}
