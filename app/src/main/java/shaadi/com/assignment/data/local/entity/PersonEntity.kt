package shaadi.com.assignment.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val uuid:String,
    val name:String,
    val age:Int,
    val address:String,
    val image:String,
    val status:String="Unknown",
)
