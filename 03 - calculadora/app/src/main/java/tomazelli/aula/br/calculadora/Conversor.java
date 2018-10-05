package tomazelli.aula.br.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Conversor extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversor);

    }


    public void fazerAParadaAcontecer(View elementoClicado) {
        EditText valor1 = findViewById(R.id.decimal);
        EditText valor2 = findViewById(R.id.decimal2);
        TextView binario = findViewById(R.id.binario);

        String valor1Digitada = valor1.getText().toString();
        String valor2Digitado = valor2.getText().toString();

        if (valor1Digitada.equals("") || valor2Digitado.equals("")) {
            valor1.setError("Informe um valor");
            valor2.setError("Informe um valor");
            return;
        }

        try {
            int valor1Int = Integer.parseInt(valor1Digitada);
            int valor2Int = Integer.parseInt(valor2Digitado);

            int soma = valor1Int + valor2Int;
            int d = soma;
            StringBuffer binario1 = new StringBuffer();
            while (d > 0) {
                int b = d % 2;
                binario1.append(b);
                d = d >> 1;
            }

            binario.setText("Binario: " + binario1.reverse().toString());

            binario.setVisibility(View.VISIBLE);
        } catch (Exception e) {
            Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu", Toast.LENGTH_LONG);
            mensagemErro.show();
        }


    }
}

