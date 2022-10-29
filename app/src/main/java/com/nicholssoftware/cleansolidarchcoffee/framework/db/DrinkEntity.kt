package com.nicholssoftware.cleansolidarchcoffee.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nicholssoftware.core.data.Drink

@Entity(tableName = "drink")
data class DrinkEntity(var title: String,
                       var description: String,

                       @ColumnInfo(name = "content_description")
                       var contentDescription: String,

                       @PrimaryKey(autoGenerate = true)
                       var id: Long = 0L) {

    companion object {
        fun fromDrink(drink: Drink) = DrinkEntity(drink.title, drink.description,drink.contentDescription,drink.id)
    }

    fun toDrink() = Drink(title,description,contentDescription,id)
}