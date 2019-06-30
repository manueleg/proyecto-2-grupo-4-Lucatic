package com.spring;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.spring.model.Genero;
import com.spring.model.Perfil;
import com.spring.repository.PerfilRepository;
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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgregarUsuarioTest {

	private static Logger logger;

	// Inicializo
	static {
		try {
			logger = LogManager.getLogger(AgregarUsuarioTest.class);
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
	// Puedes usarlo en vez de comentar el mÃ©todo para que no se ejecute
	// http://junit.sourceforge.net/javadoc/org/junit/Ignore.html
	public void executionIgnored() {
		logger.info("@Ignore: This execution is ignored");
	}

	// --------
	// TEST
	// --------

	@Autowired
	private PerfilRepository perfilRepo;
	
	@Test
	public void AgregarUsuarioTest() {

		logger.info("Prueba para comprobar que se ha agregado un elemento");

		int cantidadInicial;
		int cantidadFinal;
		boolean existe = true;
		int idALocalizar;

		try {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
			Perfil p1 = new Perfil();
			p1.setDescripcion("descripcion1");
			p1.setEdad(fechaNac);
			p1.setGenero('h');
			p1.setNombre("nombre1");
			p1.setIdintereses(null);
			p1.setPoblacion("Madrid");
			logger.info("--Objeto creado, procedemos a guardarlo...");
			perfilRepo.save(p1);
			logger.info("--¡Objeto guardado!");
			/*// Paso 01) Miro cuantos elementos hay
			perfilRepo.findAll();
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
			assertEquals(existe, false);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}