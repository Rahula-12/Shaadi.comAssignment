package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class InfoDTO(
    @SerializedName("seed")
    val seed: String,
    @SerializedName("results")
    val results: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("version")
    val version: String
)
