package tomazelli.aula.br.a05_abastecimento;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AbastecimentoAdapter extends RecyclerView.Adapter
{
    public ArrayList<Abastecimento> listaAbastecimento;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View elementoPaiXml = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.abastecimento_item_lista, parent, false);
        AbastecimentoViewHolder minhaGaveta = new AbastecimentoViewHolder(elementoPaiXml);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        AbastecimentoViewHolder minhaGaveta = (AbastecimentoViewHolder) holder;
        Abastecimento atual = listaAbastecimento.get(position);
        minhaGaveta.atualizaGaveta(atual);
    }

    @Override
    public int getItemCount()
    {
        return listaAbastecimento.size();
    }
}
