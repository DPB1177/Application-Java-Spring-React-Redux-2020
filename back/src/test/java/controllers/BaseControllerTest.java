package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import database.parametrs.ParameterID;
import database.parametrs.ParametersForConnectionBD;
import database.parametrs.ParametersForSaveXML;
import models.tree.DataTree;
import org.junit.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import runner.Application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BaseController.class)
@ContextConfiguration(classes={Application.class})
// @SpringBootTest(classes = Application.class)
public class BaseControllerTest {
//    @ClassRule
//    public static final SpringClassRule SPRING_CLASS_RULE = new SpringClassRule();
//    @Rule
//    public final SpringMethodRule springMethodRule  = new SpringMethodRule();

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void parameters() throws Exception {
        ParametersForConnectionBD parametersForConnectionBD = new ParametersForConnectionBD();
        parametersForConnectionBD.setPassword("");
        parametersForConnectionBD.setPort("");
        parametersForConnectionBD.setUrl("");
        parametersForConnectionBD.setUser("");
        mockMvc.perform( MockMvcRequestBuilders
                .post("/parameters")
                .content(asJsonString(parametersForConnectionBD))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
                .andExpect(status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.version").value("0.1"))
//                .andDo(MockMvcResultHandlers.print());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.version").exists());

//        mockMvc.perform(get("/parameters")
//                .andExpect(status().isOk())
//                .andExpect(content()
//                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void load() throws Exception {
        ParameterID parameter = new ParameterID();
        parameter.setId("-1");

        mockMvc.perform( MockMvcRequestBuilders
                .post("/load")
                .content(asJsonString(parameter))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isCreated())
                .andExpect(status().is(200));
                //.andExpect(status().isOk());

//        MockHttpSession session = new MockHttpSession();
//        mockMvc.perform( MockMvcRequestBuilders
//                .post("/load")
//                .content(asJsonString(new ParameterID()))
//        .session(session)
//                .accept("application/json"))
//                .andExpect(status().is(415))
//                    .andDo(print()).andReturn();
    }

    @Test
    public void saveXML() throws Exception {
        // DataTree tree = mock(DataTree.class);
        mockMvc.perform( MockMvcRequestBuilders
                .post("/saveXML")
                .content(asJsonString(new ParametersForSaveXML()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isCreated())
                .andExpect(status().is(200));
    }

    @Test
    public void saveXMLTest() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/saveXML")
                .content(asJsonString(new ParametersForSaveXML()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isCreated())
                .andExpect(status().is(200));
    }



    @Test
    public void loadXML() throws Exception {
        ParameterID parameter = new ParameterID();
        parameter.setId("-1");
        mockMvc.perform( MockMvcRequestBuilders
                .post("/loadXML")
                .content(asJsonString(new ParameterID()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                //.andExpect(status().isCreated())
                .andExpect(status().is(200));
    }
}