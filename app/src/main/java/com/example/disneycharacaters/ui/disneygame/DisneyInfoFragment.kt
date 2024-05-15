package com.example.disneycharacaters.ui.disneygame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.disneycharacaters.R
import com.example.disneycharacaters.databinding.FragmentDisneyBinding
import com.example.disneycharacaters.databinding.FragmentDisneyDetailBinding
import com.example.disneycharacaters.databinding.FragmentDisneyInfoBinding
import com.example.disneycharacters.ui.disney.DisneyInfoViewModel
import com.example.virginmoney.ui.disney.DisneyAdapter


class DisneyInfoFragment : Fragment() {
    lateinit var binding: FragmentDisneyDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDisneyDetailBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        val name = arguments?.getString("name")
        val source = arguments?.getString("sourceUrl")
        val profileImage = arguments?.getString("profileImage")
        val createdAt = arguments?.getString("createdAt")
        val updatedAt = arguments?.getString("updatedAt")

        binding.apply {
            firstNameDetail.text = name
            sourceUrl.text = source
            create.text = "Created At: ${createdAt}"
            update.text = "Updated At: ${updatedAt}"
            Glide.with(requireContext()).load(profileImage).into(profileImageDetail)

        }


        return binding.root
    }
}