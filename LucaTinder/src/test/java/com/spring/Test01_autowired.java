package com.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.controller.PerfilController;


public class Test01_autowired {

	/*
	 * The @Autowired annotation is interpreted by the Spring and 
	 * the controller is injected before the test methods are run. 
	 * We are using AssertJ (assertThat() etc.) to express the 
	 * test assertions.
	 */

    @Autowired
    private PerfilController controller;

    @Test
    public void contexLoads() throws Exception {
    	//Como la primera es falsa y es un assert, no sigue a la segunda
    	//assertThat("soy un string").asList();
        assertThat(controller).isNotNull();
        
        //Para asegurar que falla elimina la linea del controlador
        //    @Controller
    }
}
