import command.CloseConnectDataBaseCommandTest;
import command.CreateConnectDataBaseCommandTest;
import command.InvokerTest;
import command.LazyLoadingCommandTest;
import constants.ConstantsTest;
import controllers.BaseControllerTest;
import database.DataBaseManagerTest;
import database.DataBaseMySQLQueriesTest;
import database.RequestsTest;
import database.parametrs.ParameterForSaveXMLTest;
import database.parametrs.ParametersWithNodeTest;
import identifier.IdentifierLongTest;
import json_jackson.ConverterTest;
import loading.ControlTestTest;
import loading.LoadingInformationTest;
import loading.LoadingTreeWithDateBaseTest;
import models.data.InformationTest;
import models.tree.DataTreeTest;
import models.tree.TreeNodeTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import runner.ApplicationTest;
import xml_dom.ElementParserTest;
import xml_dom.ReaderXMLTest;
import xml_dom.TagNodeNamesTest;
import xml_dom.WriterXMLTest;


@Suite.SuiteClasses(
        {
                ApplicationTest.class,
                BaseControllerTest.class,
                IdentifierLongTest.class,
                ControlTestTest.class,
                LoadingInformationTest.class,
                LoadingTreeWithDateBaseTest.class,
                InformationTest.class,
                DataTreeTest.class,
                TreeNodeTest.class,
                ElementParserTest.class,
                TagNodeNamesTest.class,
                ReaderXMLTest.class,
                WriterXMLTest.class,
                ParameterForSaveXMLTest.class,
                ConverterTest.class,
                RequestsTest.class,
                LazyLoadingCommandTest.class,
                CreateConnectDataBaseCommandTest.class,
                CloseConnectDataBaseCommandTest.class,
                ParametersWithNodeTest.class,
                ConstantsTest.class,
                InvokerTest.class,
                DataBaseManagerTest.class,
                DataBaseMySQLQueriesTest.class,

        })
@RunWith(Suite.class)
public class RunTest {
}