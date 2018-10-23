package tomazelli.aula.br.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class QuadradoPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadradopasso1);
    }

    public void onClickAvancar(View v){
        EditText etAltura = findViewById(R.id.etAltura);
        EditText etBase = findViewById(R.id.etBase);

        double altura = Double.parseDouble(etAltura.getText().toString());
        double base = Double.parseDouble(etBase.getText().toString());


        Intent intencaoAbrirQuadradoResultado = new Intent(this.getApplicationContext(), QuadradoResultadoActivity.class);

        intencaoAbrirQuadradoResultado.putExtra("altura", altura);
        intencaoAbrirQuadradoResultado.putExtra("base", base);

        this.startActivity(intencaoAbrirQuadradoResultado);

    }
}
