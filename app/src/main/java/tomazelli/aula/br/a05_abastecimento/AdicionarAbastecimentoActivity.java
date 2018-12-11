package tomazelli.aula.br.a05_abastecimento;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdicionarAbastecimentoActivity extends AppCompatActivity {
    private EditText etKmAtual;
    private EditText etLitros;
    private EditText etData;
    private Spinner spPosto;
    private Abastecimento abastecimentoParaSalvar;

    private LocationManager locationManager;


    public void onClickSalvar(View v) {
        this.etKmAtual = findViewById(R.id.etKmAtual);
        this.etLitros = findViewById(R.id.etLitros);
        this.etData = findViewById(R.id.etData);
        this.spPosto = findViewById(R.id.spPosto);

        //Verifica se os editTexts estao vazios

        if (etKmAtual.getText().toString().equals("")) {
            this.etKmAtual.setError("Campo deve ser preenchido");
            return;
        }
        if (etLitros.getText().toString().equals("")) {
            this.etLitros.setError("Campo deve ser preenchido");
            return;
        }
        if (etData.getText().toString().equals("")) {
            this.etData.setError("Campo deve ser preenchido");
            return;
        }

        //Verifica se o Km inserido e menor que o anterior

        double ultimoKm = this.getIntent().getDoubleExtra("ultimoKm", -1);
        double kmDigitado = Double.parseDouble(etKmAtual.getText().toString());
        if (kmDigitado <= ultimoKm) {
            this.etKmAtual.setError("Km invalido");
            return;
        }

        getLocation(abastecimentoParaSalvar);
        abastecimentoParaSalvar = new Abastecimento();

        abastecimentoParaSalvar.setKm(Double.parseDouble(etKmAtual.getText().toString()));
        abastecimentoParaSalvar.setLitros(Double.parseDouble(etLitros.getText().toString()));
        abastecimentoParaSalvar.setDataAbastecimento(etData.getText().toString());
        abastecimentoParaSalvar.setPosto(spPosto.getSelectedItem().toString());

        boolean salvar = AbastecimentoDao.salvar(this.getApplicationContext(), abastecimentoParaSalvar);

        if (salvar) {
            setResult(1);
            finish();
        } else {
            Toast.makeText(this.getApplicationContext(), "Erro ao Salvar", Toast.LENGTH_SHORT).show();
        }
    }

}


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation(abastecimentoParaSalvar);
                } else {
                    Toast.makeText(this, "Vai dar ruim", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void getLocation(final Abastecimento abastecimentoParaSalvar)
    {
        try
        {
            locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            LocationListener locationListener = new LocationListener()
            {
                @Override
                public void onLocationChanged(Location location)
                {// ve se mudo de lugar
                    location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                    abastecimentoParaSalvar.setLat(location.getLatitude());
                    abastecimentoParaSalvar.setLng(location.getLongitude());
                    Log.d("latitude", Double.toString(location.getLatitude()));
                    Log.d("longitude", Double.toString(location.getLongitude()));

                }

                //coisa q nao vo usar mas tem q ter
                @Override
                public void onStatusChanged(String provider, int status, Bundle extras)
                {
                }

                @Override
                public void onProviderEnabled(String provider)
                {
                }

                @Override
                public void onProviderDisabled(String provider)
                {
                }
            };
            locationManager.requestLocationUpdates(locationManager.GPS_PROVIDER, 0, 0, locationListener);
        } catch (SecurityException e)
        {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        //Foca o primeiro editText
        EditText etKmAtual = findViewById(R.id.etKmAtual);
        etKmAtual.requestFocus();

        //Coloca de hint o ultimo km inserido
        double ultimoKm = this.getIntent().getDoubleExtra("ultimoKm", -1);
        if(ultimoKm >= 0)
            etKmAtual.setHint(Double.toString(ultimoKm));

//        //Populando spinner
//        Spinner spinner = findViewById(R.id.spPosto);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.postos, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);

        //Pede permissao para usar o GPS
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        else{

        }
    }
}
