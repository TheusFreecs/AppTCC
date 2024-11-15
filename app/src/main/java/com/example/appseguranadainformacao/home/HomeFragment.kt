package com.example.appseguranadainformacao.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.appseguranadainformacao.R
import com.example.appseguranadainformacao.core.Constants
import com.example.appseguranadainformacao.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.activityViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val quizViewModel: AppViewModel by activityViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnQuiz.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_QuizFragment)
        }

        binding.btnBoasPraticas.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_GoodPracticesFragment)
        }

        val lastScore = quizViewModel.loadScore()
        binding.txtUltimaPontuacao.text = "Sua última pontuação: $lastScore"

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // Infla o menu específico apenas para o HomeFragment
        inflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_news -> {
                findNavController().navigate(R.id.securityNewsFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        val constants = Constants()
        val randomTip = constants.dailyTips.random()
        binding.txtDicaDoDia.text = "Dica do Dia: $randomTip"

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment()
    }
}