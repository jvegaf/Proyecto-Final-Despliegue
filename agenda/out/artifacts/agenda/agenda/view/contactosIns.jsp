<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Ingresar Contactos</title>
  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  <link href="../icons/estilos.css" rel="stylesheet" type="text/css"/>
  <link href="../css/style.css" rel="stylesheet" type="text/css"/>
  <script src="../js/jquery.js" type="text/javascript"></script>
  <script src="../js/bootstrap.min.js" type="text/javascript"></script>
  <script src="../js/contactos.js" type="text/javascript"></script>
</head>
<body>
<br/>
<br/>
<br/>
<div id="m_main">

  <div id="m_body">
    <div class="container">

      <div class="col-md-3"></div>
      <div class="col-md-6">
        <div class="panel panel-default">
          <div class="panel-body">
            <div class="page-header" style="text-align: center; margin-top: 5px">
              <h3>Agregar Nuevo Contacto</h3>
            </div>
            <form action="Contactos" method="GET" class="form-horizontal">
              <input type="hidden" name="action" value="add"/>
              <div class="form-group form-group-sm">
                <label for="nombre" class="control-label col-md-4">Nombre</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="nombre" id="nombre" value="${contacto.nombre}"
                         placeholder="Nombre" required="" maxlength="30"/>
                </div>
              </div>

              <div class="form-group form-group-sm">
                <label for="telefono" class="control-label col-md-4">Telefono</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="telefono" id="telefono" value="${contacto.telefono}"
                         placeholder="Telefono" required="{*0-9}" maxlength="9"/>
                </div>
              </div>

              <div class="form-group form-group-sm">
                <label for="correo" class="control-label col-md-4">Correo</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="correo" id="correo" value="${contacto.correo}"
                         placeholder="Correo" required="" maxlength="30"/>
                </div>
              </div>


              <hr/>
              <div class="form-group">
                <div class="col-md-4 col-sm-offset-2">
                  <button type="submit" class="btn btn-info">Aceptar</button>
                </div>
                <div class="col-md-4 col-sm-offset-2">
                  <button type="button" id="btnCancelar" class="btn btn-warning">Cancelar</button>
                </div>
              </div>

            </form>
          </div>
        </div>
      </div>
      <br/>
    </div>
  </div>
</div>
</body>
</html>