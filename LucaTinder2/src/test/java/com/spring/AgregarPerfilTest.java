package com.spring;

import static org.junit.Assert.assertEquals;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgregarPerfilTest {

	private static Logger logger;

	// Inicializo
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

	// --------
	// TEST
	// --------

	@Autowired
	private PerfilRepository perfilRepo;
	
	@Test
	public void AgregarPerfilTest() {

		logger.info("Prueba para comprobar que se ha agregado un elemento");

		int cantidadInicial=0;
		int cantidadFinal=0;

		try {
			List<Perfil> perfilesInicial= perfilRepo.getPerfiles();
			if(perfilesInicial.isEmpty()){
				logger.info("--Número de perfiles iniciales= "+cantidadInicial);
			}else {
				for(Perfil p : perfilesInicial) {
					cantidadInicial++;
				}
				logger.info("--Número de perfiles iniciales= "+cantidadInicial);
			}
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
			Perfil p1 = new Perfil();
			p1.setDescripcion("descripcion1");
			p1.setFecha_nac(fechaNac);
			p1.setGenero("h");
			p1.setNombre("nombre1");
			p1.setIdintereses(null);
			p1.setPoblacion("Madrid");
			logger.info("--Objeto creado, procedemos a guardarlo...");
			perfilRepo.save(p1);
			logger.info("--¡Objeto guardado!");

			List<Perfil> perfilesFinal= perfilRepo.getPerfiles();
			if(perfilesFinal.isEmpty()){
				logger.info("--Número de perfiles finales= "+cantidadFinal);
			}else {
				for(Perfil p : perfilesFinal) {
					cantidadFinal++;
				}
				logger.info("--Número de perfiles finales= "+cantidadFinal);
			}

			assertEquals(cantidadInicial, cantidadFinal-1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}