package socket.tcp.ip;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestUDP {
    UDPClient client;

    @Before
    public void setup() {
        new UDPServer().start();
        client = new UDPClient();
    }

    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.send("hello server");
        Assert.assertEquals("hello server", echo);
        echo = client.send("server is working");
        Assert.assertFalse(echo.equals("hello server"));
    }

    @After
    public void tearDown() {
        client.send("end");
        client.close();
    }
}
