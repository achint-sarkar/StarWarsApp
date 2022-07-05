package com.edcast.starwars.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.edcast.domain.data.characters.Character
import com.edcast.starwars.databinding.ListCharacterItemBinding
import timber.log.Timber

/*
Paging implementation for recyclerview
*/
class CharacterListAdapter(
    private var context: Context,
    private var callback:(Character)->Unit
) :
    PagingDataAdapter<Character, CharacterListAdapter.CharacterViewHolder>(CharacterDiffUtils()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListCharacterItemBinding.inflate(layoutInflater, parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }

    }
    //View holder Class for item list
    inner class CharacterViewHolder(private var listCharacterItemBinding: ListCharacterItemBinding) :
        RecyclerView.ViewHolder(listCharacterItemBinding.root) {
        fun bind(character: Character) {
            //listCharacterItemBinding.cardView.background.setTint(Color.parseColor(dashboardAnalytics.colorCodeCard))
            listCharacterItemBinding.characterName.text = character.name
            listCharacterItemBinding.cardView.setOnClickListener {
                callback(character)
            }
        }
    }
}
// Diff util class to check changed or new items
class CharacterDiffUtils : DiffUtil.ItemCallback<Character>() {
    override fun areItemsTheSame(
        oldItem: Character,
        newItem: Character
    ): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(
        oldItem: Character,
        newItem: Character
    ): Boolean {
        return oldItem == newItem
    }

}