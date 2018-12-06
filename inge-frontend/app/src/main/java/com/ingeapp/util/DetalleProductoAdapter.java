package com.ingeapp.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Producto;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetalleProductoAdapter extends RecyclerView.Adapter<DetalleProductoAdapter.ViewHolder> {

    List<Producto> productos;

    public void setList(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public DetalleProductoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.producto_restaurante, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DetalleProductoAdapter.ViewHolder viewHolder, int i) {
        Producto producto = productos.get(i);
        viewHolder.nombreProducto.setText(producto.getNombre().toUpperCase());
        viewHolder.descripcionProducto.setText(producto.getDetalles());
        viewHolder.cantidadProducto.setText(producto.getCantidad().toString());
    }

    @Override
    public int getItemCount() {
        return productos == null ? 0 : productos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.nombre_producto)
        TextView nombreProducto;
        @BindView(R.id.descripcion_producto)
        TextView descripcionProducto;
        @BindView(R.id.cantidad)
        TextView cantidadProducto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
