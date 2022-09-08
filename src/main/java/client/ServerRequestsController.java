package client;

import entities.Student;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.stream.Collectors;

public class ServerRequestsController {

    private static final String FILENAME = "students.json";
    private final String login;
    private final String pass;
    private final String host;
    private final String path;
    private final int port;

    public ServerRequestsController(String login, String pass, String host, int port) {
        this.login = login;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.path = "ftp://" + login + ":" + pass + "@" + host + "/" + FILENAME + ";type=i";
    }

    public String getData() throws IOException {

        URL url = new URL(path);
        InputStream is = url.openStream();
        return new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
    }

    public void saveData(HashSet<Student> students) {
        try {
            URL url = new URL(path);
            StringBuilder dataToUpload = new StringBuilder();
            dataToUpload.append("{\n");
            dataToUpload.append("\"students\": [");
            for (Student student : students) {
                dataToUpload.append(student.toJSONObject());
            }
            dataToUpload.setLength(dataToUpload.length() - 1);
            dataToUpload.append("\n]\n}");

            /*
            File uploading
             */
            URLConnection conn = url.openConnection();
            OutputStream outputStream = conn.getOutputStream();
            InputStream inputStream = new ByteArrayInputStream(dataToUpload.toString().getBytes(StandardCharsets.UTF_8));
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outputStream.close();

            System.out.println("Success!");
        } catch (IOException ex) {
            //todo
            ex.printStackTrace();
        }
    }


}