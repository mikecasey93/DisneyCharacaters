package com.example.disneycharacaters.ui.disneygame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.disneycharacaters.databinding.FragmentDisneyGameBinding


class DisneyGameFragment : Fragment() {

    private var _binding: FragmentDisneyGameBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisneyGameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {

        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}