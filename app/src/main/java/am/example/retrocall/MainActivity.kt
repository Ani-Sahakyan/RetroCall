package am.example.retrocall

import am.example.retrocall.models.Cordinats
import am.example.retrocall.models.CordinatsX
import am.example.retrocall.models.Dog
import am.example.retrocall.models.KeriAmanner
import am.example.retrocall.network.FoodBowlApi
import am.example.retrocall.network.FoodBowlRetrofitService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list: MutableList<Dog> = ArrayList()
        val listFoodBowl: MutableList<KeriAmanner> = ArrayList()

        GlobalScope.launch(Dispatchers.IO ){
            val call = DogRetrofitService.retrofit.create(DogsApi::class.java)
            try {
                val data =  call.getDogsData()
                if(data.isSuccessful){
                    val dogData = data.body()?.dogs
                    Log.i("ListSize","${dogData?.size}")

                    val listSize = if (dogData?.size!= null) dogData.size else 0
                    for (i in 0..listSize-1) {
                        list.add(
                            Dog(
                               dogData?.get(i)?.id,
                               dogData?.get(i)?.status,
                               dogData?.get(i)?.pictureUrl,
                               Cordinats( dogData?.get(i)?.cordinats?.latitude,
                                           dogData?.get(i)?.cordinats?.longitude)
                            )
                        )
                }

                }
            }catch (e: Exception){
                Log.i("Error","${e.message}")
            }

            // FoodBowl
            val call2 = FoodBowlRetrofitService.retrofit.create(FoodBowlApi::class.java)
            try {
                val dataFB =  call2.getFoodBowlData()
                if(dataFB.isSuccessful){
                    val foodBowlData = dataFB.body()?.keriAmanner
                    Log.i("ListSize","${foodBowlData?.size}")

                    val listSize = if (foodBowlData?.size!= null) foodBowlData.size else 0
                    for (i in 0..listSize-1) {
                        listFoodBowl.add(
                            KeriAmanner(
                                foodBowlData?.get(i)?.id,
                                CordinatsX( foodBowlData?.get(i)?.cordinats?.latitude,
                                    foodBowlData?.get(i)?.cordinats?.longitude)
                            )
                        )
                    }

                }
            }catch (e: Exception){
                Log.i("Error FoodBowl","${e.message}")
            }

        }

    }
}