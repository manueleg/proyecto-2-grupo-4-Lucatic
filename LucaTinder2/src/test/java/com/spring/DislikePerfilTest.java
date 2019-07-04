package com.spring;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.model.Perfil;
import com.spring.repository.PerfilRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class DislikePerfilTest {

	private static Logger logger;
	
	static {
		try {
			logger = LogManager.getLogger(AgregarPerfilTest.class);
		} catch (Throwable e) {
			System.out.println("Logger don't work");
		}
	}

	@BeforeClass
	public static void onceExecutedBeforeAll() {
		logger.info("@BeforeClass: Al inicio de las pruebas");
	}

	@Before
	public void executedBeforeEach() {
		logger.info("@Before: Antes de cada prueba");
	}

	@AfterClass
	public static void onceExecutedAfterAll() {
		logger.info("@AfterClass: Al final de las pruebas");
	}

	@After
	public void executedAfterEach() {
		logger.info("@After: Despues de cada prueba");
	}

	@Ignore
	public void executionIgnored() {
		logger.info("@Ignore: This execution is ignored");
	}
	
	@Autowired
	private PerfilRepository perfilRepo;
	
	@Test
	public void dislikeTest() {
		int cantidadInicial=0;
		int cantidadFinal=0;
		
		//veo los dislikes que hay
		Perfil perfil = new Perfil();
		perfil.setIdusuario(2);
		List<Perfil>perfiles = perfilRepo.getDislikes(perfil);
		cantidadInicial = perfiles.size();
		
		//añado un dislike
		Perfil p1 = new Perfil();
		
		
		assertEquals(cantidadInicial, cantidadFinal-1);
	}

}
