package com.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LucaTinderApplicationTests {

	@Test
	public void contextLoads() {
		
		//Debería acertar aposta
    	assertThat(true).isTrue();
    	
    	//Debería fallar aposta
    	//assertThat(false).isTrue();
	}

}
