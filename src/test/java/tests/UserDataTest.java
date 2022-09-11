package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConnectionController;
import utils.ConnectionStatus;
import utils.DataToConnect;


public class UserDataTest {
    private static final ConnectionController CONNECTION_CONTROLLER = new ConnectionController();

    /**
     * @return data set with incorrect hostname
     */
    @DataProvider(name = "incorrect host")
    public static Object[][] createDataWithIncorrectHost() {
        return new Object[][]{
                new Object[]{DataToConnect.LOGIN.getValue(), DataToConnect.PASSWORD.getValue(), "incorrectHost"}
        };
    }

    /**
     * @return data set with incorrect password
     */
    @DataProvider(name = "incorrect password")
    public static Object[][] createDataWithIncorrectPassword() {
        return new Object[][]{
                new Object[]{DataToConnect.LOGIN.getValue(), "incorrectPassword", DataToConnect.HOST.getValue()}
        };
    }

    /**
     * @return data set with empty login
     */
    @DataProvider(name = "incorrect login")
    public static Object[][] createDataWithEmptyLogin() {
        return new Object[][]{
                new Object[]{"", DataToConnect.PASSWORD.getValue(), DataToConnect.HOST.getValue()}
        };
    }

    /**
     * @param login    user login to connect
     * @param password user password to connect
     * @param host     server hostname
     */
    @Test(description = "Test of system behavior in case that host is incorrect", dataProvider = "incorrect host")
    public void IncorrectHostTest(String login, String password, String host) {
        Assert.assertEquals(CONNECTION_CONTROLLER.connectToServer(login, password, host), ConnectionStatus.UNKNOWN_HOST);
    }

    /**
     * @param login    user login to connect
     * @param password user password to connect
     * @param host     server hostname
     */
    @Test(description = "Test of system behavior in case that password is incorrect", dataProvider = "incorrect password")
    public void IncorrectPasswordTest(String login, String password, String host) {
        Assert.assertEquals(CONNECTION_CONTROLLER.connectToServer(login, password, host), ConnectionStatus.WRONG_PASSWORD);
    }

    /**
     * @param login    user login to connect
     * @param password user password to connect
     * @param host     server hostname
     */
    @Test(description = "Test of system behavior in case that login is empty or incorrect", dataProvider = "incorrect login")
    public void EmptyLoginTest(String login, String password, String host) {
        Assert.assertEquals(CONNECTION_CONTROLLER.connectToServer(login, password, host), ConnectionStatus.INCORRECT_LOGIN);
    }
}
