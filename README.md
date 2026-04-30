# Aplicación de Pedidos para Cadena de Restaurantes

Proyecto desarrollado por **Alejandro Peña Fernández** para la asignatura de **Desarrollo web en entorno servidor (DWES)** del 2º curso del ciclo formativo de grado superior en desarrollo de aplicaciones web (DAW).

## ¿De qué va la aplicación?

Es una API REST que permite a los restaurantes de una cadena hacer pedidos de comida, bebida y materiales al departamento central de la empresa.

Cada restaurante se identifica con su correo electrónico y contraseña. Una vez autenticado, puede:

- Consultar las categorías y productos disponibles.
- Añadir productos a un carrito (que se mantiene en sesión).
- Confirmar el pedido, que se guarda en base de datos y descuenta el stock de los productos pedidos.
- Consultar el histórico de pedidos realizados.

## Cómo desplegarlo

### Lo que necesitas instalado

- Java 21 o superior.
- Maven 3.9 o superior.
- Docker y Docker Compose.

### Pasos

**0. Añadir .env para las variables de Docker Compose**

Hay un archivo .env.example en que se se le debe cambiar el nombre por: .env

Y editar su contenido con la contraseña y el nombre de la base de datos.

**1. Levantar la base de datos MySQL**

Desde la raíz del proyecto:

```bash
docker compose up -d
```

Esperar 15-30 segundos a que MySQL termine de inicializarse.

**2. Cargar los datos iniciales (solo la primera vez)**

Arrancar la aplicación una vez:

```bash
cd backend
./mvnw spring-boot:run
```

O desde el IDE

Detenerla con `Ctrl+C` y editar el archivo `backend/src/main/resources/application.properties` y cambiar la línea 
`spring.sql.init.mode=always` por `spring.sql.init.mode=never`

**3. Ejecutar la aplicación**

```bash
cd backend
./mvnw spring-boot:run
```

O desde en IDE

La API queda disponible en `http://localhost:8080`.

### Usuarios de prueba

| Correo                  | Contraseña    |
|-------------------------|---------------|
| sevilla@empresa.com     | password123   |
| barcelona1@empresa.com  | password123   |
| valencia1@empresa.com   | password123   |

### Cómo probar la API

Con un cliente HTTP como **Bruno** o **Postman**:

1. `POST http://localhost:8080/login` con `username` y `password` en el body como `Form URL Encoded`.
2. A partir de ahí, llamar a los endpoints `/api/restaurante/...` con la sesión ya iniciada.
3. `POST http://localhost:8080/logout` para cerrar la sesión.
