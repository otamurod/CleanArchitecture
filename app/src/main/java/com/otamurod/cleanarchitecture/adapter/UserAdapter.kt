package com.otamurod.cleanarchitecture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.otamurod.cleanarchitecture.databinding.UserTicketBinding
import com.otamurod.domain.models.UserData

class UserAdapter(private var context: Context, private var list: List<UserData>) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(private val userTicketBinding: UserTicketBinding) :
        RecyclerView.ViewHolder(userTicketBinding.root) {
        fun onBind(userData: UserData) {
            userTicketBinding.name.text = userData.name
            userTicketBinding.username.text = String.format("Username: %s", userData.username)
            userTicketBinding.company.text = String.format("Company: %s", userData.company.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            UserTicketBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}