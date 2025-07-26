package shaadi.com.assignment.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import shaadi.com.assignment.R
import shaadi.com.assignment.databinding.PersonDetailStatusKnownBinding
import shaadi.com.assignment.databinding.PersonDetailStatusUnknownBinding
import shaadi.com.assignment.domain.Person

class PersonListAdapter(private val onAcceptOrReject:(Int,Int?)->Unit): PagingDataAdapter<Person, RecyclerView.ViewHolder>(
    object :DiffUtil.ItemCallback<Person> () {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem.uuid==newItem.uuid
        }

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean {
            return oldItem==newItem
        }
    }
) {

    class StatusKnownViewHolder private constructor(private val binding:PersonDetailStatusKnownBinding):RecyclerView.ViewHolder(binding.root) {
            val imageView: ImageView =binding.personImage
            val name: TextView =binding.name
            val ageAndAddress:TextView=binding.ageAndAddress
            val status:TextView=binding.status
            companion object {
                fun from(parent: ViewGroup):StatusKnownViewHolder {
                    val layoutInflater=LayoutInflater.from(parent.context)
                    val binding=PersonDetailStatusKnownBinding.inflate(layoutInflater)
                    return StatusKnownViewHolder(binding)
                }
            }
    }

    class StatusUnknownViewHolder private constructor(private val binding:PersonDetailStatusUnknownBinding):RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView =binding.personImage
        val name: TextView =binding.name
        val ageAndAddress:TextView=binding.ageAndAddress
        val acceptButton=binding.acceptButton
        val rejectButton=binding.rejectButton
        companion object {
            fun from(parent: ViewGroup):StatusUnknownViewHolder {
                val layoutInflater=LayoutInflater.from(parent.context)
                val binding=PersonDetailStatusUnknownBinding.inflate(layoutInflater)
                return StatusUnknownViewHolder(binding)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val personData=getItem(position)
        if(personData!=null && personData.status!="Unknown")    return 1
        return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val personData=getItem(position)
        when(holder) {
            is StatusKnownViewHolder->{
                holder.name.text=personData?.name
                Glide.with(holder.imageView).load(personData?.image).placeholder(R.drawable.no_profile_image).into(holder.imageView)
                holder.ageAndAddress.text="${personData?.age.toString()}, ${personData?.address}"
                holder.status.text=personData?.status
            }
            is StatusUnknownViewHolder-> {
                holder.name.text=personData?.name
                Glide.with(holder.imageView).load(personData?.image).placeholder(R.drawable.no_profile_image).into(holder.imageView)
                holder.ageAndAddress.text="${personData?.age.toString()}, ${personData?.address}"
                holder.acceptButton.setOnClickListener { onAcceptOrReject(1,personData?.id) }
                holder.rejectButton.setOnClickListener { onAcceptOrReject(0,personData?.id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            0->StatusUnknownViewHolder.from(parent)
            else->StatusKnownViewHolder.from(parent)
        }
    }
}