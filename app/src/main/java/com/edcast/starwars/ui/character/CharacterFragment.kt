package com.edcast.starwars.ui.character


import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.edcast.domain.data.characters.Character
import com.edcast.starwars.R
import com.edcast.starwars.StarWarApplication
import com.edcast.starwars.adapter.CharacterListAdapter
import com.edcast.starwars.databinding.FragmentCharacterBinding
import com.edcast.starwars.utils.NetworkChecker
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject


class CharacterFragment : Fragment() {
    @Inject
    lateinit var characterViewModelFactory: CharacterViewModelFactory
    private lateinit var characterViewModel: CharacterViewModel
    private var _binding: FragmentCharacterBinding? = null
    private val binding: FragmentCharacterBinding get() = _binding!!
    private lateinit var characterListAdapter: CharacterListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity().application as StarWarApplication).getCharacterListSubcomponent()
            .inject(this)
        characterViewModel =
            ViewModelProvider(this, characterViewModelFactory)[CharacterViewModel::class.java]
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)

        return binding.root
    }

    /*
    Init view for the fragment
    Intialize the
    * */
    private fun initView() {
        if (!NetworkChecker.isInternetAvailable(requireContext())) {
            showSnackBar(getString(R.string.no_internet))
        }
        characterListAdapter = CharacterListAdapter(requireContext(), ::showDetailFragment)
        binding.recyclerView.apply {
            this.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            this.adapter = characterListAdapter

        }
        //check the loading state
        characterListAdapter.addLoadStateListener { loadStates ->
            when (loadStates.refresh) {
                is LoadState.Error -> {
                    showSnackBar(getString(R.string.something_went_wrong))
                }
                is LoadState.Loading -> {
                    startAnimation()
                }
                is LoadState.NotLoading -> {
                    endAnimation()
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        initView()
        initCollector()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    //play the loading animation
    private fun startAnimation() {
        binding.loading.visibility = View.VISIBLE
        binding.loading.playAnimation()
        binding.loading.repeatCount = ValueAnimator.INFINITE
    }

    //play the stop animation
    private fun endAnimation() {
        if (_binding != null) {
            binding.loading.visibility = View.GONE
            if (binding.loading.isAnimating) {
                binding.loading.pauseAnimation()
            }
        }
    }

    //receive the data from view model
    private fun initCollector() {
        lifecycleScope.launchWhenCreated {
            characterViewModel.fetchCharacterList().collectLatest {
                characterListAdapter.submitData(it)
            }
        }
    }

    //show error snack bar with action button
    private fun showSnackBar(errorMessage: String?) {
        errorMessage?.let {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_INDEFINITE).setAction(R.string.retry) {
                characterListAdapter.retry()
            }.show()
        }
    }

    //callback function for the opening the detail Fragment
    private fun showDetailFragment(character: Character) {
        val bundle: Bundle = bundleOf(
            "character" to character
        )
        findNavController().navigate(R.id.action_navigation_character_to_navigation_details, bundle)
    }

}