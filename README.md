# Inge Trabajo Práctico Especial
Arquitectura: 

>Backend: Java, Spring Framework para WebServices, Lombok para mejorar la visual del código, PostgreSQL para la base de datos, Spring Security en el caso de ser necesario para Login y API Request con credenciales.

>Frontend: Android nativo, Java y Kotlin.

Cada issue (sea feature, bug, documentacion) debe tener su correspondiente branch, luego de finalizar la misma se debe crear el PR (Pull request) correspondiente a DEVELOP, previo a resolver conflictos si los hay. Para su posterior aprobación un integrante debe tener que revisar el codigo, probarlo y ver que ni los tests, ni las funcionalidades anteriores se rompan, y las nuevas funcionen.
Cada branch debe nombrarse idBranch-nombre-tarea para un mejor trackeo de los issues.

Instrucciones de instalacion:
1) Instalar Intellij
2) Instalar postgresql version 9.5
3) En una terminal hacer sudo -u postgres psql
4) ALTER USER postgres PASSWORD 'postgres';
5) Clonarse el repo
6) Importar el proyecto backend, carpeta 'inge-app' en intellij, y hacer que lo importe usando MAVEN.
6) Clean y compilar el backend
7) 'Darle play' al backend, ver que no haya explotado por algo y haya quedado levantado
8) Instalar el .apk en el celular
