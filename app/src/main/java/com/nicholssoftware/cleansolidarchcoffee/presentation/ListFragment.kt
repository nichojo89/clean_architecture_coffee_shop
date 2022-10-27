package com.nicholssoftware.cleansolidarchcoffee.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicholssoftware.cleansolidarchcoffee.databinding.FragmentListBinding
import com.nicholssoftware.cleansolidarchcoffee.framework.NoteListViewModel

class ListFragment : Fragment(), ListAction {
    private val notesListAdapter = NotesListAdapter(arrayListOf(), this)
    private val viewModel: NoteListViewModel by lazy {
        ViewModelProvider(this).get(NoteListViewModel::class.java)
    }

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.noteListView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = notesListAdapter
        }
        binding.fabAddNote.setOnClickListener { goToNoteDetails() }

        observeViewModel()
    }
    private fun observeViewModel(){
        viewModel.notes.observe(viewLifecycleOwner, Observer { notesList ->
            binding.loadingBar.visibility = View.GONE
            binding.noteListView.visibility = View.VISIBLE
            notesListAdapter.updateNotes(notesList.sortedBy { it.updateTime })
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getNotes()
    }

    private fun goToNoteDetails(id: Long = 0L){
        val action = ListFragmentDirections.actionListFragmentToNoteFragment(id)
        Navigation.findNavController(binding.noteListView).navigate(action)
    }

    override fun onClick(id: Long) {
        goToNoteDetails(id)
    }


}