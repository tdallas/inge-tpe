package com.ingeapp.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.view.fragmentView.ClickListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {

    private List<Producto> productos = new ArrayList<>();
    private ClickListener clickListener;

    public ProductosAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setList(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row_productos, viewGroup, false);
        return new ViewHolder(v, clickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //aca se bindea toda la data piola vago, el i es la position dentro de la lista de productos
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.preview)
        ImageView imageView;
        @BindView(R.id.nombre_producto)
        TextView nombreProducto;
        @BindView(R.id.descripcion_producto)
        TextView descripcionProducto;
        @BindView(R.id.precio)
        TextView precio;
        @BindView(R.id.chico_checkbox)
        CheckBox chicoCheckbox;
        @BindView(R.id.mediano_checkbox)
        CheckBox medianoCheckbox;
        @BindView(R.id.grande_checkbox)
        CheckBox grandeCheckbox;

        private ClickListener clickListener;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
        }
    }
}
