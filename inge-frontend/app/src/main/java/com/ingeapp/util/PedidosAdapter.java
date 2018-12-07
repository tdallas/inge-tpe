package com.ingeapp.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Pedido;
import com.ingeapp.view.fragmentView.ClickListener;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PedidosAdapter extends RecyclerView.Adapter<PedidosAdapter.ViewHolder> {

    private List<Pedido> pedidos;
    private ClickListener clickListener;
    private boolean isCliente;


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
        Pedido pedido = pedidos.get(i);

        viewHolder.pedido = pedido;
        viewHolder.iscliente = isCliente;

        viewHolder.usuario.setText(pedido.getCliente().getEmail());
        viewHolder.fecha.setText(CommonUtils.getFechaValida(pedido.getHoraEntrega()));

    }

    @Override
    public int getItemCount() {
        return pedidos == null ? 0 : pedidos.size();
    }

    public void setIsCliente(boolean isCliente) {
        this.isCliente = isCliente;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public boolean iscliente;
        public Pedido pedido;
        @BindView(R.id.user)
        TextView usuario;
        @BindView(R.id.hora)
        TextView fecha;

        private ClickListener clickListener;

        public ViewHolder(View v) {
            super(v);
        }

        @OnClick(R.id.content_pedidos)
        public void onPedidoClick() {
            clickListener.onClick(pedido.getId());
        }

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
            ButterKnife.bind(this, itemView);
        }
    }
}
