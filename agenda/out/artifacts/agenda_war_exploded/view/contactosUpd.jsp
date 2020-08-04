<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Actualizar Contacto</title>

  <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
  <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
  <link href="../icons/estilos.css" rel="stylesheet" type="text/css"/>
  <link href="../css/style.css" rel="stylesheet" type="text/css"/>
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
              <h3>Actualizar Contacto</h3>
            </div>
            <form action="Contactos" method="POST" class="form-horizontal">
              <input type="hidden" name="action" value="update"/>

              <div class="form-group form-group-sm">
                <label for="id" class="control-label col-md-4">ID</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="id" value="${contacto.id}"
                         readonly="readonly"/>
                </div>
              </div>

              <div class="form-group form-group-sm">
                <label for="nombre" class="control-label col-md-4">Nombre</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="nombre" value="${contacto.nombre}"
                         required="" maxlength="30"/>
                </div>
              </div>

              <div class="form-group form-group-sm">
                <label for="telefono" class="control-label col-md-4">Telefono</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="telefono" value="${contacto.telefono}"
                         required="" pattern="[0-9]+" maxlength="9"/>
                </div>
              </div>

              <div class="form-group form-group-sm">
                <label for="correo" class="control-label col-md-4">Correo</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" name="correo" value="${contacto.correo}"
                         required="" maxlength="30"/>
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
      <%-- para mensajes  --%>
      <div>${mensaje}</div>
    </div>
  </div>
</div>
<script src="../js/jquery.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/contactos.js" type="text/javascript"></script>
</body>
</html>