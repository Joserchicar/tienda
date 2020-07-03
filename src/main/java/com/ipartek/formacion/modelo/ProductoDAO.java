package com.ipartek.formacion.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.ipartek.formacion.controller.inicioControler;
import com.ipartek.formacion.modelo.pojo.Fabricante;
import com.ipartek.formacion.modelo.pojo.Producto;




public class ProductoDAO {
	private static final Logger LOG = Logger.getLogger(ProductoDAO.class);
	//TODO patron Singleton
	
	/**
	 * Busca productos segun los parametros indicados 
	 * @param nombreProducto String busca la palabra 'nombreProducto' dentro del nombre del producto, si queremos todos pasar ""
	 * @param precioMin float si no queremos filtrar pasar 0 o negativo
	 * @param precioMax float si no queremos filtrar pasar 0 o negativo
	 * @param idFabricante int identificador del fabricante, si queremos todos pasar un 0
	 * @return listado de productos, si no encuentra nada una lista vacia pero inicializada
	 * @throws SQLException 
	 * @throws  
	 */
	public static ProductoDAO INSTANCE=null;
	
public static synchronized ProductoDAO getInstance() {
		
		if ( INSTANCE == null ){
			INSTANCE = new ProductoDAO();
		}
		
		return INSTANCE;		
	}


	
	public ArrayList<Producto> ProductoDAO( String nombreProducto, float precioMin, float precioMax, int idFabricante ) throws Exception{
		
		
		ArrayList<Producto> resultado = new ArrayList<Producto> ();
		String sql = "SELECT p.id 'producto_id', p.nombre 'nombre',precio,descripcion,"
		+"f.id 'fabricante_id', f.nombre 'fabricante_nombre'"
				+ " FROM productos p INNER JOIN Fabricantes f fON p.id_fabricante=f.id  ORDER BY id DESC LIMIT 500;";
		
				
		try(
				Connection con =  ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
		    ){
			
			
			//TODO 1 mapear resto de campos
			//TODO 2 Inner Join con Fabricante
			//TODO 3 que funcione con todos los paremtros
			
			try( ResultSet rs = pst.executeQuery() ){
				
				Producto p;
				while( rs.next() ) {
					
					 p = new Producto();
					 p.setId( rs.getInt("id"));
					 p.setNombre( rs.getString("nombre"));
					 p.setPrecio(rs.getFloat ("precio"));
					 p.setDescripcion(rs.getString("descripcion"));
					 
					 Fabricante f=new Fabricante();
					f.setId(rs.getInt ("id"));
					f.setNombre(rs.getString("nombre"));
					
					p.setFabricante(fabricante);
					
					 resultado.add(p);
					
				}
			}
		}
		
		return resultado;
	}



	public ArrayList<Producto> buscar(String string, int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	
	
	
	

