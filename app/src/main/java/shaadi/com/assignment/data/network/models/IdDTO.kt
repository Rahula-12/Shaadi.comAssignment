package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName


data class IdDTO(
    @SerializedName("name")
    val name: String,
    @SerializedName("value")
    val value: String? // Value can sometimes be null or not present
)
