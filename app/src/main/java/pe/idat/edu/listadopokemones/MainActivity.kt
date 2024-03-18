package pe.idat.edu.listadopokemones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import pe.idat.edu.listadopokemones.databinding.ActivityMainBinding
import pe.idat.edu.listadopokemones.retrofi.PokemonApiService
import pe.idat.edu.listadopokemones.retrofi.response.PokemonsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiRetrofit: Retrofit
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiRetrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        pokemonAdapter = PokemonAdapter()
        binding.rvPokemon.layoutManager = GridLayoutManager(
            applicationContext, 3

        )
        binding.rvPokemon.adapter = pokemonAdapter
        obtenerPokemonesRetrofit()

    }

    private fun obtenerPokemonesRetrofit() {
        val service = apiRetrofit.create(PokemonApiService::class.java)
        val pokemonsResponse = service.getPokemon()
        pokemonsResponse.enqueue(object : Callback<PokemonsResponse>{
            override fun onResponse(
                call: Call<PokemonsResponse>,
                response: Response<PokemonsResponse>
            ) {
                pokemonAdapter.postPokemones(
                    response.body()!!.results
                )
            }

            override fun onFailure(call: Call<PokemonsResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}