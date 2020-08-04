# Proyecto Final Despliegue
Proyecto final de la asignatura de despligue de aplicaciones web.

## Despliegue de Tomcat y MySQL

Para desplegar el proyecto hay que tener previamente el cliente Docker Desktop
instalado en tu maquina.

Una vez instalado y arrancado docker desktop escribir el comando:


```shell
docker-compose up -d
```

Una vez levantado el entorno dispondremos de 3 contenedores, uno para Tomcat, otro para MySQL y otro mas para PHPMyAdmin.

La ruta para acceder a PHPMyAdmin es:

```url
http://localhost:8183
```