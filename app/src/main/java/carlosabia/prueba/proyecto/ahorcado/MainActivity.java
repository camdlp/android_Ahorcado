package carlosabia.prueba.proyecto.ahorcado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
    }

    public void botonPulsado(View vista) {
        Button boton = (Button) findViewById(vista.getId());
        boton.setVisibility(View.INVISIBLE);
    }
}
