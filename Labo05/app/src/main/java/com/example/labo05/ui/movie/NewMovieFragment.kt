package com.example.labo05.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.labo05.R
import com.example.labo05.data.model.MovieModel
import com.google.android.material.textfield.TextInputEditText

class NewMovieFragment : Fragment() {

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    lateinit var name: TextInputEditText
    lateinit var category: TextInputEditText
    lateinit var description: TextInputEditText
    lateinit var calification: TextInputEditText
    lateinit var actionSubmit: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bind(view)
        actionSubmit.setOnClickListener {
            createMovie()
        }
    }

    private fun bind(view: View){
        name = view.findViewById(R.id.TextField1)
        category = view.findViewById(R.id.TextField2)
        description = view.findViewById(R.id.TextField3)
        calification = view.findViewById(R.id.TextField4)
        actionSubmit = view.findViewById(R.id.button)
    }

    private fun createMovie(){
        val newMovie = MovieModel(
            name.text.toString(),
            category.text.toString(),
            description.text.toString(),
            calification.text.toString()

        )
        viewModel.addMovie(newMovie)

        Log.d("APP TAG", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }


}