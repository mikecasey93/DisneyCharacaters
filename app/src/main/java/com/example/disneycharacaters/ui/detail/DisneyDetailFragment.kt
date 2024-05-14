package com.example.disneycharacaters.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.disneycharacaters.R
import com.example.disneycharacaters.databinding.FragmentDisneyDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisneyDetailFragment : Fragment() {

    lateinit var binding: FragmentDisneyDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisneyDetailBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        val name = arguments?.getString("name")
        val profileImage = arguments?.getString("profileImage")

        binding.apply {
            firstNameDetail.text = name
            Glide.with(requireContext()).load(profileImage).into(profileImageDetail)

        }


        return binding.root
    }
}