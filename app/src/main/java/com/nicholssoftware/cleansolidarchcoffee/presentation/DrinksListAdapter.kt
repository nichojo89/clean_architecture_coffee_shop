package com.nicholssoftware.cleansolidarchcoffee.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.card.MaterialCardView
import com.nicholssoftware.cleansolidarchcoffee.R
import com.nicholssoftware.cleansolidarchcoffee.framework.db.DrinkEntity

class DrinksListAdapter(context: Context, courseModelArrayList: ArrayList<DrinkEntity?>, val actions: ListAction) :
    ArrayAdapter<DrinkEntity?>(context, 0, courseModelArrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listitemView = convertView
        if (listitemView == null) {
            listitemView = LayoutInflater.from(context).inflate(R.layout.drink_item, parent, false)

            val drinkTitle = listitemView.findViewById<TextView>(R.id.tv_drink_title)
            val drinkImage = listitemView.findViewById<ImageView>(R.id.iv_drink)

            val drink: DrinkEntity? = getItem(position)

            drink?.let {
                drinkTitle.setText(drink.title)
                drinkImage.setImageResource(drink.imageResource)

                val drinkCard = listitemView.findViewById<MaterialCardView>(R.id.drinkLayout)
                drinkCard.setOnClickListener {
                    actions.onClick(drink.id)
                }
            }
        }

        return listitemView!!
    }
}