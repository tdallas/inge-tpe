package com.ingeapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.ingeapp.model.entities.*;
import com.ingeapp.util.Converter;

@Database(entities = {Usuario.class, Pedido.class, Producto.class,
        Rol.class, Cliente.class}, version = 4)
@TypeConverters({Converter.class})
public abstract class IngeDb extends RoomDatabase {

    /**
     * public abstract AlgoDao algoDao();
     */
}
