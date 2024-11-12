<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalhes da Pessoa</title>
</head>
<body>
    <h1>Detalhes da Pessoa</h1>
    
    <%
        String nome = request.getParameter("nome");
        String idade = request.getParameter("idade");

        if (nome != null && idade != null) {
    %>
        <p><strong>Nome:</strong> <%= nome %></p>
        <p><strong>Idade:</strong> <%= idade %></p>
    <%
        } else {
    %>
        <p>Nenhuma informação foi fornecida.</p>
    <%
        }
    %>
    
    <a href="index.jsp">Voltar</a>
</body>
</html>