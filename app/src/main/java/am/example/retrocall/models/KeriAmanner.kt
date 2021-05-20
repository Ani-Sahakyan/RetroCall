package am.example.retrocall.models


import com.google.gson.annotations.SerializedName

data class KeriAmanner(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("cordinats")
    val cordinats: CordinatsX?
)