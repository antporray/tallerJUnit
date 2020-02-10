package tallerJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

@RunWith(JUnit4.class)
public class CarritoCompraServiceTest {
	CarritoCompraService service;
	
	@Before
	public void setUp() {
		System.out.println("Inicializamos el servicio");
		service = new CarritoCompraService();
	}
	
	@Test
	public void primerTest() {
		System.out.println("Primer Test");
	}
	
	@Test
	public void testAddArticulo() {
		System.out.println("Probamos addArticulo");
		assertTrue(service.getArticulos().isEmpty());
		service.addArticulo(new Articulo("Articulo 1", 10d));
		assertFalse(service.getArticulos().isEmpty());
		
	}
	
	@Test
	public void testLimpiarCesta() {
		System.out.println("Probamos limpiarCesta");
		
		assertTrue(service.getArticulos().isEmpty());
		service.addArticulo(new Articulo("Articulo 1", 10d));
		assertFalse(service.getArticulos().isEmpty());
		service.limpiarCesta();
		assertTrue(service.getArticulos().isEmpty());
	}
	
	@Test
	public void testTotalPrice() {
		System.out.println("Probamos totalPrice");
		assertTrue(service.getArticulos().isEmpty());
		service.addArticulo(new Articulo("Articulo 1", 10d));
		service.addArticulo(new Articulo("Articulo 2", 20d));
		assertFalse(service.getArticulos().isEmpty());
		assertEquals(service.totalPrice(), new Double(30));
	}
	
	@Test
	public void testCalculaDescuento() {
		System.out.println("Probamos CalcularDescuento");
		
		assertEquals(service.calculadorDescuento(100d, 10d), new Double(90));
	}
	
	@Test
	public void testGetArticulos() {
		System.out.println("Probamos getArticulos");
		assertTrue(service.getArticulos().isEmpty());
		service.addArticulo(new Articulo("Articulo 1", 10d));
		service.addArticulo(new Articulo("Articulo 2", 20d));
		assertFalse(service.getArticulos().isEmpty());
		
	}
	 
	
	 
}
