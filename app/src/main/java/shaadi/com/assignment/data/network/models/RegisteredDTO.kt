package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class RegisteredDTO(
    @SerializedName("date")
    val date: String,
    @SerializedName("age")
    val age: Int
)
