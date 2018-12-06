package com.ingeapp.view.fragment;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Producto;

public class ProductoPreview extends DialogFragment {

    private Producto producto;

    public static ProductoPreview newInstance(Producto producto) {
        ProductoPreview productoPreview = new ProductoPreview();
        productoPreview.setProducto(producto);
        return productoPreview;
    }

    private void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.producto_restaurante, container, false);

        TextView nombre = v.findViewById(R.id.nombre_producto);
        TextView descripcion = v.findViewById(R.id.descripcion_producto);
        TextView cantidad = v.findViewById(R.id.cantidad);

        nombre.setText(producto.getNombre().toUpperCase());
        descripcion.setText(producto.getDetalles());
        cantidad.setText(producto.getCantidad());

        return v;
    }
}
