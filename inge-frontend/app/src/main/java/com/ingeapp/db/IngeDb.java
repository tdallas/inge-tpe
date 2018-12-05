package com.ingeapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.ingeapp.model.entities.Pedido;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.model.entities.Usuario;
import com.ingeapp.util.Converter;

@Database(entities = {Usuario.class, Pedido.class, Producto.class}, version = 2)
@TypeConverters({Converter.class})
public abstract class IngeDb extends RoomDatabase {

    /**
     * public abstract AlgoDao algoDao();
     */
}
