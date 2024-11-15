package com.example.appseguranadainformacao.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appseguranadainformacao.R
import com.example.appseguranadainformacao.databinding.FragmentSecurityNewsBinding

class SecurityNewsFragment : Fragment() {

    private var _binding: FragmentSecurityNewsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecurityNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dicasSemana = listOf(
            NewsItem("Mantenha seu software atualizado", "Evite vulnerabilidades mantendo seu software sempre na versão mais recente."),
            NewsItem("Use senhas fortes", "Crie senhas com letras, números e símbolos para maior segurança.")
        )

        val alertasSeguranca = listOf(
            NewsItem("Novo ataque de phishing em empresas", "Hackers estão enviando e-mails falsos para roubar credenciais."),
            NewsItem("Falha crítica em servidores exposta", "Servidores vulneráveis podem ser explorados por invasores.")
        )

        val dicasAdapter = NewsAdapter(dicasSemana)
        binding.rvDicasSemana.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = dicasAdapter
        }

        val alertasAdapter = NewsAdapter(alertasSeguranca)
        binding.rvAlertasRecentes.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = alertasAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SecurityNewsFragment()
    }
}