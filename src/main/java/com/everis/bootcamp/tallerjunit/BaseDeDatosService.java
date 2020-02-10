package com.everis.bootcamp.tallerjunit;

import java.util.HashMap;
import java.util.Map;

public class BaseDeDatosService {
	
	private Map<Integer, Articulo> storage = new HashMap<Integer, Articulo>();
	
	public BaseDeDatosService() {
		super();
		this.initBD();
	}
	
	public void initBD() {
		this.storage = new HashMap<Integer, Articulo>();
		storage.put(1, new Articulo("Camiseta", 18.0));
		storage.put(2, new Articulo("Jersey", 32.2));
		storage.put(3, new Articulo("Cinturón", 12.4));
		storage.put(4, new Articulo("Sudadera", 41.0));
		storage.put(5, new Articulo("Pantalón", 37.8));
		storage.put(6, new Articulo("Gorra", 15.7));
		storage.put(7, new Articulo("Zapato", 56.0));
		storage.put(8, new Articulo("Chaqueta", 90.5));
	}
	
	public Articulo findArticuloById(Integer idArticulo) {
		System.out.println("Buscamos en BBDD el Articulo con ID: "+ idArticulo);
		return storage.get(idArticulo);
	}
	
	public Integer insertar(Articulo a) {
		Integer res = 0;
		res = storage.size();
		storage.put(res+1, a);
		return res;
	}

}
