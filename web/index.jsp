<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mapeamento de Imagem</title>
    </head>
    <body>
        <h1>Faça Upload da imagem!!</h1>
        <form action="UploadWS" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="urldestino" value="ImagemWS">
            <input type="file" name="txtFoto"><br><br>
            <input type="submit">
        </form>
    </body>
</html>
