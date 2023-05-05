package com.example.labo05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.labo05.R
import com.example.labo05.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    //private lateinit var movieCardView: CardView
    //private lateinit var floatingActionButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_billboard, container, false)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //movieCardView = view.findViewById(R.id.movie_card_view)
        //floatingActionButton = view.findViewById(R.id.buttonFloating)

        binding.movieCardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
        }

        binding.buttonFloating.setOnClickListener(){
            it.findNavController().navigate(R.id.action_homeFragment_to_newMovieFragment)
        }
    }

}