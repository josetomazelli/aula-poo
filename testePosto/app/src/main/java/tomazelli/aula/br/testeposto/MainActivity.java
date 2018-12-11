package tomazelli.aula.br.testeposto;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
        setContentView(R.layout.activity_main);
    }

    public void Lista(View v){
        Intent listar = new Intent(this.getApplicationContext(), VisualizarListaActivity.class);

        startActivity(listar);
    }

    protected void onResume(){
        super.onResume();
        ArrayList<Abastecimento> abastecimentos = new ArrayList<Abastecimento>();

        abastecimentos = AbastecimentoDao.getLista(this.getApplicationContext());

        if (abastecimentos.size() > 1) {
            double autonomia;
            double kmPercorridos;
            double litros = 0;

            kmPercorridos = abastecimentos.get(abastecimentos.size() - 1).getKm() - abastecimentos.get(0).getKm();
            for (int i = 0; i < abastecimentos.size() - 1; i++) {
                litros += abastecimentos.get(i).getLitro();
            }

            autonomia = kmPercorridos / litros;

            TextView tvResult = findViewById(R.id.tvAutonomia);
            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            tvResult.setText(nf.format(autonomia));
        }
    }
}
