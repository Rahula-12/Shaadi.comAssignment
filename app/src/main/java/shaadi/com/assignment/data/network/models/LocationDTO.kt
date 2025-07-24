package shaadi.com.assignment.data.network.models

import com.google.gson.annotations.SerializedName


data class LocationDTO(
    @SerializedName("street")
    val street: StreetDTO,
    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("postcode")
    val postcode: String, // Keep as String to handle mixed types (e.g., "Z3L 1PB" and 18507)
    @SerializedName("coordinates")
    val coordinates: CoordinatesDTO,
    @SerializedName("timezone")
    val timezone: TimezoneDTO
)
