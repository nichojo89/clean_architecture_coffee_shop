package com.nicholssoftware.cleansolidarchcoffee

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nicholssoftware.cleansolidarchcoffee.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var _binding: FragmentCartBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCartBinding.inflate(inflater,container,false)
        return binding.root
    }
}