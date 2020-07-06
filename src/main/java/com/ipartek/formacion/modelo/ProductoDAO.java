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

	private final static Logger LOG = Logger.getLogger(ProductoDAO.class);
	private static ProductoDAO INSTANCE;

	private ProductoDAO() {
		super();

	}

	public static synchronized ProductoDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ProductoDAO();
		}
		return INSTANCE;
	}

	/**
	 * Busca productos segun los parametros indicados @param nombreProducto String
	 * busca la palabra 'nombreProducto' dentro del nombre del producto, si queremos
	 * todos pasar "" @param precioMin float si no queremos filtrar pasar 0 o
	 * negativo @param precioMax float si no queremos filtrar pasar 0 o
	 * negativo @param idFabricante int identificador del fabricante, si queremos
	 * todos pasar un 0 @return listado de productos, si no encuentra nada una lista
	 * vacia pero inicializada @throws SQLException @throws
	 */
	public ArrayList<Producto> buscar(String nombreProducto, float precioMin, float precioMax, int idFabricante)
			throws Exception {

		ArrayList<Producto> resultado = new ArrayList<Producto>();

		String sql = " SELECT " + "    p.id as 'producto_id', p.nombre as 'producto_nombre', precio, descripcion, "
				+ "    f.id 'fabricante_id', f.nombre 'fabricante_nombre'  " + " FROM "
				+ "    productos p INNER JOIN fabricantes f ON p.id_fabricante = f.id ";

		String where = " WHERE p.nombre LIKE '%" + nombreProducto + "%' ";

		if (idFabricante > 0) {
			where += " AND p.id_fabricante = " + idFabricante + " ";
		}

		if (precioMin >= 0 && precioMax > 0) {
			where += " AND precio >= " + precioMin + " AND precio <= " + precioMax + " ";
		}

		String order = " ORDER BY p.id DESC LIMIT 500;";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pst = con.prepareStatement(sql + where + order);
				ResultSet rs = pst.executeQuery();) {

			LOG.debug(pst);

			Producto p;
			while (rs.next()) {

				p = new Producto();
				p.setId(rs.getInt("producto_id"));
				p.setNombre(rs.getString("producto_nombre"));
				p.setPrecio(rs.getFloat("precio"));
				p.setDescripcion(rs.getString("descripcion"));

				Fabricante f = new Fabricante();
				f.setId(rs.getInt("fabricante_id"));
				f.setNombre(rs.getString("fabricante_nombre"));

				p.setFabricante(f); // cuidado que se suele olvidar

				resultado.add(p);

			}

		}

		return resultado;
	}

	
	public ArrayList<Fabricante> getAllFabricantes(){
		
		ArrayList<Fabricante> resultado = new ArrayList<Fabricante>();
		String sql = "SELECT id, nombre FROM fabricantes ORDER BY nombre DESC LIMIT 500; ";
		
		try( Connection con = ConnectionManager.getConnection();
			 PreparedStatement pst = con.prepareStatement(sql);
			 ResultSet rs = pst.executeQuery();)
		{		
			LOG.debug(pst);
			Fabricante fab = null;
			while( rs.next() ) {
				
				fab = new Fabricante();
				fab.setId( rs.getInt("id"));
				fab.setNombre(rs.getString("nombre"));
				resultado.add(fab);
			}
			
			
		}catch (Exception e) {
			LOG.error(e);
		}
		
		return resultado;
		
	}
	
	
}
