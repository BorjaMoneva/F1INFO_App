package presentacion;

import androidx.annotation.AnyRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.f1app.R;

import java.util.ArrayList;

import datos.ClaseBD;
import modelo.Circuito;
import modelo.Escuderia;
import modelo.Piloto;
import modelo.Registro;
import modelo.SistemaPuntos;

public class MainActivity extends AppCompatActivity {

    //Variables
    EditText et1, et2;
    ClaseBD claseBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciacion de variables
        claseBD = new ClaseBD(this);
        et1 = (EditText) findViewById(R.id.etNombreUsurio);
        et2 = (EditText) findViewById(R.id.etContraseña);

        //Metodos
        ArrayList<SistemaPuntos> puntos = claseBD.getPuntos();
        if (puntos.size() == 0){
            insertarPuntosBD();
        }

        ArrayList<Circuito> circuitos = claseBD.getCircuitos();
        if (circuitos.size() == 0){
            insertarCircuitosBD();
        }

        ArrayList<Piloto> pilotos = claseBD.getPilotos();
        ArrayList<Escuderia> escuderias = claseBD.getEscuderias();
        if (pilotos.size() == 0 && escuderias.size() == 0){
            insertarPilotoEscuderia();
        }
    }
    //Cambio de ventana a RegistroActivity
    public void irRegistro(View view){
        Intent registro = new Intent(this, RegistroActivity.class);
        startActivity(registro);
    }

    //Iniciar sesion en la aplicacion
    public void iniciarSesion(View view){
        String nombreUsu = et1.getText().toString();
        String contraseña = et2.getText().toString();
        claseBD = new ClaseBD(this);

        if(nombreUsu.isEmpty() || contraseña.isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ERROR");
            builder.setMessage("Nombre de usuario o contraseña incorrectos");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            boolean encontrado = false;
            ArrayList<Registro> usuarios = claseBD.comprobarUsuarios();
            for (Registro u: usuarios) {
                if (u.getNomUsuario().equals(nombreUsu) && u.getContraseña().equals(contraseña)){
                    Intent inicio = new Intent(this,InicioActivity.class);
                    inicio.putExtra("nombreUsuario",nombreUsu);
                    startActivity(inicio);
                    encontrado = true;
                }
            }
            if(encontrado == false){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("ERROR");
                builder.setMessage("Nombre de usuario o contraseña incorrectos");
                builder.setPositiveButton("Aceptar", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
    }

    //Metodo para rellenar la tabla puntos
    public void insertarPuntosBD(){
        claseBD.insertarPuntos("1º", "25");
        claseBD.insertarPuntos("2º", "18");
        claseBD.insertarPuntos("3º", "15");
        claseBD.insertarPuntos("4º", "12");
        claseBD.insertarPuntos("5º", "10");
        claseBD.insertarPuntos("6º", "8");
        claseBD.insertarPuntos("7º", "6");
        claseBD.insertarPuntos("8º", "4");
        claseBD.insertarPuntos("9º", "2");
        claseBD.insertarPuntos("10º", "1");
        claseBD.insertarPuntos("11-20º", "0");
        claseBD.insertarPuntos("Vuelta rapida", "1");
    }

    //Metodo para poder dar valor a un uri con un elemento de drawable.
    public static final Uri getUriToResource(@NonNull Context context, @AnyRes int resId) throws Resources.NotFoundException {

        Resources res = context.getResources();

        Uri resUri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE +
                "://" + res.getResourcePackageName(resId)
                + '/' + res.getResourceTypeName(resId)
                + '/' + res.getResourceEntryName(resId));

        return resUri;
    }

    //Metodo para rellenar la tabla circuitos
    public void insertarCircuitosBD(){
        claseBD.insertarCircuito("5412","57","308238","2004","Sakhir", "FORMULA 1 GULF AIR BAHRAIN GRAND PRIX 2022", "18-20 MAR", getUriToResource(this, R.drawable.bahrain));
        claseBD.insertarCircuito("6174","50","308450","2021","Jeddah", "FORMULA 1 STC SAUDI ARABIAN GRAND PRIX 2022", "25-27 MAR", getUriToResource(this, R.drawable.arabia));
        claseBD.insertarCircuito("5278","58","306124","1996","Australia", "FORMULA 1 HEINEKEN AUSTRALIAN GRAND PRIX 2022", "08-10 ABR", getUriToResource(this, R.drawable.australia));
        claseBD.insertarCircuito("4909","63","309049","1980","Italia", "FORMULA 1 ROLEX GRAN PREMIO DELL'EMILIA-ROMAGNA 2022", "22-24 ABR", getUriToResource(this, R.drawable.imola));
        claseBD.insertarCircuito("5412","57","308326","2022","Miami", "FORMULA 1 CRYPTO.COM MIAMI GRAND PRIX 2022", "06-08 MAY", getUriToResource(this, R.drawable.miami));
        claseBD.insertarCircuito("4675","66","308424","1991","España", "FORMULA 1 PIRELLI GRAN PREMIO DE ESPAÑA 2022", "20-22 MAY", getUriToResource(this, R.drawable.espana));
        claseBD.insertarCircuito("3337","78","260286","1950","Monaco", "FORMULA 1 GRAND PRIX DE MONACO 2022", "27-29 MAY", getUriToResource(this, R.drawable.monaco));
        claseBD.insertarCircuito("6003","51","306049","2016","Baku", "FORMULA 1 AZERBAIJAN GRAND PRIX 2022", "10-12 JUN", getUriToResource(this, R.drawable.baku));
        claseBD.insertarCircuito("4361","70","305270","1978","Canada", "FORMULA 1 AWS GRAND PRIX DU CANADA 2022", "17-19 JUN", getUriToResource(this, R.drawable.canada));
        claseBD.insertarCircuito("5841","52","306198","1950","Gran Bretaña", "FORMULA 1 LENOVO BRITISH GRAND PRIX 2022", "01-03 JUL", getUriToResource(this, R.drawable.silverstone));
        claseBD.insertarCircuito("4318","71","306452","1970","Austria", "FORMULA 1 ROLEX GROSSER PREIS VON ÖSTERREICH 2022", "08-10 JUL", getUriToResource(this, R.drawable.austria));
        claseBD.insertarCircuito("5842","53","309690","1971","Francia", "FORMULA 1 LENOVO GRAND PRIX DE FRANCE 2022", "22-24 JUL", getUriToResource(this, R.drawable.francia));
        claseBD.insertarCircuito("4381","70","306633","1986","Hungria", "FORMULA 1 ARAMCO MAGYAR NAGYDÍJ 2022", "29-31 JUL", getUriToResource(this, R.drawable.hungria));
        claseBD.insertarCircuito("7004","44","308052","1950","Belgica", "FORMULA 1 ROLEX BELGIAN GRAND PRIX 2022", "26-28 AGO", getUriToResource(this, R.drawable.spa));
        claseBD.insertarCircuito("4259","72","306587","1952","Holanda", "FORMULA 1 HEINEKEN DUTCH GRAND PRIX 2022", "02-04 SEPT", getUriToResource(this, R.drawable.holanda));
        claseBD.insertarCircuito("5793","53","306720","1950","Italia", "FORMULA 1 PIRELLI GRAN PREMIO D’ITALIA 20222", "09-11 SEPT", getUriToResource(this, R.drawable.monza));
        claseBD.insertarCircuito("5063","61","308706","2008","Singapore", "FORMULA 1 SINGAPORE AIRLINES SINGAPORE GRAND PRIX 2022", "30-02 SEPT/OCT", getUriToResource(this, R.drawable.singapour));
        claseBD.insertarCircuito("5807","53","307471","1987","Japon", "FORMULA 1 HONDA JAPANESE GRAND PRIX 2022", "07-09 OCT", getUriToResource(this, R.drawable.japon));
        claseBD.insertarCircuito("5513","56","308405","2012","Estados Unidos", "FORMULA 1 ARAMCO UNITED STATES GRAND PRIX 2022", "21-23 OCT", getUriToResource(this, R.drawable.texas));
        claseBD.insertarCircuito("4304","71","305354","1963","Mexico", "FORMULA 1 GRAN PREMIO DE LA CIUDAD DE MÉXICO 2022", "28-30 OCT", getUriToResource(this, R.drawable.mexico));
        claseBD.insertarCircuito("4309","71","305879","1973","Brasil", "FORMULA 1 HEINEKEN GRANDE PRÊMIO DE SÃO PAULO 2022", "11-13 NOV", getUriToResource(this, R.drawable.brasil));
        claseBD.insertarCircuito("5281","58","306183","2009","Abu Dhabi", "FORMULA 1 ETIHAD AIRWAYS ABU DHABI GRAND PRIX 2022", "18-20 NOV", getUriToResource(this, R.drawable.abudabi));
    }

    //Metodo para insertar pilotos y escuderias
    public void insertarPilotoEscuderia(){
        claseBD.insertarEscuderia("Ferrari", "Maranello", "Italia", "Mattia Binotto", "Enrico Cardille/ Enrico Gualtieri", "F1-75", "Ferrari", "16", getUriToResource(this, R.drawable.ferrari));
        claseBD.insertarEscuderia("Red Bull Racing", "Milton Keynes", "Austria", "Christian Horner", "Pierre Waché", "RB-18", "Red Bull Powertrains", "4", getUriToResource(this, R.drawable.redbull));
        claseBD.insertarEscuderia("Mercedes", "Brackley", "Alemania", "Toto Wolf", "Mike Elliott", "W13", "Mercedes", "8", getUriToResource(this, R.drawable.mercedes));
        claseBD.insertarEscuderia("McLaren", "Hinwil", "Gran Bretaña", "Frédéric Vasseur", "Jan Monchaux", "MCL36", "Mercedes", "8", getUriToResource(this, R.drawable.mclaren));
        claseBD.insertarEscuderia("Alfa Romeo", "Maranello", "Italia", "Mattia Binotto", "Enrico Cardille/ Enrico Gualtieri", "C42", "Ferrari", "0", getUriToResource(this, R.drawable.alfaromeo));
        claseBD.insertarEscuderia("Alpine", "Enstone", "Francia", "Otmar Szafnauer", "Pat Fry", "A522", "Renault", "2", getUriToResource(this, R.drawable.alpine));
        claseBD.insertarEscuderia("Alpha Tauri", "Faenza", "Italia", "Franz Tost", "Jody Egginton", "AT03", "Red Bull Powertrains", "0", getUriToResource(this, R.drawable.alphatauri));
        claseBD.insertarEscuderia("Has F1 Team", "Kannapolis", "Estados Unidos", "Guenther Steiner", "Simone Resta", "F1-75", "Ferrari", "0", getUriToResource(this, R.drawable.has));
        claseBD.insertarEscuderia("Aston Martin", "Silverstone", "Gran Bretaña", "Mike Krack", "Andrew Green", "AMR22", "Mercedes", "0", getUriToResource(this, R.drawable.astonmartin));
        claseBD.insertarEscuderia("Williams", "Grove", "Gran Bretaña", "Jost Capito", "François-Xavier Demaison", "FW44", "Mercedes", "9", getUriToResource(this, R.drawable.williams));

        claseBD.insertarPiloto("Carlos", "Sainz", "España", "10", "0", "148", "01/09/1994", "0", "0", getUriToResource(this, R.drawable.sainz), "1");
        claseBD.insertarPiloto("Charles", "Leclerc", "Monaco", "17", "4", "88", "16/10/1997", "7", "0", getUriToResource(this, R.drawable.leclerc), "1");
        claseBD.insertarPiloto("Max", "Verstappen", "Holanda", "65", "24", "148", "30/09/1997", "18", "1", getUriToResource(this, R.drawable.verstappen), "2");
        claseBD.insertarPiloto("Sergio", "Perez", "Mexico", "19", "3", "221", "26/01/1990", "7", "0", getUriToResource(this, R.drawable.perez), "2");
        claseBD.insertarPiloto("Lewis", "Hamilton", "Gran Bretaña", "183", "103", "295", "07/01/1985", "59", "7", getUriToResource(this, R.drawable.hamilton), "3");
        claseBD.insertarPiloto("George", "Russell", "Gran Bretaña", "3", "0", "67", "15/02/1998", "1", "0", getUriToResource(this, R.drawable.russell), "3");
        claseBD.insertarPiloto("Lando", "Norris", "Gran Bretaña", "6", "0", "67", "13/11/1999", "4", "0", getUriToResource(this, R.drawable.norris), "4");
        claseBD.insertarPiloto("Daniel", "Ricciardo", "Australia", "32", "8", "217", "01/07/1989", "16", "0", getUriToResource(this, R.drawable.ricciardo), "4");
        claseBD.insertarPiloto("Valtteri", "Bottas", "Finlandia", "67", "10", "185", "28/08/1989", "19", "0", getUriToResource(this, R.drawable.bottas), "5");
        claseBD.insertarPiloto("Guanyu", "Zhou", "Chino", "0", "0", "7", "30/05/1999", "0", "0", getUriToResource(this, R.drawable.zhou), "5");
        claseBD.insertarPiloto("Fernando", "Alonso", "España", "98", "32", "343", "29/07/1981", "23", "2", getUriToResource(this, R.drawable.alonso), "6");
        claseBD.insertarPiloto("Esteban", "Ocon", "Francia", "2", "1", "96", "17/09/1996", "0", "0", getUriToResource(this, R.drawable.ocon), "6");
        claseBD.insertarPiloto("Pierre", "Gasly", "Francia", "3", "1", "93", "07/02/1996", "3", "0", getUriToResource(this, R.drawable.gasly), "7");
        claseBD.insertarPiloto("Yuki", "Tsunoda", "Japon", "0", "0", "29", "11/05/2000", "0", "0", getUriToResource(this, R.drawable.tsunoda), "7");
        claseBD.insertarPiloto("Kevin", "Magnussen", "Dinamarca", "1", "0", "127", "05/10/1992", "2", "0", getUriToResource(this, R.drawable.magnussen), "8");
        claseBD.insertarPiloto("Mick", "Schumacher", "Aleman", "0", "0", "28", "22/03/1999", "0", "0", getUriToResource(this, R.drawable.schumacher), "8");
        claseBD.insertarPiloto("Sebastian", "Vettel", "Aleman", "122", "53", "285", "03/07/1987", "38", "4", getUriToResource(this, R.drawable.vettel), "9");
        claseBD.insertarPiloto("Lance", "Stroll", "Canada", "3", "0", "107", "29/10/1998", "0", "0", getUriToResource(this, R.drawable.stroll), "9");
        claseBD.insertarPiloto("Alexander", "Albon", "Tailandia", "2", "0", "45", "23/03/1996", "0", "0", getUriToResource(this, R.drawable.albon), "10");
        claseBD.insertarPiloto("Nicholas", "Latifi", "Canada", "0", "0", "46", "29/06/1995", "0", "0", getUriToResource(this, R.drawable.latifi), "10");
    }
}