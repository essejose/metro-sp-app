package com.essejose.metrosp.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.essejose.metrosp.R;
import com.essejose.metrosp.api.APIUtils;
import com.essejose.metrosp.model.Linha;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by essejose on 26/06/2017.
 */

public class LinhaAdpter extends RecyclerView.Adapter<LinhaAdpter.LinhaViewHolder>{

    private List<Linha> linhas;


    public LinhaAdpter(List<Linha> linhas){
        this.linhas = linhas;
    }

    @Override
    public LinhaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =  LayoutInflater.from(parent.getContext());

        View meuLayout = inflater.inflate(R.layout.linha_row,
                parent,false);


        return new LinhaViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(LinhaViewHolder holder, int position) {

        holder.tvTitulo.setText(linhas.get(position).getCor());
        holder.tvSubtitulo.setText(linhas.get(position).getNumero());

        Picasso.with(holder.itemView.getContext())
                .load(APIUtils.BASE_URL + linhas.get(position).getUrlImage())
                .placeholder(android.R .drawable.star_on)
                .into(holder.ivLogo);
    }

    @Override
    public int getItemCount() {
        return linhas.size();
    }

    public  class LinhaViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivLogo;
        public TextView tvTitulo;
        public TextView tvSubtitulo;

        public LinhaViewHolder(View itemView) {
            super(itemView);

            ivLogo      = (ImageView) itemView.findViewById(R.id.ivLogo);
            tvTitulo    = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubtitulo = (TextView) itemView.findViewById(R.id.tvSubtitulo);

        }
    }

    public  void update(List<Linha> linhas){
        this.linhas = linhas;
        notifyDataSetChanged();
    }

}
