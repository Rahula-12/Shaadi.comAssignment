package shaadi.com.assignment.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey
    val uuid:String,
    val name:String,
    val age:Int,
    val status:String="Unknown"
)
