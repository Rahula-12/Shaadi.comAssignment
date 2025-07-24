package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class NameDTO(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)
