package com.nicholssoftware.cleansolidarchcoffee.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nicholssoftware.cleansolidarchcoffee.framework.di.ApplicationModule
import com.nicholssoftware.cleansolidarchcoffee.framework.di.DaggerViewModelComponent
import com.nicholssoftware.core.data.Drink
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel(application: Application): AndroidViewModel(application){
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    var drinks = MutableLiveData<List<Drink>>()
    @Inject
    lateinit var useCases : UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }


    fun getDrinkOptions(){
        coroutineScope.launch {
            val d = useCases.getAllDrinks()
            drinks.postValue(d)
        }
    }
}