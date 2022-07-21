package de.syntax_institut.funappsvorlage.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.funappsvorlage.data.QuizRepository
import de.syntax_institut.funappsvorlage.data.model.Question

/**
 * Das ViewModel kümmert sich um die Logik des Spiels.
 * Es ruft dabei >keine< Variablen oder Funktionen aus dem QuizFragment auf
 */
class SharedViewModel : ViewModel() {

    // Erstelle eine QuizRepository Instanz
    val repo = QuizRepository()

    // Lade die Liste mit den Question Informationen aus der QuizRepository Instanz
    val questions = repo.questions.value

    // Der Index zeigt die Position der aktuellen Frage in der Liste
    var questionIndex = 0

    // Diese Variable speichert die aktuelle Frage
    private var _currentQuestion = MutableLiveData<Question>(questions!![questionIndex])
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    // Diese Variable speichert die aktuelle Preisstufe
    private var _currentPrice = MutableLiveData<Int>(currentQuestion.value!!.price)
    val currentPrice: LiveData<Int>
        get() = _currentPrice

    // Diese Variable speichert, wie viel Geld bereits erspielt wurde
    // TODO

    // Diese Variable speichert, wie die letzte Frage beantwortet wurde
    // TODO

    // Diese Variable speichert, ob die Millionenfrage beantwortet wurde
    // TODO

    /**
     * Diese Funktion überprüft, ob die Frage richtig oder falsch beantwortet wurde und setzt die
     * Variablen dementsprechend
     * Sie ruft wenn nötig die Funktion nextQuestion() auf, um zur nächsten Frage zu gelangen
     */
    fun checkAnswer(answerIndex: Int) {

        // falls die Antwortnummer der gespeicherten Antwortnummer der richtigen Antwort entspricht,
        // mach Folgendes, wenn nicht, setze _lastAnswer auf false
        if (answerIndex == _currentQuestion.value?.rightAnswer) {

            // TODO: erhöhe das erspielte Geld auf den Preis der aktuellen Preisstufe

            // fall es die letzte Frage in der Liste war, setzte _wonTheMillion auf true,
            // sonst wechsle zur nächsten Frage
            if (questionIndex == questions!!.size - 1) {
                // TODO: Millionen gewonnen
            } else {
                questionIndex++
                _currentQuestion.value = questions.get(questionIndex)
                _currentPrice.value = _currentQuestion.value?.price
            }
        } else {
            // TODO: letzte Frage wurde falsch beantwortet
        }
    }

    /**
     * Diese Funktion setzt alle Variablen auf ihren Ausgangswert zurück
     */
    fun resetGame() {
        questionIndex = 0
        _currentQuestion.value = questions!!.get(0)
        _currentPrice.value = _currentQuestion.value?.price

        // TODO: Reset moneyWon, lastAnswer, wonTheMillion
    }
}
