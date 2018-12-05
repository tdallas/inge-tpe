package com.ingeapp.util;

import android.arch.persistence.room.TypeConverter;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ingeapp.model.entities.Producto;
import com.ingeapp.model.entities.Usuario;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

    @TypeConverter
    public static List<Producto> StringToProductList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Producto>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String ProducListToString(List<Producto> someObjects) {
        return gson.toJson(someObjects);
    }

    @TypeConverter
    public static Usuario stringToUsuario(String data) {
        if (data != null){
            Type listType = new TypeToken<Usuario>() {}.getType();
            return gson.fromJson(data, listType);
        }
        return null;

    }

    @TypeConverter
    public static String usuarioToString(Usuario usuario) {
        return gson.toJson(usuario);
    }




}
