package com.example.disneycharacaters.ui.disney

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneycharacaters.R
import com.example.disneycharacaters.databinding.FragmentDisneyBinding
import com.example.disneycharacters.ui.disney.DisneyViewModel
import com.example.virginmoney.ui.disney.DisneyAdapter

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisneyFragment : Fragment() {

    private var _binding: FragmentDisneyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val disneyViewModel =
            ViewModelProvider(this).get(DisneyViewModel::class.java)

        _binding = FragmentDisneyBinding.inflate(inflater, container, false)
        val root: View = binding.root



        binding.apply{
//
//
//            }
            disneyViewModel.disneyList.observe(viewLifecycleOwner){
                rvDisney.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = DisneyAdapter(it.data) {disneyItemModel ->
                        findNavController().navigate(
                            R.id.action_disneyFragment_to_disneyDetailFragment,
                            bundleOf(
                                Pair("name",disneyItemModel?.name),
                                Pair("profileImage",disneyItemModel?.imageUrl),
                                Pair("sourceUrl",disneyItemModel?.sourceUrl),
                                Pair("createdAt",disneyItemModel?.createdAt),
                                Pair("updatedAt",disneyItemModel?.updatedAt),

                            )
                        )

                    }
                }
            }


        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}