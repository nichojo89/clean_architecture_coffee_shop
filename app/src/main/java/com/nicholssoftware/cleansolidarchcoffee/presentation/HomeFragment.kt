package com.nicholssoftware.cleansolidarchcoffee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
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
        DrinkEntity("Reg","Desc","accessability desc",1L),
        DrinkEntity("Reg2","Desc","accessability desc",2L),
        DrinkEntity("Reg3","Desc","accessability desc",3L),
        DrinkEntity("Reg4","Desc","accessability desc",4L),
        DrinkEntity("Reg5","Desc","accessability desc",5L),
        DrinkEntity("Reg6","Desc","accessability desc",6L),
        DrinkEntity("Reg7","Desc","accessability desc",7L),
    )
//    private val drinkAdapter = DrinksListAdapter(requireContext(), temp,this)

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
        binding.gvCoffeeList.apply {
            adapter = DrinksListAdapter(view.context, temp,fragment)
        }
    }

    /**
     * TODO Go to drink details
     */
    override fun onClick(id: Long) {
        val f = 0
    }

}

