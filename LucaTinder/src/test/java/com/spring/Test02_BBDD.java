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
import com.spring.repository.PerfilRepository;

public class Test02_BBDD {
	private static Logger logger;
	// Inicializo
	static {
		try {
			logger = LogManager.getLogger(Test02_BBDD.class);
		} catch (Throwable e) {
			System.out.println("Don't work");
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
	// Puedes usarlo en vez de comentar el mÃ©todo para que no se ejecute
	// http://junit.sourceforge.net/javadoc/org/junit/Ignore.html
	public void executionIgnored() {
		logger.info("@Ignore: This execution is ignored");
	}

	// --------
	// TEST
	// --------
	
	@Test
	public void testAddPerfil() {

		PerfilRepository pDao;
		logger.info("Prueba para comprobar que se ha agregado un perfil");

		int cantidadInicial;
		int cantidadFinal;
		boolean existe = true;
		int idALocalizar;

		try {
			pDao.
			// Paso 01) Miro cuantos elementos hay
			cantidadInicial = conex.numPeliculas();
			logger.info("Num peliculas iniciales: "+cantidadInicial);
			// Paso 02) Borro uno de ellos
			idALocalizar = conex.indicePeliculaAzar();
			logger.info("Pelicula a borrar de ID: "+idALocalizar);
			logger.info(conex.findById(idALocalizar));			
			conex.deleteById(idALocalizar);
			// Paso 03) compruebo que hay uno menos
			cantidadFinal = conex.numPeliculas();
			logger.info("Num peliculas finales: "+cantidadFinal);			
			// Paso 04) Compruebo que no existe ese elemento
			existe = conex.isExistPelicula(idALocalizar);
			logger.info("Pelicula borrada con ID: "+idALocalizar);			

			// Comprobaciones
			assertEquals(cantidadInicial, cantidadFinal + 1);
			assertEquals(existe, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
