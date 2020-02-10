package tallerJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;

import DescriptionSorterRunner.DescriptionSorterRunner;

@RunWith(DescriptionSorterRunner.class)
public class CarritoCompraServiceTest2 {
	CarritoCompraService service = new CarritoCompraService();
	
		
//	@Test
//	public void A_testAddArticulo() {
//		System.out.println("Probamos addArticulo");
//		assertTrue(service.getArticulos().isEmpty());
//		service.addArticulo(new Articulo("Articulo 1", 10d));
//		assertFalse(service.getArticulos().isEmpty());
//		
//	}
//	
//	@Test
//	public void B_testTotalPrice() {
//		System.out.println("Probamos totalPrice");
//		assertTrue(service.getArticulos().isEmpty());
//		service.addArticulo(new Articulo("Articulo 1", 10d));
//		service.addArticulo(new Articulo("Articulo 2", 20d));
//		assertFalse(service.getArticulos().isEmpty());
//		assertEquals(service.totalPrice(), new Double(30));
//	}
//	
//	
//	@Test
//	public void C_testLimpiarCesta() {
//		System.out.println("Probamos limpiarCesta");
//		
//		assertTrue(service.getArticulos().isEmpty());
//		service.addArticulo(new Articulo("Articulo 1", 10d));
//		assertFalse(service.getArticulos().isEmpty());
//		service.limpiarCesta();
//		assertTrue(service.getArticulos().isEmpty());
//	}
	

}
