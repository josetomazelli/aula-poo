package tomazelli.aula.br.a05_abastecimento;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class AbastecimentoDao
{
    private static ArrayList<Abastecimento> AL_CACHE = new ArrayList<>();

    public static boolean salvar(Context c, Abastecimento aSerSalvo)
    {
        DbHelper meuDb = new DbHelper(c);
        SQLiteDatabase db = meuDb.getWritableDatabase();

        ContentValues chaveValor = new ContentValues();
        chaveValor.put("km", aSerSalvo.getKm());
        chaveValor.put("litros", aSerSalvo.getLitros());
        chaveValor.put("lat", aSerSalvo.getLat());
        chaveValor.put("lng", aSerSalvo.getLng());
        chaveValor.put("data", aSerSalvo.getDataAbastecimento());
        chaveValor.put("posto", aSerSalvo.getPosto());
        long id = db.insert("abastecimento", null, chaveValor);
        aSerSalvo.setId(id);

        AL_CACHE.add(aSerSalvo);
        return true;
    }

    /*public static boolean salvarEdicao(Context c, Abastecimento aSerSalvo)
    {
        DbHelper meuDb = new DbHelper(c);
        SQLiteDatabase db = meuDb.getWritableDatabase();

        ContentValues chaveValor = new ContentValues();
        chaveValor.put("km", aSerSalvo.getKm());
        chaveValor.put("litros", aSerSalvo.getLitros());
        chaveValor.put("data", aSerSalvo.getDataAbastecimento());
        chaveValor.put("posto", aSerSalvo.getPosto());

        String[] whereId = {String.valueOf(aSerSalvo.getId())};

        db.update("abastecimento", chaveValor, "id = ?", whereId);
        db.close();

        getLista(c);
        return true;
    }

    public static boolean salvar(Context c, Abastecimento aSerSalvo)
    {
        if(aSerSalvo.getId() == -1)
        {
            Toast.makeText(c, "SALVANDOOOO", Toast.LENGTH_SHORT).show();
            return salvarNovo(c, aSerSalvo);
        }
        else
        {
            Toast.makeText(c, "EDITANDOOO", Toast.LENGTH_SHORT).show();
            return salvarEdicao(c, aSerSalvo);
        }
    }*/

    public static boolean excluir(Context c, Abastecimento aSerExcluido)
    {
        DbHelper meuDb = new DbHelper(c);
        SQLiteDatabase db = meuDb.getWritableDatabase();

        String[] whereId = {String.valueOf(aSerExcluido.getId())};
        db.delete("abastecimento", "id = ?", whereId);
        getLista(c);
        return true;
    }

    public static ArrayList<Abastecimento> getLista(Context c)
    {
        AL_CACHE = new ArrayList<>();

        DbHelper meuDb = new DbHelper(c);
        SQLiteDatabase db = meuDb.getReadableDatabase();

        String SQLBuscarAbastecimentos = "SELECT km, litros, lat, lng, data, posto, id FROM abastecimento";
        Cursor ponteiro = db.rawQuery(SQLBuscarAbastecimentos, null);

        while(ponteiro.moveToNext())
        {
            Abastecimento daVez = new Abastecimento();
            daVez.setKm(ponteiro.getDouble(0));
            daVez.setLitros(ponteiro.getDouble(1));
            daVez.setLat(ponteiro.getDouble(2));
            daVez.setLng(ponteiro.getDouble(3));
            daVez.setDataAbastecimento(ponteiro.getString(4));
            daVez.setPosto(ponteiro.getString(5));
            daVez.setId(ponteiro.getLong(6));
            AL_CACHE.add((daVez));
        }
        return AL_CACHE;
    }
}
