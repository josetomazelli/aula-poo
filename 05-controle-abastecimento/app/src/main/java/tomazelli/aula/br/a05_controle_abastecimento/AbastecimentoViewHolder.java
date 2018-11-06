package tomazelli.aula.br.a05_controle_abastecimento;

import android.content.Context;
import android.app.Application;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AbastecimentoViewHolder extends RecyclerView.ViewHolder {

    private TextView tvKm;
    private TextView tvLitros;
    private TextView tvData;
    private ImageView ivPosto;

    public AbastecimentoViewHolder(View itemView) {
        super(itemView);
        this.tvKm = itemView.findViewById(R.id.tvKm);
        this.tvLitros = itemView.findViewById(R.id.tvLitros);
        this.tvData = itemView.findViewById(R.id.tvData);
        this.ivPosto = itemView.findViewById(R.id.ivPosto);
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento){
        String km = "Km: " + String.valueOf(objetoAbastecimento.getKm());
        String litros = "Litros: " +String.valueOf(objetoAbastecimento.getLitro()) + " L";
        String posto = objetoAbastecimento.getNome();

        this.tvKm.setText(km);
        this.tvLitros.setText( litros );
        this.tvData.setText( objetoAbastecimento.getData() );

        if(posto.equals("Texaco")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.texaco));
        }else if(posto.equals("Petrobras")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.petrobras));
        }else if(posto.equals("Shell")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.shell));
        }else if(posto.equals("Ipiranga")){
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.ipiranga));
        }else{
            ivPosto.setImageDrawable(ContextCompat.getDrawable(App.getContext(), R.drawable.outros));
        }
    }
}
