package tomazelli.aula.br.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CirculoPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulopasso1);
    }

    public void onClickAvancar(View v){
        EditText etRaio = findViewById(R.id.etRaio);
        
        double raio = Double.parseDouble(etRaio.getText().toString());


        Intent intencaoAbrirCirculoResultado = new Intent(this.getApplicationContext(), CirculoResultadoActivity.class);

        intencaoAbrirCirculoResultado.putExtra("raio", raio);

        this.startActivity(intencaoAbrirCirculoResultado);

    }
}
