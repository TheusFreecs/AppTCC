package com.example.appseguranadainformacao.home

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.appseguranadainformacao.core.Constants
import com.example.appseguranadainformacao.models.Question

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val constants = Constants()  // Usando a lista de questões da classe Constants
    private val _questions = constants.quizQuestions  // Pegue a lista de questões do Constants

    private val _currentQuestionIndex = MutableLiveData(0)
    val currentQuestionIndex: LiveData<Int> get() = _currentQuestionIndex

    private val _currentQuestion = MutableLiveData(_questions[_currentQuestionIndex.value ?: 0])
    val currentQuestion: LiveData<Question> get() = _currentQuestion

    private val _score = MutableLiveData(0)
    val score: LiveData<Int> get() = _score

    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences("quiz_preferences", Context.MODE_PRIVATE)

    // Função para verificar a resposta e somar os acertos
    fun checkAnswer(selectedOptionIndex: Int) {
        val currentQuestion = _currentQuestion.value
        if (currentQuestion != null && selectedOptionIndex == currentQuestion.correctAnswer) {
            _score.value = (_score.value ?: 0) + 1 // Soma acertos
        }
        nextQuestion() // Passa para a próxima questão
    }

    private fun nextQuestion() {
        val newIndex = (_currentQuestionIndex.value ?: 0) + 1
        if (newIndex < _questions.size) {
            _currentQuestionIndex.value = newIndex
            _currentQuestion.value = _questions[newIndex]
        }
    }

    // Função para verificar se é a última questão
    fun isLastQuestion(): Boolean {
        return (_currentQuestionIndex.value ?: 0) == _questions.size - 1
    }

    // Função para obter o número total de questões
    fun getTotalQuestions(): Int {
        return _questions.size
    }

    // Função para salvar a pontuação no SharedPreferences
    fun saveScore() {
        val editor = sharedPreferences.edit()
        editor.putInt("last_score", _score.value ?: 0)
        editor.apply()
    }

    // Função para carregar a última pontuação salva
    fun loadScore(): Int {
        return sharedPreferences.getInt("last_score", 0) // Retorna 0 se não houver pontuação salva
    }
}
