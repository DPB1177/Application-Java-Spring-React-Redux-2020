package command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CreateConnectDataBaseCommandTest {
    private CreateConnectDataBaseCommand createConnectDataBaseCommand;
    private String url = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private String user = "root";
    private String password = "root";

    @Mock
    CreateConnectDataBaseCommand mockCreateConnectDataBaseCommand;

    @Before
    public void setUp() throws Exception {
        createConnectDataBaseCommand = new CreateConnectDataBaseCommand(url, user, password);
    }

    @Test
    public void execute() {
        Boolean booleanValue = createConnectDataBaseCommand.execute();
        assertEquals(booleanValue, true);

        when(mockCreateConnectDataBaseCommand.execute()).thenReturn(false);
        assertEquals(mockCreateConnectDataBaseCommand.execute(),false);

        createConnectDataBaseCommand = new CreateConnectDataBaseCommand("", "", "");
        booleanValue = createConnectDataBaseCommand.execute();
        assertEquals(booleanValue, true);
    }
}