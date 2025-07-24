package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class PersonsResponseDTO(
    @SerializedName("results")
    val results: List<PersonResultDTO>,
    @SerializedName("info")
    val info: InfoDTO
)
