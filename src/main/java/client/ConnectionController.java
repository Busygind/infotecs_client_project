package client;

import sun.net.ftp.FtpLoginException;
import sun.net.ftp.FtpProtocolException;

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
        System.out.println("Введите IP-адрес сервера: ");
        host = scanner.nextLine().split(" ")[0];
        System.out.println("Введите логин: ");
        login = scanner.nextLine().split(" ")[0];
        System.out.println("Введите пароль: ");
        password = scanner.nextLine().split(" ")[0];
        try {
            ServerRequestsController serverRequestsController = new ServerRequestsController(login, password, host, PORT);
            return new DataController(serverRequestsController);
        } catch (UnknownHostException e) {
            System.out.println("Неизвестный адрес сервера, попробуйте еще раз");
            return connectToServer();
        } catch (FtpLoginException e) {
            System.out.println("Неверный логин или пароль, попробуйте еще раз");
            return connectToServer();
        } catch (IllegalArgumentException e) {
            System.out.println("Логин или пароль указаны неверно или присутствуют недопустимые символы, попробуйте еще раз");
            return connectToServer();
        } catch (MalformedURLException e) {
            System.out.println("Адрес сервера указан некорректно, попробуйте еще раз");
            return connectToServer();
        }  catch (NullPointerException e) {
            System.out.println("Ошибка подключения, попробуйте еще раз");
            return connectToServer();
        } catch (FileNotFoundException e) {
            System.out.println("Файла с именем \"students.json\" нет на указанном сервере. "
                    + "Проверьте содержимое хранилища сервера. Соединение разорвано.");
            return connectToServer();
        } catch (IOException e) {
            System.out.println("Пароль указан неверно или пуст, попробуйте еще раз");
            return connectToServer();
        }
    }
}
