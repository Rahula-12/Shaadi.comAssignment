package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName

data class PersonResultDTO(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: NameDTO,
    @SerializedName("location")
    val location: LocationDTO,
    @SerializedName("email")
    val email: String,
    @SerializedName("login")
    val login: LoginDTO,
    @SerializedName("dob")
    val dob: DobDTO,
    @SerializedName("registered")
    val registered: RegisteredDTO,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("cell")
    val cell: String,
    @SerializedName("id")
    val id: IdDTO,
    @SerializedName("picture")
    val picture: PictureDTO,
    @SerializedName("nat")
    val nat: String
)
