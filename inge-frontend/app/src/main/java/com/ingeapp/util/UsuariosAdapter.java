package com.ingeapp.util;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ingeapp.R;
import com.ingeapp.model.Producto;
import com.ingeapp.model.entities.Usuario;
import com.ingeapp.view.fragmentView.ClickListener;

import java.util.List;

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

        private ClickListener clickListener;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            this.clickListener = clickListener;
        }
    }
}
