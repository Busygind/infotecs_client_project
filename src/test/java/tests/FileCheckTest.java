package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utils.ConnectionController;
import org.testng.annotations.DataProvider;
import utils.ConnectionStatus;
import utils.JSONParser;

public class FileCheckTest {

    private static final JSONParser PARSER = new JSONParser();

    @DataProvider(name = "empty data")
    public static Object[][] createEmptyString() {
        return new Object[][]{
                new Object[]{""}
        };
    }

    @DataProvider(name = "incorrect data")
    public static Object[][] createIncorrectString() {
        return new Object[][]{
                new Object[]{"someIncorrectString {}{fdss name name }]]] a { id: 111"}
        };
    }

    @Ignore
    @DataProvider(name = "data to connect to server without desire file")
    public static Object[][] createDataToConnectToEmptyHost() {
        return new Object[][]{
                new Object[]{"login", "pass", "host"}
        };
    }

    @Test(dataProvider = "empty data")
    public void emptyDataCheck(String data) {
        Assert.assertTrue(PARSER.parseData(data).isEmpty());
    }

    @Test(dataProvider = "incorrect data")
    public void incorrectDataCheck(String data) {
        Assert.assertTrue(PARSER.parseData(data).isEmpty());
    }

    /**
     * Test that indicate that file with desire name is not found
     *
     * @param login user login
     * @param pass  user password
     * @param host  server hostname
     */
    // У меня имеется доступ только к одному серверу, и если на нем удалить необходимый файл, то не пройдут все остальные тесты.
    // Поэтому, для всего test-suite прошу считать этот тест невалидным. Но при желании его можно запустить и проверить на пустом сервере,
    // чтобы убедиться, что системой этот вариант обрабатывается
    @Ignore
    @Test(description = "test that indicate that file with desire name is not found", dataProvider = "data to connect to server without desire file")
    public void fileDoesNotExistCheck(String login, String pass, String host) {
        ConnectionController connectionController = new ConnectionController();
        Assert.assertEquals(connectionController.connectToServer(login, pass, host), ConnectionStatus.FILE_NOT_FOUND);
    }
}
