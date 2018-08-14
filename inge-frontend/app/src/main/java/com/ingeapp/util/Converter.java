package com.ingeapp.util;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

public class Converter {
    public static Gson gson = new GsonBuilder()
            .setLenient().serializeSpecialFloatingPointValues()
            .create();
    /**
     * todos los metodos aca van con la annotation @TypeConverter
     */

    @TypeConverter
    public static Date toDate(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long fromDate(Date value) {
        return value == null ? null : value.getTime();
    }



}
