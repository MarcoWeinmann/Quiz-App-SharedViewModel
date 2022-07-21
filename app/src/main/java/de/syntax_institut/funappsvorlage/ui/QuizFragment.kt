package de.syntax_institut.funappsvorlage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.syntax_institut.funappsvorlage.databinding.FragmentQuizBinding

/**
 * Diese Klasse kümmert sich um die richtige Darstellung von UI Elementen.
 * Es ändert dabei >keine< Variablen im ViewModel
 */
class QuizFragment : Fragment() {

    // TODO: Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private lateinit var binding: FragmentQuizBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: weise der binding Variable viewmodel des Layouts den viewModel dieser Klasse zu.

        binding.lifecycleOwner = viewLifecycleOwner

        // TODO: Das spiel wird resetet

        // Setze onClickListeners
        binding.tvAnswerA.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 1 als Parameter
        }
        binding.tvAnswerB.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 2 als Parameter
        }
        binding.tvAnswerC.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 3 als Parameter
        }
        binding.tvAnswerD.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 4 als Parameter
        }

        // TODO: Beobachte die Variablen um zu entscheiden, wann das Spiel beendet werden soll
        // Spiel ist vorbei, wenn die Million erreicht ist oder eine Frage falsch beantwortet wurde
    }
}
