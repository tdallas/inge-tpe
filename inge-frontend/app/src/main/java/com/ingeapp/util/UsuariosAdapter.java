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
import com.ingeapp.model.entities.Cliente;
import com.ingeapp.model.entities.Usuario;
import com.ingeapp.view.fragmentView.ClickListener;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.ViewHolder> {

    private List<Cliente> usuarios;

    public UsuariosAdapter() {
    }

    public void setList(List<Cliente> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuariosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row_usuarios, viewGroup, false);
        return new UsuariosAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosAdapter.ViewHolder viewHolder, int i) {
        //aca se bindea toda la data piola vago, el i es la position dentro de la lista de productos
    }

    @Override
    public int getItemCount() {
        return usuarios == null ? 0 : usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.email_usuario)
        TextView email;
        @BindView(R.id.nombre_usuario)
        TextView nombre;
        @BindView(R.id.apellido_usuario)
        TextView apellido;
        @BindView(R.id.activado)
        CheckBox activado;
        @BindView(R.id.imagen_usuario)
        ImageView imagen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
