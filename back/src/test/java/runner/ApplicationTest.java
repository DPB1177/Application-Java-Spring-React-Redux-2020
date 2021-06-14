package runner;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.SpringApplication;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

//@RunWith(PowerMockRunner.class)

public class ApplicationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @PrepareForTest(SpringApplication.class)
    public void mainTest() {
        //mockStatic(SpringApplication.class);
        Application.main(new String[]{"Hello", "World"});
//        verifyStatic(SpringApplication.class);
//        SpringApplication.run(Application.class, new String[]{"Hello", "World"});
    }

//    private void verifyStatic(Class<SpringApplication> springApplicationClass) {
//    }
}