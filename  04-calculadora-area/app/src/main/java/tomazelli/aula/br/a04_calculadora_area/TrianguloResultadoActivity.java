package tomazelli.aula.br.a04_calculadora_area;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TrianguloResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangulocresultado);

        double lado = this.getIntent().getDoubleExtra("lado", -1);
        double base = this.getIntent().getDoubleExtra("base", -1);
        double areaT = (base * lado)/2;

        TextView tvResultado = findViewById(R.id.tvResultadoTriangulo);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvResultado.setText(nf.format(areaT));



    }
}
