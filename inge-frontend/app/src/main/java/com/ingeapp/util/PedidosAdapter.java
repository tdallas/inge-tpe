package com.ingeapp.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingeapp.R;
import com.ingeapp.model.entities.Pedido;
import com.ingeapp.view.fragmentView.ClickListener;

import java.util.List;

public class PedidosAdapter extends RecyclerView.Adapter<PedidosAdapter.ViewHolder> {

    private List<Pedido> pedidos;
    private ClickListener clickListener;

    public PedidosAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setList(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @NonNull
    @Override
    public PedidosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row_pedidos, viewGroup, false);
        return new PedidosAdapter.ViewHolder(v, clickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull PedidosAdapter.ViewHolder viewHolder, int i) {
        //aca se bindea toda la data piola vago, el i es la position dentro de la lista de productos
    }

    @Override
    public int getItemCount() {
        return pedidos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ClickListener clickListener;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
        }
    }
}
