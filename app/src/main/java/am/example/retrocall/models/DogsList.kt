package am.example.retrocall.models


import com.google.gson.annotations.SerializedName

data class DogsList(
    @field:SerializedName("dogs")
    val dogs: List<Dog>?
)