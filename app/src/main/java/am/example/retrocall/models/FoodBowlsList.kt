package am.example.retrocall.models


import com.google.gson.annotations.SerializedName

data class FoodBowlsList(
    @SerializedName("keri_amanner")
    val keriAmanner: List<KeriAmanner>
)