package pe.idat.edu.listadopokemones.retrofi

import pe.idat.edu.listadopokemones.retrofi.response.Pokemon
import pe.idat.edu.listadopokemones.retrofi.response.PokemonsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT


interface PokemonApiService {
    @GET("pokemon")
    fun getPokemon():Call<PokemonsResponse>

    @POST("pokemon")
    fun registrarPokemon(@Body pokemon: Pokemon)

    @PUT("pokemon")
    fun actualizarPokemon(@Body pokemon: Pokemon)

}