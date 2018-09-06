package com.globant.mariorangel.marvelcharacters.characters.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.util.FixedPreloadSizeProvider
import com.globant.mariorangel.marvelcharacters.R
import com.globant.mariorangel.models.MarvelCharacter
import kotlinx.android.synthetic.main.item_row_recycler_character.view.*

class CharactersAdapter(private val characterList: List<MarvelCharacter>) :
        RecyclerView.Adapter<CharactersAdapter.CharacterHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int) = CharacterHolder(p0.inflate(R.layout.item_row_recycler_character))
    override fun getItemCount() = characterList.size

    override fun onBindViewHolder(holder: CharacterHolder, position: Int) = holder.bind(characterList[position])

    class CharacterHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val preloadSizeImage = FixedPreloadSizeProvider<ImageView>(91, 123)

        fun bind(item: MarvelCharacter) = with(itemView) {
            text_character_name.text = item.name
            text_character_description.text = item.description
            val imagePath = item.thumbnail!!.path + "." + item.thumbnail!!.extension
            Glide.with(itemView).load(imagePath).into(image_character)
            itemView.setOnClickListener {  }
        }
    }

    private fun ViewGroup.inflate(layoutRes: Int): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, false)
    }
}


