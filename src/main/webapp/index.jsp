<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   


PAGINA INICIO
<h1> Buscador de productos</h1>

<form action="inicio" method="get">
	
	<div class="form-group">
		<label for="id">id:</label>
		<input type="text" name="id" id="id" value="id" readonly class="form-control">
	</div>	
				
<	div class="form-group">
		<label for="id">id:</label>
		<input type="text" name="pmin" id="pmin" value="pmin" readonly class="form-control">
	</div>	

	<div class="form-group">
		<label for="id">id:</label>
		<input type="text" name="pmax" id="pmax" value="pmax" readonly class="form-control">
	</div>	
	
	<div class="form-group">
		<label for="id">id:</label>
		<input type="text" name="idFabricante" id="idFabricante" value="idFabicante">
	</div>	
	
	<input type="submit" value="Guardar" class="btn btn-primary btn-block">

</form>