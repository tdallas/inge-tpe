package com.ingeapp.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.ingeapp.util.Converter;

//@Database(entities = {}, version = 0)
@TypeConverters({Converter.class})
public abstract class IngeDb extends RoomDatabase {

    /**
     * public abstract AlgoDao algoDao();
     */
}
