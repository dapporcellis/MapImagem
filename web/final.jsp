<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mapeamento de Imagem</title>
        <style>
            area {border:2px solid #000;}
        </style>
    </head>
    <body>
        <h1>Foto Mapeada</h1>
        <div id="imagem">
            <img src="./arquivos/${imagem.foto}" usemap="#usemap" />
            <map name="usemap">
                <c:forEach items="${listAreas}" var="area">
                    <area shape="${area.shape}" coords="${area.coords}" alt="${area.alt}" title="${area.title}" href="${area.href}"/>
                </c:forEach>
            </map>
        </div>
    </body>
</html>
