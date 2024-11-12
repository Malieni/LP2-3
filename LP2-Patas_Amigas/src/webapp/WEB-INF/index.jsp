<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Página Inicial</title>
</head>
<body>
    <h1>Cadastro de Pessoa</h1>
    <form action="meuServlet" method="post">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required /><br/><br/>

        <label for="idade">Idade:</label>
        <input type="number" id="idade" name="idade" required /><br/><br/>

        <input type="submit" value="Cadastrar" />
    </form>
</body>
</html>