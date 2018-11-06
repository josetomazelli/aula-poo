package tomazelli.aula.br.a05_controle_abastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class AdicionarPostoActivity extends AppCompatActivity {
    EditText etkmAtual;
    EditText etLitros;
    EditText etData;
    private Spinner spPosto;
    private Float kmAntigo;
    private String postos[] = new String[]{"Texaco", "Shell", "Petrobras", "Ipiranga", "Outros"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_posto);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, postos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spPosto = (Spinner) findViewById(R.id.spPosto);
        spPosto.setAdapter(adapter);

        kmAntigo = this.getIntent().getFloatExtra("kmAntigo", -1);
        etkmAtual = findViewById(R.id.etkmAtual);
        etLitros = findViewById(R.id.etLitros);
        etData = findViewById(R.id.etData);
    }

    public void salvarKm(View view) {
        Abastecimento abastecimento = new Abastecimento();

        if(etkmAtual.getText().toString().equals("")){
            Toast.makeText(this.getApplicationContext(), "Campos nao preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(etLitros.getText().toString().equals("")){
            Toast.makeText(this.getApplicationContext(), "Campos nao preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(etData.getText().toString().equals("")){
            Toast.makeText(this.getApplicationContext(), "Campos nao preenchidos", Toast.LENGTH_SHORT).show();
            return;
        }
        if(Double.parseDouble(etkmAtual.getText().toString()) <= this.kmAntigo){
            Toast.makeText(this.getApplicationContext(), "Km antigo maior que novo!", Toast.LENGTH_SHORT).show();
            return;
        }

        abastecimento.setKm(Float.parseFloat(etkmAtual.getText().toString()));
        abastecimento.setLitro(Float.parseFloat(etLitros.getText().toString()));
        abastecimento.setData(etData.getText().toString());
        abastecimento.setNome(spPosto.getSelectedItem().toString());

        boolean salvo = AbastecimentoDao.salvar(this.getApplicationContext(), abastecimento);

        if(salvo){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro!", Toast.LENGTH_SHORT).show();
        }
    }

}

