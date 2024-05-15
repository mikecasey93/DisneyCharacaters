package com.example.disneycharacaters.ui.character

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharacaters.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment() {
    lateinit var binding: FragmentCharacterBinding
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            characterViewModel.characterList.observe(viewLifecycleOwner) {
                rvCharacters.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = CharacterAdapter(it.data) {
                    }
                }
            }
        }
    }
}