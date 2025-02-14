<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CRUD de Libros</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
            margin: auto;
            padding: 20px;
        }
        form {
            margin-bottom: 20px;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            margin-top: 10px;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-primary { background-color: #007bff; color: white; }
        .btn-warning { background-color: #ffc107; color: black; }
        .btn-danger { background-color: #dc3545; color: white; }
    </style>
</head>
<body>
<h2>Gestión de Libros</h2>

<!-- Formulario para leer libros -->
<form action="LibroServlet" method="get">
    <label for="isbn">ISBN</label>
    <input type="text" id="isbn" name="isbn" >

    <label for="titulo">Título</label>
    <input type="text" id="titulo" name="titulo" >

    <label for="autor">Autor</label>
    <input type="text" id="autor" name="autor" >

    <button type="submit" class="btn-primary">Leer Libros</button>
</form>

<!-- Formulario para agregar un libro -->
<form action="LibroServlet" method="post">
    <input type="hidden" name="action" value="create">
    <label for="isbn">ISBN</label>
    <input type="text" id="isbnCreate" name="isbn" required>

    <label for="titulo">Título</label>
    <input type="text" id="tituloCreate" name="titulo" required>

    <label for="autor">Autor</label>
    <input type="text" id="autorCreate" name="autor" required>

    <button type="submit" class="btn-primary">Agregar Libro</button>
</form>

<!-- Formulario para editar un libro -->
<form action="LibroServlet" method="post">
    <input type="hidden" name="action" value="update">

    <label for="id">ID</label>
    <input type="text" id="id" name="id" required>

    <label for="tituloEdit">Nuevo Título</label>
    <input type="text" id="tituloEdit" name="titulo" required>

    <label for="autorEdit">Nuevo Autor</label>
    <input type="text" id="autorEdit" name="autor" required>

    <button type="submit" class="btn-warning">Editar Libro</button>
</form>

<!-- Formulario para eliminar un libro -->
<form action="LibroServlet" method="post">
    <input type="hidden" name="action" value="delete">

    <label for="idDelete">ID del Libro</label>
    <input type="text" id="idDelete" name="id" required>

    <button type="submit" class="btn-danger">Eliminar Libro</button>
</form>
</body>
</html>