package command;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CloseConnectDataBaseCommandTest {
    private CreateConnectDataBaseCommand createConnectDataBaseCommand;
    private String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String password = "root";

    private CloseConnectDataBaseCommand closeConnectDataBaseCommand;

    @Before
    public void setUp() throws Exception {

        createConnectDataBaseCommand = new CreateConnectDataBaseCommand(url, user, password);

        closeConnectDataBaseCommand = new CloseConnectDataBaseCommand();

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void execute() {
        Boolean booleanValue = createConnectDataBaseCommand.execute();
        assertEquals(booleanValue, true);
        booleanValue = closeConnectDataBaseCommand.execute();
        assertEquals(booleanValue, true);
    }
}