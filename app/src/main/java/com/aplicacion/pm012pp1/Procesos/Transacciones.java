package com.aplicacion.pm012pp1.Procesos;

public class Transacciones
{
    /*Nombre de la Base de datos */
    public static final String NameDataBase = "DBPM001";
    /* Creacion de tablas de la BB */
    public static final String tablaEmpleados = "empleados";

    /* Campos de la Tabla Empleados */
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    /* Sentencias SQL para crear tabla */
    public static final String CreateTableEmpleados = "CREATE TABLE empleados " +
                                                    "( id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                                                    " nombres TEXT, apellidos TEXT, edad INTEGER, "+
                                                    " correo TEXT, direccion TEXT)";

    public static final String DropTableEmpleados = "DROP TABLE IF EXISTS empleados";
}
