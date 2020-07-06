<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- Fontawesome 4.7 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<!-- Nuestro css -->
<link rel="stylesheet" href="css/styles.css">

<title>Buscador Tienda</title>
</head>
<body>

	<!-- Barra navegacion-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <a class="navbar-brand" href="#"><i class="logo fa fa-shopping-bag" aria-hidden="true"></i></a>
	

		<!-- icono para desplegar menu en moviles-->
		  <button class="navbar-toggler" type="button" data-toggle="collapse" 
		  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" 
		  aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
		

		<!--lista enlaces-->

		 <!-- formulario por nombre y fabricante -->
	     <form class="form-inline my-2 my-lg-0" action="inicio" method="get">	
				<div class="input-group">
				  <div class="input-group-prepend">				    
				    <i class="fa fa-search input-group-text" aria-hidden="true"></i>				    
				  </div>
				  <input type="text" class="form-control" name="nombre" value="${formulario.nombre}" placeholder="Nombre Producto">
				</div>
				
				
				<input type="hidden" name="pmin" value="${formulario.precioMin}">
				<input type="hidden" name="pmax" value="${formulario.precioMax}">
				
				<select name="fabricante" class="form-control" >
					<option value="0"> -- Selecciona Fabricante -- </option>
					<c:forEach items="${fabricantes}" var="fab">
						<option value="${fab.id}" ${ ( fab.id eq formulario.idFabricante ) ? "selected" : "" } >${fab.nombre}</option>
					</c:forEach>
				</select>	
				
				<input type="submit" value="Filtrar">
	    </form>
	</nav>

	<main class="container">

		<div class="card-content">

			<c:forEach items="${productos}" var="p">
				<div class="card">
					<img src="http://via.placeholder.com/250x250" class="card-img-top"
						alt="...">
					<div class="card-body">
						<span class="precio">${p.precio} €</span> <span
							class="badge badge-pill badge-light float-right">${p.fabricante.nombre}</span>
						<h5 class="card-title">${p.nombre}</h5>
						<p class="card-text">${p.descripcion}</p>
					</div>
				</div>
			</c:forEach>

		</div>

	</main>

</body>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
</body>
</html>