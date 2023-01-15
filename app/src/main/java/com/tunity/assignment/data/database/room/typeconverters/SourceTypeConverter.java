package com.tunity.assignment.data.database.room.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tunity.assignment.data.database.room.entity.SourceLocal;
import java.lang.reflect.Type;

public class SourceTypeConverter {
    @TypeConverter
    public static String toJson(SourceLocal sourceLocal)
    {
        Gson gson=new Gson();
        return gson.toJson(sourceLocal);
    }
    @TypeConverter
    public static SourceLocal toSource(String json) {
        Gson gson=new Gson();
        Type type=new TypeToken<SourceLocal>(){}.getType();
        return gson.fromJson(json,type);
    }
}
