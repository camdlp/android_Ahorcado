package carlosabia.prueba.proyecto.ahorcado;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String palabraOculta = "";
    int numeroFallos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            //Método que maneja los fragments

            getSupportFragmentManager()
                    .beginTransaction()
                    //Añade ventanaAhorcado
                    .add(R.id.ventanaJuego, new VentanaAhorcado()).commit();
        }
        palabraOculta = escogePalabra();
    }


    @Override
    protected void onStart() {
        super.onStart();
        palabraOculta = escogePalabra();
        String barras = "";
        for (int i = 0; i < palabraOculta.length(); i++) {
            barras += "_ ";
        }
        ((TextView) findViewById(R.id.palabraConGuiones)).setText(barras);
    }


    public void botonPulsado(View vista) {
        Button boton = (Button) findViewById(vista.getId());
        boton.setVisibility(View.INVISIBLE);
        chequeaLetra(boton.getText().toString());
    }

    private void chequeaLetra(String letra) {
        letra = letra.toUpperCase();
        //llama a la imagen del ahorcado
        ImageView imagenAhorcado = ((ImageView) findViewById(R.id.imagenAhorcado));
        TextView textoGuiones = ((TextView) findViewById(R.id.palabraConGuiones));
        String palabraConGuiones = textoGuiones.getText().toString();

        boolean acierto = false;

        for (int i = 0; i < palabraOculta.length(); i++) {
            if (palabraOculta.charAt(i) == letra.charAt(0)) {
                //quita el guión bajo de la letra correspondiente.
                palabraConGuiones = palabraConGuiones.substring(0, 2 * i) + letra +
                        palabraConGuiones.substring(2 * i + 1);
                acierto = true;

            }

        }

        //chequeo si se ha terminado la partida porque ha acertado todas las letras.
        if (!palabraConGuiones.contains("_")) {
            imagenAhorcado.setImageResource(R.drawable.acertastetodo);
        }

        textoGuiones.setText(palabraConGuiones);

        if (!acierto) {
            numeroFallos++;
            switch (numeroFallos) {
                case 0:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_0);
                    break;
                case 1:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_1);
                    break;
                case 2:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_2);
                    break;
                case 3:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_3);
                    break;
                case 4:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_4);
                    break;
                case 5:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_5);
                    break;
                default:
                    imagenAhorcado.setImageResource(R.drawable.ahorcado_fin);
                    break;
            }
        }

    }

    private String escogePalabra() {
        String auxiliar = "CETYS";
        String[] listaPalabras = {"hola", "adios", "cono", "desconozco", "icono", "diacono", "conocida", "conociemiento",
                "emoticono", "economia",};
        Random r = new Random();
        auxiliar = listaPalabras[r.nextInt(listaPalabras.length)];
        auxiliar = auxiliar.toUpperCase();
        return auxiliar;

    }
}

































