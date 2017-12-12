<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src='<c:url value="/scripts/plotly-latest.min.js"/>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HeightWeight Chart</title>
</head>
<body>
<h6>Height average is </h6> 
${heightavg} <h6>centimeters</h6>
<br>
<h6>Weight average is </h6> 
${weightavg}  <h6>kilograms</h6>
<div id='container'>  </div>
<script>
var heightarr =${heightarray}
var weightarr=${weightarray}
var trace1 = { x: heightarr,y: weightarr,mode: 'markers',type: 'scatter'};
var data=[trace1];
Plotly.newPlot('container', data);
</script>
</body>
</html>