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
        System.out.println("������� IP-����� �������: ");
        host = scanner.nextLine().split(" ")[0];
        System.out.println("������� �����: ");
        login = scanner.nextLine().split(" ")[0];
        System.out.println("������� ������: ");
        password = scanner.nextLine().split(" ")[0];
        try {
            ServerRequestsController serverRequestsController = new ServerRequestsController(login, password, host, PORT);
            return new DataController(serverRequestsController);
        } catch (UnknownHostException e) {
            System.out.println("����������� ����� �������, ���������� ��� ���");
            return connectToServer();
        } catch (FtpLoginException e) {
            System.out.println("�������� ����� ��� ������, ���������� ��� ���");
            return connectToServer();
        } catch (IllegalArgumentException e) {
            System.out.println("����� ��� ������ ������� ������� ��� ������������ ������������ �������, ���������� ��� ���");
            return connectToServer();
        } catch (MalformedURLException e) {
            System.out.println("����� ������� ������ �����������, ���������� ��� ���");
            return connectToServer();
        }  catch (NullPointerException e) {
            System.out.println("������ �����������, ���������� ��� ���");
            return connectToServer();
        } catch (FileNotFoundException e) {
            System.out.println("����� � ������ \"students.json\" ��� �� ��������� �������. "
                    + "��������� ���������� ��������� �������. ���������� ���������.");
            return connectToServer();
        } catch (IOException e) {
            System.out.println("������ ������ ������� ��� ����, ���������� ��� ���");
            return connectToServer();
        }
    }
}
