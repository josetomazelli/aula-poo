package tomazelli.aula.br.a05_abastecimento;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AbastecimentoViewHolder extends RecyclerView.ViewHolder
{
    private TextView tvKm;
    private TextView tvLitrosAbastecidos;
    private TextView tvDataAbastecimento;
    private ImageView ivPosto;

    private Abastecimento objetoSendoExibido;

    public AbastecimentoViewHolder(View itemView)
    {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent abrirEdicao = new Intent(view.getContext(), AbastecimentoDetalhado.class);
                abrirEdicao.putExtra("abastecimento", AbastecimentoViewHolder.this.objetoSendoExibido);
                ((AbastecimentoListaActivity)view.getContext()).startActivityForResult(abrirEdicao, AbastecimentoListaActivity.RC_ADICIONAR_ABASTECIMENTO);
            }
        });



        this.tvKm = itemView.findViewById(R.id.tvKM);
        this.tvLitrosAbastecidos = itemView.findViewById(R.id.tvLitros);
        this.tvDataAbastecimento = itemView.findViewById(R.id.tvData);
        this.ivPosto = itemView.findViewById(R.id.ivImagemPosto);
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento)
    {
        this.objetoSendoExibido = objetoAbastecimento;

        this.tvKm.setText("Km: " + Double.toString(objetoAbastecimento.getKm()));
        this.tvLitrosAbastecidos.setText(Double.toString(objetoAbastecimento.getLitros()) + "L");
        this.tvDataAbastecimento.setText(objetoAbastecimento.getDataAbastecimento());

        if(objetoAbastecimento.getPosto().equals("Texaco"))
        {
            ivPosto.setImageResource(R.drawable.logo_texaco);
        }
        else if(objetoAbastecimento.getPosto().equals("Shell"))
        {
            ivPosto.setImageResource(R.drawable.logo_shell);
        }
        else if(objetoAbastecimento.getPosto().equals("Petrobras"))
        {
            ivPosto.setImageResource(R.drawable.logo_petrobras);
        }
        else
        {
            ivPosto.setImageResource(R.drawable.logo_ipiranga);
        }
    }
}
