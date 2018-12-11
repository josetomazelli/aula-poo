package tomazelli.aula.br.testeposto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class VisualizarListaActivity extends AppCompatActivity {

    private AbastecimentoAdapter adaptador;
    private boolean permissao;

    private final int RC_ADICIONAR_ABASTECIMENTO = 1312;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_lista);

        RecyclerView rvListaAbastecimento = findViewById(R.id.rvRegistros);

        this.adaptador = new AbastecimentoAdapter();

        this.adaptador.listaAbastecimento = AbastecimentoDao.getLista(this.getApplicationContext());

        rvListaAbastecimento.setAdapter(this.adaptador);

        rvListaAbastecimento.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));
    }

    public void telaAdicionarPosto(View v){
        Intent intencao = new Intent(this.getApplicationContext(), AdicionarPostoActivity.class);
        if(this.adaptador.listaAbastecimento.size()>0) {
            intencao.putExtra("kmAntigo", this.adaptador.listaAbastecimento.get(this.adaptador.listaAbastecimento.size() - 1).getKm());
        }
        startActivityForResult(intencao, RC_ADICIONAR_ABASTECIMENTO);
        intencao.putExtra("permissao", permissao);
    }
    public void telaVoltar(View v){
        Intent intencao = new Intent(this.getApplicationContext(), MainActivity.class);
        startActivity(intencao);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RC_ADICIONAR_ABASTECIMENTO){
            //estou tratando o fechamento da activity AdicionarAvaliacaoActivity
            if(resultCode == 1){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 1!!!!!", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 2){
                Toast.makeText(this.getApplicationContext(), "AÇÃO 2 -- -- - - - - - - ", Toast.LENGTH_LONG).show();
                this.adaptador.notifyDataSetChanged();
            }else if (resultCode == 0){
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON (PROVÁVEL)...", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this.getApplicationContext(), "Retorno não tratado...", Toast.LENGTH_LONG).show();
            }
        }else{
            //veio de algum lugar obscuro...

        }

    }

}
