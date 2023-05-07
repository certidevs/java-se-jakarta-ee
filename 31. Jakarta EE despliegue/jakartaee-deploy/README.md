
# Jakarta EE: despliegue

Despliegue de aplicación Jakarta EE en AWS utilizando Docker.

Instalar Docker: https://docs.docker.com/desktop/install/windows-install/

1. Generar archivo .war
2. Crear el Dockerfile
3. Construir imagen docker `docker build -t alansastre/jakartaee-deploy:1.0 .`
4. Iniciar sesión docker hub: `docker login`
5. Push a docker Hub `docker push alansastre/jakartaee-deploy:1.0`
6. Crear instancia EC2 en AWS: permitir tráfico HTTP
7. Entrar en la instancia a través de SSH
8. Instalar docker (https://docs.docker.com/engine/install/ubuntu/)
9. Descargar imagen docker en EC2: `docker pull alansastre/jakartaee-deploy:1.0`
10. Crear contenedor docker `docker run -p 80:8080 --name jakartaee -d -ti alansastre/jakartaee-deploy:1.0`
11. Ver logs: `docker logs -f jakartaee`

Recomendación: 

Utilizar imágenes alpine