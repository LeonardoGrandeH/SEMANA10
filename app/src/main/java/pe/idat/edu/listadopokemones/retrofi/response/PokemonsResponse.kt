package pe.idat.edu.listadopokemones.retrofi.response

data class PokemonsResponse(
    val count: Int,
    val next: String,
    val previuos: String,
    val results: List<Pokemon>
)
