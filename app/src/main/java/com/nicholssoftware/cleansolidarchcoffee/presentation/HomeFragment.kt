package com.nicholssoftware.cleansolidarchcoffee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.nicholssoftware.cleansolidarchcoffee.R
import com.nicholssoftware.cleansolidarchcoffee.databinding.FragmentHomeBinding
import com.nicholssoftware.cleansolidarchcoffee.framework.HomeViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.db.DrinkEntity

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(), ListAction {
    /**
     * TODO Replace with Retrofit network call to get drinks
     */
    private val temp = arrayListOf<DrinkEntity?>(
        DrinkEntity("Builders Tea","Our strongest tea which will be sure to get you going","strong Tea", R.drawable.builders_tea, 1L),
        DrinkEntity("Cappuccino","Have a nice hot cappuccino with us and enjoy","yummy cappuccino", R.drawable.cappuccino,2L),
        DrinkEntity("Chai Tea","Energy your body, mind & spirit with a cup of chai tea","energetic tea", R.drawable.chai_tea,3L),
        DrinkEntity("Columbian","A full bodied cup of columbian coffee dark roast","dark coffee",R.drawable.columbian, 4L),
        DrinkEntity("Egg Nog","Celebrate the holidays with a glass of delicious egg nog","egg nog nog nog",R.drawable.egg_nog,5L),
        DrinkEntity("Espresso","Our home brew espresso will give you the quick jolt of energy like lightning","zippy espresso",R.drawable.espresso, 6L),
        DrinkEntity("Irish Coffee","Blow off some steam with our spiked Irish coffee containing Jack Daniels whiskey","alcoholic coffee",R.drawable.irish_coffee, 7L),
        DrinkEntity("Pink Tea","All the way from the Himalayan mountains comes our earthy pink tea","earth tea",R.drawable.pink_tea, 8L),
    )
    private lateinit var _binding : FragmentHomeBinding
    private val binding get() = _binding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val g = viewModel.drinks
        val fragment = this
        val apt = DrinksListAdapter(view.context, temp,fragment)
        binding.gvCoffeeList.apply {
            adapter = apt
        }
    }

    /**
     * TODO Go to drink details
     */
    override fun onClick(id: Long) {
        val f = 0
    }

}

