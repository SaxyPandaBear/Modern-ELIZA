package com.eliza;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Andrew on 4/1/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TextBotControllerTest {

    TestRestTemplate restTemplate;

    public void foo(){
        assert(true);
    }
}
