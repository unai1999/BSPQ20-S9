# BSPQ20-S9   [![Build Status](https://travis-ci.com/unai1999/BSPQ20-S9.svg?branch=master)](https://travis-ci.com/unai1999/BSPQ20-S9)  [![Coverage Status](https://coveralls.io/repos/github/unai1999/BSPQ20-S9/badge.svg?branch=master)](https://coveralls.io/github/unai1999/BSPQ20-S9?branch=master)
> Aplicación de gestión de alquiler de pisos.

## Tabla de contenido

- [Instalación](#instalación)
- [Documentación](#documentación)
- [Equipo](#equipo)

---

## Instalación

### Repositorio

- Clone este repositorio usando `https://github.com/unai1999/BSPQ20-S9`

### Setup

- Base de datos MySQL
>Arranque de servidor MySQL

>Introducir sentencia SQL situada en src/sql (Solo la primera vez)

- Compilación del proyecto
```shell
mvn clean compile
```

- Creación de esquemas de la base de datos (Solo la primera vez)
```shell
mvn datanucleus:schema-create
```

- Arranque de servidor Jetty
```shell
mvn jetty:run
```

- Inicialización de datos
```shell
mvn exec:java -PdatosBD
```

- Ejecución de la ventana del cliente
```shell
mvn exec:java -Pclient
```

---

## Documentación

###### La aplicación permite a los usuarios poder visualizar una lista de pisos además de obtener la información de cada piso y en caso de que fuera necesario alquilarlo. Asimismo, los usuarios podrán gestionar sus cuentas pudiendo actualizar los datos si fuera necesario.


---

## Equipo

| **Eneko** | **Unai** | **Kike** | **Alvar** | **Jon** |
| :---: |:---:| :---:| :---:| :---:|
| <a href="http://github.com/eneko98" target="_blank">`github.com/eneko98`</a> | <a href="http://github.com/unai1999" target="_blank">`github.com/unai1999`</a> | <a href="http://github.com/Kike00" target="_blank">`github.com/Kike00`</a> | <a href="http://github.com/alvarfez" target="_blank">`github.com/alvarfez`</a> | <a href="http://github.com/uraga" target="_blank">`github.com/uraga`</a> | 

---



