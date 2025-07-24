package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class CoordinatesDTO(
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String
)
