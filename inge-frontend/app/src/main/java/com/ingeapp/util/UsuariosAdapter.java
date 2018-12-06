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
import com.ingeapp.model.entities.Usuario;
import com.ingeapp.view.fragmentView.ClickListener;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;

public class UsuariosAdapter extends RecyclerView.Adapter<UsuariosAdapter.ViewHolder> {

    private List<Usuario> usuarios;
    private ClickListener clickListener;

    public UsuariosAdapter(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setList(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuariosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.row_usuarios, viewGroup, false);
        return new UsuariosAdapter.ViewHolder(v, clickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull UsuariosAdapter.ViewHolder viewHolder, int i) {
        //aca se bindea toda la data piola vago, el i es la position dentro de la lista de productos
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
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
        private ClickListener clickListener;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
        }
    }
}
