package com.mohmmed.mosa.eg.news.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.mohmmed.mosa.eg.news.domain.module.Source

@ProvidedTypeConverter
class NewsTypeConverter {
    @TypeConverter
    fun sourceToString(source: Source): String{
        return "${source.id},${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source{
        val data = source.split(",")
        return Source(id = data[0], name = data[1])
    }


}