package tomazelli.aula.br.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TrianguloPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulopasso1);
    }

    public void onClickAvancar(View v){
        EditText etAltura = findViewById(R.id.etAltura);
        EditText etBase = findViewById(R.id.etBase);

        double altura = Double.parseDouble(etAltura.getText().toString());
        double base = Double.parseDouble(etBase.getText().toString());


        Intent intencaoAbrirTrianguloResultado = new Intent(this.getApplicationContext(), TrianguloResultadoActivity.class);

        intencaoAbrirTrianguloResultado.putExtra("altura", altura);
        intencaoAbrirTrianguloResultado.putExtra("base", base);

        this.startActivity(intencaoAbrirTrianguloResultado);

    }
}
