package com.ingeapp.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ingeapp.R;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.view.fragmentView.Calculator;
import com.ingeapp.view.fragmentView.ClickListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ViewHolder> {

    private final Calculator calculator;
    private List<Producto> productos = new ArrayList<>();

    public ProductosAdapter(Calculator calculator) {
        this.calculator = calculator;
    }

    public void setList(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row_productos, viewGroup, false);
        return new ViewHolder(v, calculator);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        Producto producto = productos.get(i);
        holder.nombreProducto.setText(producto.getNombre().toUpperCase());
        holder.descripcionProducto.setText(producto.getDetalles());
        holder.precio.setText("$" + producto.getPrecio());
        holder.producto = producto;

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final Calculator calculator;
        Producto producto;

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
        @BindView(R.id.inputCantidad)
        EditText inputCantidad;


        public ViewHolder(@NonNull View itemView, Calculator calculator) {
            super(itemView);
            this.calculator = calculator;
            ButterKnife.bind(this, itemView);
        }

        @OnEditorAction(R.id.inputCantidad)
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == EditorInfo.IME_ACTION_DONE) {
                producto.setCantidad(Integer.valueOf(inputCantidad.getText().toString()));
                calculator.calcularTotal();
            }
            return false;
        }

        @OnClick(R.id.grande_checkbox)
        public void onGrandeClick() {
            medianoCheckbox.setChecked(false);
            chicoCheckbox.setChecked(false);
            grandeCheckbox.setChecked(true);
        }

        @OnClick(R.id.mediano_checkbox)
        public void onMedianoClick() {
            grandeCheckbox.setChecked(false);
            chicoCheckbox.setChecked(false);
            medianoCheckbox.setChecked(true);
        }

        @OnClick(R.id.chico_checkbox)
        public void onChicoClick() {
            medianoCheckbox.setChecked(false);
            grandeCheckbox.setChecked(false);
            chicoCheckbox.setChecked(true);
        }
    }
}
