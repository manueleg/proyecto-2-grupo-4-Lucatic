package com.spring;

import static org.junit.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.repository.PerfilRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecuperarPerfilTest {

		private static Logger logger;

		// Inicializo
		static {
			try {
				logger = LogManager.getLogger(RecuperarPerfilTest.class);
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

		// --------
		// TEST
		// --------

		@Autowired
		private PerfilRepository perfilRepo;
		
		@Test
		public void RecuperarPerfilTest() {

			boolean existe = false;

			try {
				logger.info("--Recuperando elemento de la base de datos");
				if(perfilRepo.findById(5)!=null) {
					existe=true;
					logger.info("--Elemento recuperado");
				};

				assertEquals(existe, true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
