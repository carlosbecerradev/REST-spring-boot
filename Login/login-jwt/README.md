## Proyecto Login + JSON Web TOKEN (JWT)

Muestra como se auténtica y autoriza un usuario mediante el uso de un JSON Web Token.

## Dependencias

* spring-boot-starter-web
* spring-boot-starter-data-jpa
* mysql-connector-java
* spring-boot-starter-security
* [Java JSON Web Token (JJWT)](https://github.com/jwtk/jjwt)

## Datos

* Nombre de la base de datos: `sb_login_jwt`, se crea automáticamente.
* El usuario, se inserta automáticamente en la tabla `users`.
  * username: `user`
  * password: `123`
  

## Autenticación

Recibe los datos del usuario y verifica si se encuentra registrado en la base de datos. Y si es válido se genera y envia el `JWT`.

## Autorización

Recibe un `JWT` con el prefijo `Bearer ` y lo verifica con la llave que firma los `JWTs` generados en la aplicación. Y si es válido se extrae la información del mismo para establecer la identidad del usuario dentro del contexto de seguridad de la aplicación.
