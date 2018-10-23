package tomazelli.aula.br.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("CALLBACK_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("CALLBACK_LCA", "Método onresume da mainactivity");
    }

    public void onClickQuadrado(View v){
        Intent intencaoAbrirTelaQuadrado = new Intent(this.getApplicationContext(), QuadradoPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaQuadrado);
    }

    public void onClickCirculo(View v){
        Intent intencaoAbrirTelaCirculo = new Intent(this.getApplicationContext(), CirculoPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaCirculo);

    }

    public void onClickTriangulo(View v){
        Intent intencaoAbrirTelaTriangulo = new Intent(this.getApplicationContext(), TrianguloPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaTriangulo);

    }
}
