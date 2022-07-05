package com.edcast.starwars.ui.details

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.edcast.domain.data.characters.Character
import com.edcast.starwars.databinding.FragmentDetailsBinding
import java.text.SimpleDateFormat

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var bundle: Bundle
    private var character: Character? = null

    @SuppressLint("SimpleDateFormat")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        bundle = requireArguments()
        character = if (Build.VERSION.SDK_INT >= 33) {
            bundle.getParcelable<Character>("character", Character::class.java)
        } else {
            bundle.getParcelable<Character>("character")
        }

        character?.let {
            binding.valueName.text = it.name
            binding.valueHeight.text = it.height
            binding.valueMass.text = it.mass
            binding.valueDate.text = it.created?.let { dateString ->
                val dateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                val date = dateFormatter.parse(dateString)
                val newFormat = SimpleDateFormat("dd-MMM-yyyy HH:mm:ss")
                newFormat.format(date) ?: dateString
            } ?: it.created

        }
        binding.toolbar.linearBack.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}