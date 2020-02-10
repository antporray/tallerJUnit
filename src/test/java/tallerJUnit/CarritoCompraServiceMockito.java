package tallerJUnit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.anyInt;

import org.mockito.Mockito;

import com.everis.bootcamp.tallerjunit.Articulo;
import com.everis.bootcamp.tallerjunit.BaseDeDatosService;
import com.everis.bootcamp.tallerjunit.CarritoCompraService;


public class CarritoCompraServiceMockito {
	CarritoCompraService service;
	BaseDeDatosService mock;
	@Before
	public void setUp() {
		System.out.println("Inicializamos el servicio");
		service = Mockito.spy(new CarritoCompraService());
		mock =  Mockito.mock(BaseDeDatosService.class);
		service.setBbddService(mock);
		
	}
	
	@Test
	public void testAplicarDescuento() {
		System.out.println("Test de aplicar descuento");
		Mockito.when(mock.findArticuloById(1)).thenReturn(new Articulo("MI MOCK", 10.0));
		Double result = service.aplicarDescuento(1, 12.0);
		assertEquals(result, new Double (8.8));
		System.out.println("El precio definitivo del articulo tras el descuento: "+result);
	}
	
	@Test(expected = Exception.class)
	public void testBaseDatosService() {
		System.out.println("Test de base de datos service, error al buscar id 0");
		Mockito.when(mock.findArticuloById(0)).thenThrow(new Exception());
		double d = service.aplicarDescuento(0, 12.0);
		System.out.println("El precio definitivo del articulo tras el descuento: "+d);
	}
	
	@Test
	public void testAplicarDescuentoVerify() {
		System.out.println("Test de aplicar descuento");
		Mockito.when(mock.findArticuloById(1)).thenReturn(new Articulo("MI MOCK", 10.0));
		Double result = service.aplicarDescuento(1, 12.0);
		assertEquals(result, new Double (8.8));
		Mockito.verify(mock, times(1)).findArticuloById(1);
		System.out.println("El precio definitivo del articulo tras el descuento: "+result);
	}
	
	@Test
	public void testAplicarDescuentoVerifyAndMatchers() {
		System.out.println("Test de aplicar descuento");
		Mockito.when(mock.findArticuloById(anyInt())).thenReturn(new Articulo("MI MOCK", 10.0));
		Double result = service.aplicarDescuento(1, 12.0);
		assertEquals(result, new Double (8.8));
		Mockito.verify(mock, times(1)).findArticuloById(anyInt());
		System.out.println("El precio definitivo del articulo tras el descuento: "+result);
	}
	
	@Test
	public void testAplicarDescuentoVerifyAplicarDescuento() {
		System.out.println("Test de aplicar descuento");
		Mockito.when(mock.findArticuloById(anyInt())).thenReturn(new Articulo("MI MOCK", 10.0));
		Double result = service.aplicarDescuento(1, 12.0);
		assertEquals(result, new Double (8.8));
		Mockito.verify(mock, times(1)).findArticuloById(anyInt());
		Mockito.verify(service, times(1)).aplicarDescuento(1, 12.0);
		System.out.println("El precio definitivo del articulo tras el descuento: "+result);
	}
	
	@Test
	public void testReto() {
		System.out.println("Reto");
		Articulo a = new Articulo("Mi mockito", 20.0);
		a.setId(50L);
		Mockito.when(mock.insertar(a)).thenReturn(20);
		//Llamada
		Integer nuevoi = service.insertarArticuloPorID(a);
		//Verificacion
		assertNotNull(nuevoi);
		assertEquals(nuevoi, new Integer(20));
		assertTrue(service.getArticulos().contains(a));
		Mockito.verify(mock, times(0)).findArticuloById(Mockito.anyInt());
		Mockito.verify(mock, atLeast(1)).insertar(Mockito.eq(a));
	}
}
