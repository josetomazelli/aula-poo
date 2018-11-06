package tomazelli.aula.br.a05_controle_abastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
        setContentView(R.layout.activity_main);

        ArrayList<Abastecimento> abastecimentos =  new ArrayList<Abastecimento>();

        abastecimentos = AbastecimentoDao.getLista(this.getApplicationContext());

        if(abastecimentos.size()>1){
            double autonomia;
            double kmRodados;
            double litros = 0;

            kmRodados = abastecimentos.get(abastecimentos.size()-1).getKm() - abastecimentos.get(0).getKm();
            for(int i = 0; i<abastecimentos.size()-1; i++){
                litros += abastecimentos.get(i).getLitro();
            }

            autonomia = kmRodados/litros;
            TextView tvResultado = findViewById(R.id.etkmAtual);
            tvResultado.setText(String.valueOf(autonomia));
        }
    }


    public void Lista(View v){
        Intent listar = new Intent(this.getApplicationContext(), VisualizarListaActivity.class);

        startActivity(listar);
    }
}
