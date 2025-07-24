package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class StreetDTO(
    @SerializedName("number")
    val number: Int,
    @SerializedName("name")
    val name: String
)
