<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src='<c:url value="/scripts/plotly-latest.min.js"/>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4> MVP Votes for</h4>
<h5> Lebron James: ${listcity.get(0)}</h5>
<h5> James Harden: ${listcity.get(1)}</h5>
<h5> Kevin Durant: ${listcity.get(2)}</h5>
	<br>
<div id='container'>  </div>
<script>
var data = [{
  values: [${listcity.get(0)},${listcity.get(1)}, ${listcity.get(2)}],
  labels: ['Lebron James', 'James Harden', 'Kevin Durant'],
  type: 'pie'
}];

var layout = {
  height: 400,
  width: 500
};

Plotly.newPlot('container', data, layout);
</script>
</body>
</html>