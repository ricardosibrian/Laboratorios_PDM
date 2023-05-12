package com.example.labo05.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labo05.R
import com.example.labo05.data.model.MovieModel
import com.example.labo05.databinding.FragmentHomeBinding
import com.example.labo05.ui.movie.MovieViewModel
import com.example.labo05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {

    private val moviewViewModel: MovieViewModel by activityViewModels {
        MovieViewModel.Factory
    }

    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: MovieRecyclerViewAdapter
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

        setRecyclerView(view)

        binding.buttonFloating.setOnClickListener {
            moviewViewModel.clearData()
            it.findNavController().navigate(R.id.action_homeFragment_to_newMovieFragment)
        }
    }

    private fun showSelectedItem(movie: MovieModel) {
        moviewViewModel.setSelectedMovie(movie)
        findNavController().navigate(R.id.action_homeFragment_to_movieFragment)
    }

    private fun displayMovies() {
        adapter.setData(moviewViewModel.getMovies())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.RecyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter { selectedMovie ->
            showSelectedItem(selectedMovie)
        }

        binding.RecyclerView.adapter = adapter
        displayMovies()
    }

}