<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


<h1>Buscador de Productos</h1>

<form action="inicio" method="get">

	<input type="text" name="nombre" value="${formulario.nombre}" placeholder="Nombre Producto">
	<br>
	
	<input type="text" name="pmin" value="${formulario.precioMin}" placeholder="Precio Mínimo">
	<br>
	
	<input type="text" name="pmax" value="${formulario.precioMax}" placeholder="Precio Máximo">
	<br>
	
	<input type="number" name="fabricante" value="${formulario.idFabricante}" placeholder="Id Fabricante">
	<br>
	<input type="submit" value="Filtrar">
	
</form>

<hr>

<ol>
	<c:forEach items="${productos}" var="p">
		<li>${p}</li>
	</c:forEach>
</ol>
