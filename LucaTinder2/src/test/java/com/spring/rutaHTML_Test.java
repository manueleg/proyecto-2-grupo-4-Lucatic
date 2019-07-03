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


/**
 * 
 * @author David Nombre de clase: rutaHTML_Test Descripcion: Testing con Junit de la ruta HTML  Fecha: 03/07/2019
 * @version: v1.0
 *
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class rutaHTML_Test {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnHTMLFile() throws Exception {

		this.mockMvc.perform(get("/resources/templates/perfil.html")).andDo(print()).andExpect(status().isOk());
		// Si quieres que falle, cambia el nombre del HTML
	}

}
