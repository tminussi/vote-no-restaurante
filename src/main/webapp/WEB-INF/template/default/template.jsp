<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/resources/css/bootstrap.min.css'  />" rel="stylesheet" />
<link href="<c:url value='/resources/css/vote-no-restaurante.css'  />" rel="stylesheet" />
<script src="<c:url value='/resources/jquery/jquery-2.1.4.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.js' />"></script>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vote no Restaurante</title>
<style type="text/css">
* /
html, body {
	margin-left: 10%;
	margin-right: 10%;
	padding: 0;
	height: 100%;
}

.dataTables_wrapper {
	margin-top: 10px;
}

.wrapper {
	min-height: 100%;
	position: relative;
}

.header {
	background: #ededed;
	padding: 10px;
}

.content {
	padding-bottom: 100px;
	text-align: left;
	margin-left: 20px;
	margin-right: 20px;
}

table {
	margin-top: 10px;
	text-align: center;
}

.table tbody>tr>td.vert-align{
    vertical-align: middle;
}

#footer {
	background: #FFFAFA;
	width: 100%;
	height: 100px;
	position: absolute;
	bottom: 0;
	left: 0;
	text-align: center;
}
</style>
</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header" />
		<div class="content">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
</body>
</html>