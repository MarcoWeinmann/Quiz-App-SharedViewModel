package de.syntax_institut.funappsvorlage.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.syntax_institut.funappsvorlage.R
import de.syntax_institut.funappsvorlage.databinding.FragmentResultBinding

/**
 * Diese Klasse kümmert sich um die richtige Darstellung von UI Elementen.
 */
class ResultFragment : Fragment() {

    // TODO: Hier wird das ViewModel, in dem die Logik stattfindet, geholt

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

        binding.lifecycleOwner = viewLifecycleOwner

        // TODO:  Fülle die TextViews mit den richtigen Informationen, je nachdem ob die Millionenfrage beantwortet wurde oder nicht

        // TODO: Setzte den korrekten Text für das gewonnene Preisgeld

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
