package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ConnectionController {

    private static final int PORT = 21;
    private static final Scanner scanner = new Scanner(System.in);
    private String host;
    private String login;
    private String password;

    public ConnectionController() {

    }

    protected DataController connectToServer() {
        System.out.println("Enter server IP-address: ");
        host = scanner.nextLine().split(" ")[0];
        System.out.println("Enter login: ");
        login = scanner.nextLine().split(" ")[0];
        System.out.println("Enter password: ");
        password = scanner.nextLine().split(" ")[0];
        try {
            ServerRequestsController serverRequestsController = new ServerRequestsController(login, password, host, PORT);
            return new DataController(serverRequestsController);
        } catch (UnknownHostException e) {
            System.out.println("Unknown IP-address, try again");
            return connectToServer();
        } catch (IllegalArgumentException e) {
            System.out.println("Login or password is incorrect, try again");
            return connectToServer();
        } catch (MalformedURLException e) {
            System.out.println("Server address is incorrect, try again");
            return connectToServer();
        }  catch (NullPointerException e) {
            System.out.println("Connection error, try again");
            return connectToServer();
        } catch (FileNotFoundException e) {
            System.out.println("The file named \"students.json\" is not on the specified server. "
                                       + "Check the contents of the server storage. The connection is broken.");
            return connectToServer();
        } catch (IOException e) {
            System.out.println("The password is wrong or empty, try again");
            return connectToServer();
        }
    }
}
