package com.nicholssoftware.cleansolidarchcoffee.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.nicholssoftware.cleansolidarchcoffee.R
import com.nicholssoftware.cleansolidarchcoffee.framework.di.ApplicationModule
import com.nicholssoftware.cleansolidarchcoffee.framework.di.DaggerViewModelComponent
import com.nicholssoftware.core.data.Drink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    /**
     * TODO Replace with Retrofit network call to get drinks
     */
    private val temp = arrayListOf<Drink?>(
        Drink("Builders Tea","Our strongest tea which will be sure to get you going","strong Tea", R.drawable.builders_tea, 1L),
        Drink("Cappuccino","Have a nice hot cappuccino with us and enjoy","yummy cappuccino", R.drawable.cappuccino,2L),
        Drink("Chai Tea","Energy your body, mind & spirit with a cup of chai tea","energetic tea", R.drawable.chai_tea,3L),
        Drink("Columbian","A full bodied cup of columbian coffee dark roast","dark coffee",
            R.drawable.columbian, 4L),
        Drink("Egg Nog","Celebrate the holidays with a glass of delicious egg nog","egg nog nog nog",
            R.drawable.egg_nog,5L),
        Drink("Espresso","Our home brew espresso will give you the quick jolt of energy like lightning","zippy espresso",
            R.drawable.espresso, 6L),
        Drink("Irish Coffee","Blow off some steam with our spiked Irish coffee containing Jack Daniels whiskey","alcoholic coffee",
            R.drawable.irish_coffee, 7L),
        Drink("Pink Tea","All the way from the Himalayan mountains comes our earthy pink tea","earth tea",
            R.drawable.pink_tea, 8L),
    )

    /**
     * Project setup on app launch
     */
    fun bootStrap(){
        coroutineScope.launch {
            try {
                val testasdasding = useCases.getAllDrinks()
                for(drink in temp){
                    useCases.addDrink(drink!!)
                }
                val testing = useCases.getAllDrinks()
                val x = testing.size

            } catch (e: java.lang.Exception){
                val d = e.stackTrace
                println(d)
            }
        }
    }
}