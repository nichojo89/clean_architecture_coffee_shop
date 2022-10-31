package com.nicholssoftware.cleansolidarchcoffee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nicholssoftware.cleansolidarchcoffee.R
import com.nicholssoftware.cleansolidarchcoffee.databinding.FragmentHomeBinding
import com.nicholssoftware.cleansolidarchcoffee.framework.HomeViewModel
import com.nicholssoftware.cleansolidarchcoffee.framework.db.DrinkEntity
import com.nicholssoftware.core.data.Drink


class HomeFragment : Fragment(), ListAction {

    private lateinit var _binding : FragmentHomeBinding
    private val binding get() = _binding
    private lateinit var drinkAdapter: DrinksListAdapter

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ivSeasonal.setOnClickListener {
            //TODO Seasonal drink should be added to drink list,
            //TODO Add promotion boolean to indicate it shows as seasonal drink
            val tempSeasonalId = 123L

            goToDrinkDetails(tempSeasonalId)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drinkAdapter = DrinksListAdapter(view.context, arrayListOf(),this)
        binding.gvCoffeeList.apply {
            adapter = drinkAdapter
        }
        observeViewModel()
        viewModel.getDrinkOptions()
    }

    /**
     * TODO SWITCH TO FLOWS
     * IMPORTANT https://medium.com/androiddevelopers/migrating-from-livedata-to-kotlins-flow-379292f419fb
     */
    private fun observeViewModel(){
        viewModel.drinks.observe(viewLifecycleOwner, Observer { drinksList ->
            drinkAdapter.updateDrinks(drinksList)
        })
    }

    /**
     * Go to drink details when selecting from menu
     */
    override fun onClick(id: Long) = goToDrinkDetails(id)

    /**
     * Navigates to drink details fragment
     */
    private fun goToDrinkDetails(id: Long){
        val action = HomeFragmentDirections.actionHomeToDrinkInfoFragment(id)
        Navigation.findNavController(binding.root).navigate(action)
    }
}