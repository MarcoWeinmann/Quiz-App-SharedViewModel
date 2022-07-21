package de.syntax_institut.funappsvorlage.ui

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.funappsvorlage.R
import de.syntax_institut.funappsvorlage.databinding.FragmentResultBinding

/**
 * Diese Klasse kümmert sich um die richtige Darstellung von UI Elementen.
 */
class ResultFragment : Fragment() {

    // TODO: Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: SharedViewModel by activityViewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentResultBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_result, container, false)
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

        // TODO:  Fülle die TextViews mit den richtigen Informationen, je nachdem ob die Millionenfrage beantwortet wurde oder nicht
        if (viewModel.wontheMillion.value == true) {
            binding.tvResult.text = getString(R.string.game_won)
            binding.tvRightAnswer.text = getString(R.string.all_answers_correct)
        }else{
            var rightAnswer = ""
            when (viewModel.currentQuestion.value!!.rightAnswer){
                1 -> rightAnswer = viewModel.currentQuestion.value!!.answerA
                2 -> rightAnswer = viewModel.currentQuestion.value!!.answerB
                3 -> rightAnswer = viewModel.currentQuestion.value!!.answerC
                4 -> rightAnswer = viewModel.currentQuestion.value!!.answerD
            }
            binding.tvResult.text = getString(R.string.game_over)
            binding.tvRightAnswer.text = getString(R.string.right_answer_was, rightAnswer)
        }

        // TODO: Setzte den korrekten Text für das gewonnene Preisgeld
        binding.tvAmountWon.text = getString(R.string.you_won_amount, viewModel.moneyWon.value)

        // Wenn das Spiel neu gestartet werden soll
        binding.tvPlayAgain.setOnClickListener {
            findNavController().navigateUp()
        }

        // Wenn das Spiel beendet werden soll
        binding.tvExit.setOnClickListener {
            activity?.finish()
        }
    }
}
