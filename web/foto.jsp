<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mapeamento de Imagem</title>
        <link rel="stylesheet" href="./css/estilo.css">
    </head>
    <body>
        <h1>Criando Mapa</h1>
        <div id="imagem">
            <img id="foto" style="cursor:crosshair" href="#" onmousedown="coordenadas(event)" src="./arquivos/${imagem.foto}" />
        </div>
        <br>
        Shape:
        <select id="shape" onchange="javascript:limpaPonto()">
            <option value="rect">Retangulo</option>
            <option value="circle">Circulo</option>
            <option value="poly">Poligono</option>
        </select>
        <br>
        <input id="coords" type="hidden" value=""><br>
        Alt:
        <input id="alt" type="text" value=""><br>
        Title:
        <input id="title" type="text" value=""><br>
        Href:
        <input id="href" type="text" value=""><br>
        <input type="button" onclick="criarForm()" value="Mapa">
        
        <div id="imgMap">

        </div>
        
        <form id="formulario" action="AreaWS" method="POST">
            Id da Imagem: <input type="number" readonly name="txtId" value="${imagem.id}">
            <input type="submit">
        </form>

        <script src="./js/mapear.js"></script>  
    </body>
</html>
