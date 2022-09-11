package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.ConnectionStatus;
import utils.DataToConnect;
import utils.ServerRequestsController;

import java.util.HashSet;

public class ConnectionLostTest {

    private static final ServerRequestsController SERVER_REQUESTS_CONTROLLER =
            new ServerRequestsController(DataToConnect.LOGIN.getValue(), DataToConnect.PASSWORD.getValue(), "disabledHost", 21);

    @BeforeTest
    public void connectToServer() {
        // Можно дописать логику для случая непрерывной работы сервера, тогда предварительно к нему нужно будет подключиться
    }

    // Для теста попробуем отправить запрос на несуществующий сервер, это будет равносильно выключению текущего сервера
    @Test(description = "test system on sending data to disabled server")
    public void sendDataToDisabledServer() {
        Assert.assertEquals(SERVER_REQUESTS_CONTROLLER.saveData(new HashSet<>()), ConnectionStatus.MALFORMED_HOST);
    }

}
