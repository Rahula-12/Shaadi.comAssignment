package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName


data class TimezoneDTO(
    @SerializedName("offset")
    val offset: String,
    @SerializedName("description")
    val description: String
)
