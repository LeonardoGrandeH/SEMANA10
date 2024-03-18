package pe.idat.edu.listadopokemones

import android.app.slice.Slice
import android.transition.Slide
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.idat.edu.listadopokemones.databinding.ItemPokemonBinding
import pe.idat.edu.listadopokemones.retrofi.response.Pokemon
import java.util.ArrayList

class PokemonAdapter : RecyclerView.Adapter<PokemonAdapter.ViewHolder>(){
    private var lista = ArrayList<Pokemon>()

    inner class ViewHolder(val binding: ItemPokemonBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPokemonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(lista[position]){
                binding.tvNomPokemon.text = name
                val arrayUrl = url.split("/")
                Glide.with(itemView.context)
                    .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${arrayUrl[arrayUrl.size - 2]}.png")
                    .into(binding.ivPokemon)
            }
        }
    }

    override fun getItemCount() = lista.size

    fun postPokemones(nuevosPokemones: List<Pokemon>){
        lista.addAll(nuevosPokemones)
        notifyDataSetChanged()
    }
}