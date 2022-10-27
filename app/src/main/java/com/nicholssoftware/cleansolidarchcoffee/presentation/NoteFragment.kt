package com.nicholssoftware.cleansolidarchcoffee.presentation

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.nicholssoftware.cleansolidarchcoffee.databinding.FragmentNoteBinding
import com.nicholssoftware.cleansolidarchcoffee.framework.NoteViewModel
import com.nicholssoftware.core.data.Note

/**
 * A simple [Fragment] subclass.
 * Use the [NoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NoteFragment : Fragment() {
    private var noteId = 0L
    private var _binding: FragmentNoteBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NoteViewModel by lazy {
        ViewModelProvider(this).get(NoteViewModel::class.java)
    }
    private var currentNote = Note("","",0L,0L)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            noteId = NoteFragmentArgs.fromBundle(it).noteid
            if(noteId != 0L){
                //present note from cache
                viewModel.getNote(noteId)
            }
        }
        //fab goes back
        binding.fabCheck.setOnClickListener {
            if(binding.etTitle.text.toString() != ""
                || binding.etContent.text.toString() != ""){
                val time = System.currentTimeMillis()
                currentNote.title = binding.etTitle.text.toString()
                currentNote.content = binding.etContent.text.toString()
                currentNote.updateTime = time
                if(currentNote.id == 0L){
                    currentNote.creationTime = time
                }
                viewModel.saveNote(currentNote)
            } else {
                Navigation.findNavController(it).popBackStack()
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.saved.observe(viewLifecycleOwner, Observer {
            if(it) {
                Toast.makeText(context, "Done!", Toast.LENGTH_SHORT).show()
                hideKeyboard()
                Navigation.findNavController(binding.etTitle).popBackStack()
            } else {
                Toast.makeText(context, "Something went wrong, please try again", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.currentNote.observe(viewLifecycleOwner, Observer { note ->
            note?.let {
                currentNote = it
                binding.etTitle.setText(it.title, TextView.BufferType.EDITABLE)
                binding.etContent.setText(it.content, TextView.BufferType.EDITABLE)
            }
        })
    }

    /**
     * TODO Convert to extention function
     */
    private fun hideKeyboard(){
        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etTitle.windowToken, 0)
    }
}