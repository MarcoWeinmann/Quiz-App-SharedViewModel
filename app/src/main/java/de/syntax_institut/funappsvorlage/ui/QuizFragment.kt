package de.syntax_institut.funappsvorlage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.funappsvorlage.databinding.FragmentQuizBinding

/**
 * Diese Klasse kümmert sich um die richtige Darstellung von UI Elementen.
 * Es ändert dabei >keine< Variablen im ViewModel
 */
class QuizFragment : Fragment() {

    // TODO: Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: SharedViewModel by activityViewModels()

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
        binding.viewmodel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        // TODO: Das spiel wird resetet
        viewModel.resetGame()

        // Setze onClickListeners
        binding.tvAnswerA.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 1 als Parameter
            viewModel.checkAnswer(1)
        }
        binding.tvAnswerB.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 2 als Parameter
            viewModel.checkAnswer(2)
        }
        binding.tvAnswerC.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 3 als Parameter
            viewModel.checkAnswer(3)
        }
        binding.tvAnswerD.setOnClickListener {
            // TODO: rufe die Funktion checkAnswer vom ViewModel auf mit 4 als Parameter
            viewModel.checkAnswer(4)
        }

        // TODO: Beobachte die Variablen um zu entscheiden, wann das Spiel beendet werden soll
        // Spiel ist vorbei, wenn die Million erreicht ist oder eine Frage falsch beantwortet wurde
        viewModel.wontheMillion.observe(
            viewLifecycleOwner) {
            if (it) {
                findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToResultFragment())
            }
        }
        viewModel.lastAnswer.observe(
            viewLifecycleOwner) {
            if (!it) {
                findNavController().navigate(QuizFragmentDirections.actionQuizFragmentToResultFragment())
            }
        }
    }
}
