package datos;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import modelo.Circuito;
import modelo.Escuderia;
import modelo.Piloto;
import modelo.Registro;
import modelo.SistemaPuntos;

public class ClaseBD extends SQLiteOpenHelper {
    public ClaseBD(@Nullable Context context) {
        super(context, ConstantesBD.BD_NAME, null, 2);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        //Creamos las tablas
        db.execSQL(ConstantesBD.CREATE_TABLE_REGISTRO);
        db.execSQL(ConstantesBD.CREATE_TABLE_ESCUDERIA);
        db.execSQL(ConstantesBD.CREATE_TABLE_PILOTO);
        db.execSQL(ConstantesBD.CREATE_TABLE_CIRCUITO);
        db.execSQL(ConstantesBD.CREATE_TABLE_PUNTOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Borrar las tablas si existen
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_REGISTRO);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_ESCUDERIA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_PILOTO);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_CIRCUITO);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBD.TABLE_SISTEMA_PUNTOS);

        //Volvera a crear
        onCreate(db);
    }

    //Registrar usuarios
    public long registrarUsuario(String email, String nomUsuario, String contraseña){

        //Creamos BD para almacenar registros en la tabla
        SQLiteDatabase db = getWritableDatabase();



        //Creamos un ContentValues con los valores a almacenar
        ContentValues valores = new ContentValues();
        valores.put(ConstantesBD.C_EMAIL, email);
        valores.put(ConstantesBD.C_NOMUSUARIO, nomUsuario);
        valores.put(ConstantesBD.C_CONTRASEÑA, contraseña);

        long id =  db.insert(ConstantesBD.TABLE_REGISTRO, null, valores);

        return id;
    }

    //Devolver todas los usuarios registrados en la app
    public ArrayList<Registro> comprobarUsuarios() {
        ArrayList<Registro> registros;
        registros = new ArrayList<>();

        String query = " SELECT * FROM " + ConstantesBD.TABLE_REGISTRO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") Registro resul = new Registro(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_EMAIL)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMUSUARIO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_CONTRASEÑA))
                );
                registros.add(resul);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return registros;
    }

    //Eliminar todos los usuarios de la tabla registro
    public void eliminarUsuarios(){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_REGISTRO;
        db.execSQL(consulta);
        db.close();
    }

    //Eliminar un usuario dependiendo de su nombre de usuario
    public void eliminarUsuario(String nomUsuario){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_REGISTRO + " WHERE " + ConstantesBD.C_NOMUSUARIO + " = " + nomUsuario;
        db.execSQL(consulta);
        db.close();
    }

    //Insertar escuderias
    public long insertarEscuderia(String nombre, String sede, String pais, String jefeEscuderia, String jefeTecnico, String chasis, String motor, String titulos, Uri foto){

        //Creamos BD para almacenar registros en la tabla
        SQLiteDatabase db = getWritableDatabase();



        //Creamos un ContentValues con los valores a almacenar
        ContentValues valores = new ContentValues();
        valores.put(ConstantesBD.C_NOMBRE_ESCUDERIA, nombre);
        valores.put(ConstantesBD.C_SEDE, sede);
        valores.put(ConstantesBD.C_PAIS_ESCUDERIA, pais);
        valores.put(ConstantesBD.C_JEFE_ESCUDERIA, jefeEscuderia);
        valores.put(ConstantesBD.C_JEFE_TECNICO, jefeTecnico);
        valores.put(ConstantesBD.C_CHASIS, chasis);
        valores.put(ConstantesBD.C_UNIDAD_MOTOR, motor);
        valores.put(ConstantesBD.C_TITULOS_ESCUDERIA, titulos);
        valores.put(ConstantesBD.C_FOTO_ESCUDERIA, String.valueOf(foto));

        long id =  db.insert(ConstantesBD.TABLE_ESCUDERIA, null, valores);

        return id;
    }

    //Devolver todas las escuderias registradas en la app
    public ArrayList<Escuderia> getEscuderias() {
        ArrayList<Escuderia> escuderias;
        escuderias = new ArrayList<>();

        String query = " SELECT * FROM " + ConstantesBD.TABLE_ESCUDERIA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") Escuderia resul = new Escuderia(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_ESCUDERIA)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMBRE_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_SEDE)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PAIS_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_JEFE_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_JEFE_TECNICO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_CHASIS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_UNIDAD_MOTOR)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_TITULOS_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FOTO_ESCUDERIA))
                );
                escuderias.add(resul);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return escuderias;
    }

    //Devolver una escuderia
    @SuppressLint("Range")
    public Escuderia getEscuderia(String id) {

        Escuderia e = null;

        String query = " SELECT * FROM " + ConstantesBD.TABLE_ESCUDERIA + " WHERE " + ConstantesBD.C_ID_ESCUDERIA + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                e = new Escuderia(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_ESCUDERIA)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMBRE_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_SEDE)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PAIS_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_JEFE_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_JEFE_TECNICO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_CHASIS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_UNIDAD_MOTOR)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_TITULOS_ESCUDERIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FOTO_ESCUDERIA))
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return e;
    }

    //Eliminar todas las escuderias de la tabla
    public void eliminarEscuderias(){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_ESCUDERIA;
        db.execSQL(consulta);
        db.close();
    }

    //Eliminar una escuderia dependiendo de su nombre
    public void eliminarEscuderia(String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_ESCUDERIA + " WHERE " + ConstantesBD.C_NOMBRE_ESCUDERIA + " = " + nombre;
        db.execSQL(consulta);
        db.close();
    }

    //Insertar Pilotos
    public long insertarPiloto(String nombre, String apellido, String pais, String nPodios, String nVictorias, String gpDisputados, String cumpleaños, String nVR, String titulos, Uri foto, String idEscuderia){

        //Creamos BD para almacenar registros en la tabla
        SQLiteDatabase db = getWritableDatabase();


        //Creamos un ContentValues con los valores a almacenar
        ContentValues valores = new ContentValues();
        valores.put(ConstantesBD.C_NOMBRE_PILOTO, nombre);
        valores.put(ConstantesBD.C_APELLIDO_PILOTO, apellido);
        valores.put(ConstantesBD.C_PAIS_PILOTO, pais);
        valores.put(ConstantesBD.C_NUMERO_PODIOS, nPodios);
        valores.put(ConstantesBD.C_NUMERO_VICTORIA, nVictorias);
        valores.put(ConstantesBD.C_GP_DISPUTADO, gpDisputados);
        valores.put(ConstantesBD.C_CUMPLEAÑOS,cumpleaños);
        valores.put(ConstantesBD.C_VUELTA_RAPIDA, nVR);
        valores.put(ConstantesBD.C_TITULOS_PILOTO, titulos);
        valores.put(ConstantesBD.C_FOTO_PILOTO, String.valueOf(foto));
        valores.put(ConstantesBD.C_ID_ESCUDERIA, idEscuderia);

        long id =  db.insert(ConstantesBD.TABLE_PILOTO, null, valores);

        return id;
    }

    //Devolver todos los pilotos registrados en la app
    public ArrayList<Piloto> getPilotos() {
        ArrayList<Piloto> pilotos;
        pilotos = new ArrayList<>();

        String query = " SELECT * FROM " + ConstantesBD.TABLE_PILOTO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") Piloto resul = new Piloto(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_PILOTO)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMBRE_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_APELLIDO_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PAIS_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NUMERO_PODIOS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NUMERO_VICTORIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_GP_DISPUTADO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_CUMPLEAÑOS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_VUELTA_RAPIDA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_TITULOS_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FOTO_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_ID_ESCUDERIA))

                );
                pilotos.add(resul);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return pilotos;
    }

    //Devolver un piloto
    @SuppressLint("Range")
    public Piloto getPiloto(String id) {

        Piloto p = null;

        String query = " SELECT * FROM " + ConstantesBD.TABLE_PILOTO + " WHERE " + ConstantesBD.C_ID_PILOTO + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                p = new Piloto(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_PILOTO)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMBRE_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_APELLIDO_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PAIS_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NUMERO_PODIOS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NUMERO_VICTORIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_GP_DISPUTADO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_CUMPLEAÑOS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_VUELTA_RAPIDA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_TITULOS_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FOTO_PILOTO)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_ID_ESCUDERIA))
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return p;
    }

    //Eliminar todos los pilotos de la tabla
    public void eliminarPilotos(){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_PILOTO;
        db.execSQL(consulta);
        db.close();
    }

    //Eliminar un piloto dependiendo de su nombre
    public void eliminarPiloto(String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_PILOTO + " WHERE " + ConstantesBD.C_NOMBRE_PILOTO + " = " + nombre;
        db.execSQL(consulta);
        db.close();
    }

    //Insertar circuito
    public long insertarCircuito(String longitud, String vueltas, String distancia, String primerGp, String paisGp, String nombreGp, String fechaGp, Uri foto){

        //Creamos BD para almacenar registros en la tabla
        SQLiteDatabase db = getWritableDatabase();



        //Creamos un ContentValues con los valores a almacenar
        ContentValues valores = new ContentValues();
        valores.put(ConstantesBD.C_LONGITUD, longitud);
        valores.put(ConstantesBD.C_VUELTAS, vueltas);
        valores.put(ConstantesBD.C_DISTANCIA, distancia);
        valores.put(ConstantesBD.C_PRIMER_GP, primerGp);
        valores.put(ConstantesBD.C_PAIS_GP, paisGp);
        valores.put(ConstantesBD.C_NOMBRE_GP, nombreGp);
        valores.put(ConstantesBD.C_FECHA_GP, fechaGp);
        valores.put(ConstantesBD.C_FOTO_GP, String.valueOf(foto));

        long id =  db.insert(ConstantesBD.TABLE_CIRCUITO, null, valores);

        return id;
    }

    //Devolver todos los circuitos registrados en la app
    public ArrayList<Circuito> getCircuitos() {
        ArrayList<Circuito> circuitos;
        circuitos = new ArrayList<>();

        String query = " SELECT * FROM " + ConstantesBD.TABLE_CIRCUITO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") Circuito resul = new Circuito(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_CIRCUITO)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FECHA_GP)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMBRE_GP)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PAIS_GP)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_LONGITUD)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_VUELTAS)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_DISTANCIA)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PRIMER_GP)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FOTO_GP))
                );
                circuitos.add(resul);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return circuitos;
    }

    //Devolver un circuito
    @SuppressLint("Range")
    public Circuito getCircuito(String id) {

        Circuito c = null;

        String query = " SELECT * FROM " + ConstantesBD.TABLE_CIRCUITO + " WHERE " + ConstantesBD.C_ID_CIRCUITO + " = " + id;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

               c = new Circuito(
                       cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_CIRCUITO)) + "",
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FECHA_GP)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_NOMBRE_GP)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PAIS_GP)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_LONGITUD)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_VUELTAS)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_DISTANCIA)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PRIMER_GP)),
                       cursor.getString(cursor.getColumnIndex(ConstantesBD.C_FOTO_GP))
                );
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return c;
    }

    //Eliminar todos los circuitos de la tabla
    public void eliminarCircuitos(){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_CIRCUITO;
        db.execSQL(consulta);
        db.close();
    }

    //Eliminar un circuito dependiendo de su id
    public void eliminarCircuito(String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_CIRCUITO + " WHERE " + ConstantesBD.C_NOMBRE_GP + " = " + nombre;
        db.execSQL(consulta);
        db.close();
    }

    //Insertar puntos
    public long insertarPuntos(String posicion, String puntosPosicion){

        //Creamos BD para almacenar registros en la tabla
        SQLiteDatabase db = getWritableDatabase();

        //Creamos un ContentValues con los valores a almacenar
        ContentValues valores = new ContentValues();
        valores.put(ConstantesBD.C_POSICION, posicion);
        valores.put(ConstantesBD.C_PUNTOS_POSICION, puntosPosicion);

        long id =  db.insert(ConstantesBD.TABLE_SISTEMA_PUNTOS, null, valores);

        return id;
    }

    //Devolver todos los puntos registrados en la app
    public ArrayList<SistemaPuntos> getPuntos() {
        ArrayList<SistemaPuntos> puntos;
        puntos = new ArrayList<>();

        String query = " SELECT * FROM " + ConstantesBD.TABLE_SISTEMA_PUNTOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {

                @SuppressLint("Range") SistemaPuntos resul = new SistemaPuntos(
                        cursor.getInt(cursor.getColumnIndex(ConstantesBD.C_ID_PUNTOS)) + "",
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_POSICION)),
                        cursor.getString(cursor.getColumnIndex(ConstantesBD.C_PUNTOS_POSICION))
                );
                puntos.add(resul);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return puntos;
    }

    //Eliminar todos los puntos de la tabla
    public void eliminarPuntos(){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_SISTEMA_PUNTOS;
        db.execSQL(consulta);
        db.close();
    }

    //Eliminar un punto dependiendo de su posicion
    public void eliminarpunto(int posicion){
        SQLiteDatabase db = getWritableDatabase();
        String consulta = "DELETE FROM " + ConstantesBD.TABLE_SISTEMA_PUNTOS + " WHERE " + ConstantesBD.C_POSICION + " = " + posicion;
        db.execSQL(consulta);
        db.close();
    }
}
