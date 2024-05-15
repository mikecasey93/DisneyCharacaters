package com.example.disneycharacaters.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
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

            binding.button.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_disneyDetailFragment_to_disneyFragment)

            }

        }



        return binding.root
    }
}