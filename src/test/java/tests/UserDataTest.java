package tests;

import utils.ConnectionController;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConnectionStatus;


public class UserDataTest {
    private static final ConnectionController CONNECTION_CONTROLLER = new ConnectionController();

    @DataProvider(name = "incorrect host")
    public static Object[][] createDataWithIncorrectHost() {
        return new Object[][]{
                new Object[]{"Dmitryb", "Karambola02032003", "incorrectHost"}
        };
    }

    @DataProvider(name = "incorrect password")
    public static Object[][] createDataWithIncorrectPassword() {
        return new Object[][]{
                new Object[]{"Dmitryb", "incorrectPassword", "localhost"}
        };
    }

    @DataProvider(name = "incorrect login")
    public static Object[][] createDataWithEmptyLogin() {
        return new Object[][]{
                new Object[]{"", "Karambola02032003", "localhost"}
        };
    }

    @Test(description = "Test of system behavior in case that host is incorrect", dataProvider = "incorrect host", suiteName = "UserDataChecking")
    public void IncorrectHostTest(String login, String password, String host) {
        Assert.assertEquals(ConnectionStatus.UNKNOWN_HOST, CONNECTION_CONTROLLER.connectToServer(login, password, host));
    }

    @Test(description = "Test of system behavior in case that password is incorrect", dataProvider = "incorrect password", suiteName = "UserDataChecking")
    public void IncorrectPasswordTest(String login, String password, String host) {
        Assert.assertEquals(ConnectionStatus.WRONG_PASSWORD, CONNECTION_CONTROLLER.connectToServer(login, password, host));
    }

    @Test(description = "Test of system behavior in case that login is empty or incorrect", dataProvider = "incorrect login", suiteName = "UserDataChecking")
    public void EmptyLoginTest(String login, String password, String host) {
        Assert.assertEquals(ConnectionStatus.INCORRECT_LOGIN, CONNECTION_CONTROLLER.connectToServer(login, password, host));
    }

}
