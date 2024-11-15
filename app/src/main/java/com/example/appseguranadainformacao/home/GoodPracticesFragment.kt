package com.example.appseguranadainformacao.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.appseguranadainformacao.R
import com.example.appseguranadainformacao.core.Constants
import com.example.appseguranadainformacao.databinding.FragmentGoodPracticesBinding

class GoodPracticesFragment : Fragment() {

    private var _binding: FragmentGoodPracticesBinding? = null
    private val binding get() = _binding!!
    private val constants = Constants()
    private var selectedButton: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoodPracticesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonLayout = binding.buttonLayout

        var sectionNumber = 1

        val firstEntry = constants.securityInfo.entries.first()
        displayContent(firstEntry.key, firstEntry.value)

        for ((title, content) in constants.securityInfo) {
            val sectionButton = Button(requireContext()).apply {
                text = getTruncatedTitle(title)
                setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_default_color))
                setPadding(4, 2, 4, 2)

                val params = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                params.setMargins(4, 2, 4, 2)
                layoutParams = params

                setOnClickListener {
                    displayContent(title, content)
                    highlightSelectedButton(this)
                }
            }


            if (sectionNumber == 1) {
                selectedButton = sectionButton
                highlightSelectedButton(sectionButton)
            }

            // Adicionar o botão ao layout de botões
            buttonLayout.addView(sectionButton)
            sectionNumber++
        }
    }

    private fun getTruncatedTitle(title: String): String {
        val maxLength = (title.length * 0.33).toInt()
        return if (title.length > maxLength) {
            title.substring(0, maxLength) + "..."
        } else {
            title
        }
    }

    private fun displayContent(title: String, content: String) {
        val contentLayout = binding.contentLayout
        contentLayout.removeAllViews() // Limpa o conteúdo anterior

        val titleTextView = TextView(requireContext()).apply {
            text = title
            textSize = 20f
            setPadding(0, 16, 0, 8)
        }

        // Adicionar conteúdo
        val contentTextView = TextView(requireContext()).apply {
            text = content
            textSize = 16f
            setPadding(0, 0, 0, 16)
        }

        contentLayout.addView(titleTextView)
        contentLayout.addView(contentTextView)
    }

    private fun highlightSelectedButton(button: Button) {
        // Redefinir a cor do botão anterior
        selectedButton?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_default_color))

        // Destacar o novo botão
        button.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.button_selected_color))

        // Atualizar o botão selecionado
        selectedButton = button
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
