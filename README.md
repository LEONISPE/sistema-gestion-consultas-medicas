# Sistema de Gestión de Consultas Médicas

Este es un sistema backend desarrollado en Java con Spring Boot para la gestión de consultas médicas. Permite a usuarios administradores registrar médicos, pacientes y agendar consultas médicas de forma organizada, segura y validada.

## Características principales

- **Gestión de usuarios**: Registro y autenticación de usuarios con roles.
- **Gestión de médicos y pacientes**: CRUD completo para médicos y pacientes.
- **Agendamiento de consultas**: Permite crear consultas médicas entre pacientes y médicos, validando horarios y días disponibles.
- **Validaciones inteligentes**: Impide crear consultas en días no laborables (como domingos) o fuera del horario permitido por la clínica.
- **Autenticación y autorización**: Implementación de seguridad con JWT (JSON Web Token).
- **Excepciones globales**: Manejo de errores y validaciones mediante control de excepciones globales.
- **Documentación automática**: Generación de la documentación de la API con Swagger / SpringDoc OpenAPI.
- **Migraciones automáticas**: Las tablas de la base de datos se crean y actualizan mediante migraciones.

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring Data JPA**
- **MySQL**
- **SpringDoc OpenAPI / Swagger**
- **Flyway para migraciones**
- **Maven**

## Base de datos

El sistema cuenta con las siguientes tablas principales:

- **Usuario**: Administradores del sistema.
- **Médico**: Profesionales disponibles para consultas.
- **Paciente**: Personas que solicitan consultas.
- **Consulta**: Registros de las citas médicas entre pacientes y médicos.

## Instalación y ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tu_usuario/sistema-consultas-medicas.git
