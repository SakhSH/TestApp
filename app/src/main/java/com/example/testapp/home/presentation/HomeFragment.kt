package com.example.testapp.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.testapp.R
import com.example.testapp.databinding.FragmentHomeBinding
import com.example.testapp.main.domain.models.ScreenState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    @Inject
    lateinit var listItemsAdapter: ListItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.screenState.observe(viewLifecycleOwner) {
            when (it) {
                ScreenState.Content -> showLoading(false)
                is ScreenState.Error -> showError(it.text)
                ScreenState.Loading -> showLoading(true)
            }
        }

        homeViewModel.cocktailList.observe(viewLifecycleOwner) {
            listItemsAdapter.submitList(it)
        }

        setupRecyclerView()
        setupSpinner()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() {
        with(binding.rvFood) {
            adapter = listItemsAdapter
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.rvFood.isVisible = !isLoading
        binding.loader.isVisible = isLoading
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setupSpinner() {
        val spinner: Spinner = binding.spinner
// Создайте ArrayAdapter, используя массив строк и макет счетчика по умолчанию.
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.city,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Укажите макет, который будет использоваться при появлении списка вариантов.
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Примените адаптер к спиннеру
            spinner.adapter = adapter
        }
    }
}