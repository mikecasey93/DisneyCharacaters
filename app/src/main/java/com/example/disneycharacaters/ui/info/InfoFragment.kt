package com.example.disneycharacaters.ui.info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharacaters.databinding.FragmentInfoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : Fragment() {
    lateinit var binding: FragmentInfoBinding
    private val gameViewModel: InfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val gameViewModel = ViewModelProvider(this).get(InfoViewModel::class.java)

        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply{
            gameViewModel.gameList.observe(viewLifecycleOwner) {
                rvGames.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = InfoAdapter(it.data){
                    }
                }
            }
        }
    }


}