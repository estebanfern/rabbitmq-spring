# Spring + RabbitMQ

## 1- Levantar contenedor de RabbitMQ
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.13-management
```

## 2- Agregar los directorios rabbitmq-* como proyectos hijos de rabbitmq-spring en IntelliJ desde el pom.xml

## 3- Levantar los microservicios rabbitmq-productos y rabbitmq-ventas en el orden que se desee.

## 4- En la carpeta del proyecto están el collection y environment para probar los endpoints.
