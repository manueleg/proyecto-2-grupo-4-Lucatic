package com.spring;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.model.Genero;
import com.spring.model.Perfil;
import com.spring.repository.PerfilRepository;
import com.spring.repository.PerfilRepositoryImp;

public class Test02_BBDD {
	PerfilRepository perfilDAO;
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

		PerfilRepositoryImp pImpDao = new PerfilRepositoryImp();
		logger.info("Prueba para comprobar que se ha agregado un perfil");

		int cantidadInicial=0;
		int cantidadFinal=0;

		//Resultados test David: 16. Fallos porcentaje total de los dos test: 50,8%
		
		try {
			Perfil p = new Perfil();
			p.setNombre("nombre1");
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
			p.setEdad(fechaNac);
			p.setDescripcion("descripcion1");
			p.setGenero(Genero.H);
			p.setIdintereses(null);
			p.setPoblacion("Madrid");
			//perfilDAO.save(p);
			pImpDao.guardar(p);
			
			// Paso 01) Miro cuantos elementos hay
			/*for(Perfil per : perfiles) {
				cantidadInicial++;
			}*/
			
			/*Iterator<Perfil> it = perfilDAO.getPerfiles().iterator();
			while (it.hasNext()) {
				if (it.next() == null){
					logger.info("No hay objetos en el List de perfiles recogido de la BBDD.");
				} else {
					cantidadInicial++;
				}
			}*/
			logger.info("Número perfiles iniciales: " + cantidadInicial);

			// Paso 02) Guardo un nuevo elemento
			//perfilDAO.save(p);
			
			// Paso 03) Compruebo otra vez cuántos elementos hay
			/*Iterator<Perfil> it2 = perfilDAO.getPerfiles().iterator();
			while (it2.hasNext()) {
				cantidadFinal++;
			}*/
			logger.info("Número perfiles finales: " + cantidadFinal);

			// Comprobaciones
			assertEquals(cantidadInicial, cantidadFinal - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
