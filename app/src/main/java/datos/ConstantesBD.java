package datos;

public class ConstantesBD {
    //Nombre de la BD
    public static final String BD_NAME = "F1";

    //Versión de la BD
    public static  final int BD_VERSION = 2;

    //Nombre de las tablas
    public static final String TABLE_REGISTRO = "REGISTRO";
    public static final String TABLE_ESCUDERIA = "ESCUDERIA";
    public static final String TABLE_PILOTO = "PILOTO";
    public static final String TABLE_CIRCUITO = "CIRCUITO";
    public static final String TABLE_SISTEMA_PUNTOS = "PUNTOS";

    //Campos de las tablas
    //TABLA REGISTRO
    public static final String C_ID = "ID";
    public static final String C_EMAIL = "EMAIL";
    public static final String C_NOMUSUARIO = "NOMBREUSUARIO";
    public static final String C_CONTRASEÑA = "CONTRASEÑA";

    //TABLA ESCUDERIA
    public static final String C_ID_ESCUDERIA = "IDESCUDERIA";
    public static final String C_NOMBRE_ESCUDERIA = "NOMBRE";
    public static final String C_SEDE = "SEDE";
    public static final String C_PAIS_ESCUDERIA = "PAIS";
    public static final String C_JEFE_ESCUDERIA = "JEFEESCUDERIA";
    public static final String C_JEFE_TECNICO = "JEFETECNICO";
    public static final String C_CHASIS = "CHASIS";
    public static final String C_UNIDAD_MOTOR = "MOTOR";
    public static final String C_TITULOS_ESCUDERIA = "TITULOS";
    public static final String C_FOTO_ESCUDERIA = "FOTO";


    //TABLA PILOTO
    public static final String C_ID_PILOTO = "IDPILOTO";
    public static final String C_NOMBRE_PILOTO = "NOMBRE";
    public static final String C_APELLIDO_PILOTO = "APELLIDO";
    public static final String C_PAIS_PILOTO = "PAIS";
    public static final String C_NUMERO_PODIOS = "PODIOS";
    public static final String C_NUMERO_VICTORIA = "VICTORIAS";
    public static final String C_GP_DISPUTADO = "GPDISPUTADOS";
    public static final String C_CUMPLEAÑOS = "CUMPLEAÑOS";
    public static final String C_VUELTA_RAPIDA = "VUELTASRAPIDAS";
    public static final String C_TITULOS_PILOTO = "TITULOS";
    public static final String C_FOTO_PILOTO = "FOTO";

    //TABLA CIRCUITO
    public static final String C_ID_CIRCUITO = "IDCIRCUITO";
    public static final String C_FECHA_GP = "FECHA";
    public static final String C_NOMBRE_GP = "NOMBRE";
    public static final String C_PAIS_GP = "PAIS";
    public static final String C_LONGITUD = "LONGITUD";
    public static final String C_VUELTAS = "NVUELTAS";
    public static final String C_DISTANCIA = "DISTANCIA";
    public static final String C_PRIMER_GP = "PRIMERGP";
    public static final String C_FOTO_GP = "FOTO";


    //TABLA PUNTOS
    public static final String C_ID_PUNTOS = "IDPUNTOS";
    public static final String C_POSICION = "POSICION";
    public static final String C_PUNTOS_POSICION = "PUNTOSPOSICION";


    //Código de creación de la tabla registro
    public static final String CREATE_TABLE_REGISTRO = "CREATE TABLE " + TABLE_REGISTRO + " ("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_EMAIL + " TEXT, "
            + C_NOMUSUARIO + "  TEXT, "
            + C_CONTRASEÑA + " TEXT "
            + ")";

    //Código de creación de la tabla escuderia
    public static final String CREATE_TABLE_ESCUDERIA = "CREATE TABLE " + TABLE_ESCUDERIA + " ("
            + C_ID_ESCUDERIA + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_NOMBRE_ESCUDERIA + " TEXT, "
            + C_SEDE + " TEXT, "
            + C_PAIS_ESCUDERIA + " TEXT, "
            + C_JEFE_ESCUDERIA + " TEXT, "
            + C_JEFE_TECNICO + " TEXT, "
            + C_CHASIS + " TEXT, "
            + C_UNIDAD_MOTOR + " TEXT, "
            + C_TITULOS_ESCUDERIA + " INTEGER, "
            + C_FOTO_ESCUDERIA + " TEXT "
            + ")";

    //Código de creación de la tabla piloto
    public static final String CREATE_TABLE_PILOTO = "CREATE TABLE " + TABLE_PILOTO + " ("
            + C_ID_PILOTO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_NOMBRE_PILOTO + " TEXT, "
            + C_APELLIDO_PILOTO + " TEXT, "
            + C_PAIS_PILOTO + " TEXT, "
            + C_NUMERO_PODIOS + " INTEGER, "
            + C_NUMERO_VICTORIA + " INTEGER, "
            + C_GP_DISPUTADO + " INTEGER, "
            + C_CUMPLEAÑOS + " TEXT, "
            + C_VUELTA_RAPIDA + " INTEGER, "
            + C_TITULOS_PILOTO + " INTEGER, "
            + C_FOTO_PILOTO + " TEXT, "
            + C_ID_ESCUDERIA + " INTEGER, "
            + " FOREIGN KEY (" + C_ID_ESCUDERIA + ") REFERENCES " + TABLE_ESCUDERIA + "( " + C_ID_ESCUDERIA  + ") "
            + "ON DELETE CASCADE ON UPDATE CASCADE"
            + ")";

    //Código de creación de la tabla circuito
    public static final String CREATE_TABLE_CIRCUITO = "CREATE TABLE " + TABLE_CIRCUITO + " ("
            + C_ID_CIRCUITO + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_FECHA_GP + " TEXT, "
            + C_NOMBRE_GP + " TEXT, "
            + C_PAIS_GP + " TEXT, "
            + C_LONGITUD + " INTEGER, "
            + C_VUELTAS + " INTEGER, "
            + C_DISTANCIA + " INTEGER, "
            + C_PRIMER_GP + " INTEGER, "
            + C_FOTO_GP + " TEXT "
            + ")";


    //Código de creación de la tabla puntos
    public static final String CREATE_TABLE_PUNTOS = "CREATE TABLE " + TABLE_SISTEMA_PUNTOS + " ("
            + C_ID_PUNTOS + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + C_POSICION + " TEXT, "
            + C_PUNTOS_POSICION + " INTEGER "
            + ")";
}
