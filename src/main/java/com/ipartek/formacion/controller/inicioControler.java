package com.ipartek.formacion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ipartek.formacion.modelo.ProductoDAO;
import com.ipartek.formacion.modelo.pojo.FormularioBusqueda;
import com.ipartek.formacion.modelo.pojo.Producto;



import java.util.ArrayList;



/**
 * Servlet implementation class inicioControler
 */
@WebServlet("/inicio")
public class inicioControler extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(inicioControler.class);
	private final static ProductoDAO dao = ProductoDAO.getInstance();
    	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nombre     = request.getParameter("nombre");
		String pmin       = request.getParameter("pmin");
		String pmax       = request.getParameter("pmax");
		String fabricante = request.getParameter("fabricante");
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		FormularioBusqueda form = new FormularioBusqueda();
		
		try {
			
			LOG.trace("Entramos al controlador /inicio ");
			
			form = new FormularioBusqueda(nombre, pmin, pmax, fabricante);
			
			LOG.debug( String.format( "filtro busqueda nombre=%s precioMinimo=%s precioMAximo=%s fabricante=%s" , nombre, pmin, pmax, fabricante ) );
			
			productos = dao.buscar( form.getNombre() , form.getPrecioMin(), form.getPrecioMax(), form.getIdFabricante() );
			
		}catch (Exception e) {
			
			LOG.error(e);
			
			
		}finally {
			request.setAttribute("fabricantes", dao.getAllFabricantes() );			
			request.setAttribute("formulario", form);
			request.setAttribute("productos", productos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}