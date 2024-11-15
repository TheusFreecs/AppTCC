package com.example.appseguranadainformacao.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.appseguranadainformacao.R
import com.example.appseguranadainformacao.databinding.FragmentQuizBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private val quizViewModel: AppViewModel by activityViewModel()
    private var index: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel.currentQuestion.observe(viewLifecycleOwner) { question ->
            question?.let {
                resetButtonColors() // Reseta as cores dos botões

                binding.textViewQuestion.text = it.text
                binding.buttonOption1.text = it.options[0]
                binding.buttonOption2.text = it.options[1]
                binding.buttonOption3.text = it.options[2]
                binding.buttonOption4.text = it.options[3]

                setButtonListeners(it.correctAnswer)

                // Verifica se é a última questão para mudar o texto do botão
                if (quizViewModel.isLastQuestion()) {
                    binding.buttonNextQuestion.text = "Finalizar"
                } else {
                    binding.buttonNextQuestion.text = "Próxima Questão"
                }
            }
        }

        binding.buttonNextQuestion.setOnClickListener {
            if (index != null) {
                quizViewModel.checkAnswer(index!!)
                index = null

                // Se for a última questão, exibe o resultado e salva a pontuação
                if (quizViewModel.isLastQuestion()) {
                    quizViewModel.saveScore() // Salva a pontuação
                    showResult()
                }
            }
        }

    }

    // Função para verificar a resposta e mostrar feedback visual
    private fun setButtonListeners(correctAnswerIndex: Int) {
        binding.buttonOption1.setOnClickListener { handleAnswer(0, correctAnswerIndex) }
        binding.buttonOption2.setOnClickListener { handleAnswer(1, correctAnswerIndex) }
        binding.buttonOption3.setOnClickListener { handleAnswer(2, correctAnswerIndex) }
        binding.buttonOption4.setOnClickListener { handleAnswer(3, correctAnswerIndex) }
    }

    // Função para tratar a resposta e passar para a próxima pergunta
    private fun handleAnswer(selectedOptionIndex: Int, correctAnswerIndex: Int) {
        index = selectedOptionIndex
        if (selectedOptionIndex == correctAnswerIndex) {
            highlightButton(selectedOptionIndex, true) // Destaca o botão como correto
        } else {
            highlightButton(selectedOptionIndex, false) // Destaca o botão como incorreto
            highlightButton(correctAnswerIndex, true) // Destaca o botão correto
        }
    }

    // Função para destacar a resposta
    private fun highlightButton(buttonIndex: Int, isCorrect: Boolean) {
        val button = when (buttonIndex) {
            0 -> binding.buttonOption1
            1 -> binding.buttonOption2
            2 -> binding.buttonOption3
            3 -> binding.buttonOption4
            else -> null
        }

        button?.setBackgroundColor(
            if (isCorrect) ContextCompat.getColor(requireContext(), R.color.green)
            else ContextCompat.getColor(requireContext(), R.color.red)
        )
    }

    // Função para resetar as cores dos botões
    private fun resetButtonColors() {
        binding.buttonOption1.setBackgroundColor(Color.LTGRAY)
        binding.buttonOption2.setBackgroundColor(Color.LTGRAY)
        binding.buttonOption3.setBackgroundColor(Color.LTGRAY)
        binding.buttonOption4.setBackgroundColor(Color.LTGRAY)
    }

    // Função para exibir o resultado
    private fun showResult() {
        val score = quizViewModel.score.value ?: 0
        val totalQuestions = quizViewModel.getTotalQuestions()

        // Exibe o resultado final
        binding.textViewQuestion.text = "Você acertou $score de $totalQuestions questões!"
        // Oculta os botões de opções
        binding.buttonOption1.visibility = View.GONE
        binding.buttonOption2.visibility = View.GONE
        binding.buttonOption3.visibility = View.GONE
        binding.buttonOption4.visibility = View.GONE
        // Oculta o botão de próxima questão
        binding.buttonNextQuestion.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}