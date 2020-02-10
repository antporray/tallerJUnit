package com.everis.bootcamp.tallerjunit;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompraService {
	
	List<Articulo> articulos = new ArrayList<Articulo>();
	private BaseDeDatosService bd = new BaseDeDatosService();
	
	public void limpiarCesta(){
		articulos = new ArrayList<Articulo>();
		bd = new BaseDeDatosService();
	}
	
	public void addArticulo(Articulo a){
		articulos.add(a);
	}
	
	public int getNumArticulo(){
		return articulos.size();
	}
	
	public Double totalPrice(){
		double precioTotal = articulos.stream().  	
			     mapToDouble(Articulo::getPrecio).
			     sum();
		return precioTotal;
	}
	
	public static Double calculadorDescuento(double precio, double porcentajeDescuento){
		return precio - (precio * (porcentajeDescuento/100));
	}

	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	public Double aplicarDescuento(Integer id, double porcentaje) {
		Double res = null;
//		BaseDeDatosService bd = new BaseDeDatosService();
		Articulo a = bd.findArticuloById(id);
		if(null != a) {
			res = calculadorDescuento(a.getPrecio(), porcentaje);
		}else {
			System.out.println("No se ha encontrado el item: "+id+" en BD");
		}
	
		return res;
	}

	public void setBbddService(BaseDeDatosService mock) {
		// TODO Auto-generated method stub
		this.bd = mock;
	}
	
	public Integer insertarArticuloPorID(Articulo a) {
		articulos.add(a);
		Integer res = bd.insertar(a);
		return res;
		
	}

}
