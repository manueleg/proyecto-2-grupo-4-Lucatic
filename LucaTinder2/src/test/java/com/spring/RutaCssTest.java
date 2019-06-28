package com.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RutaCssTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnCssFile() throws Exception {

		this.mockMvc.perform(get("/resources/css/custom.css")).andDo(print()).andExpect(status().isOk());
		// Si quieres que falle, cambia el nombre del CSS
	}

}
