package com.harnet69.letsexploreit.features.group

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.harnet69.letsexploreit.R
import com.harnet69.letsexploreit.data.model.GroupMember
import javax.inject.Inject

class GroupRecyclerAdapter @Inject constructor(
    private val glide: RequestManager
) : RecyclerView.Adapter<GroupRecyclerAdapter.GroupViewHolder>() {

    // More efficient way!!! calculates the difference between two lists and outputs a list of update operations that
    // converts the first list into the second one
    private val diffUtil = object : DiffUtil.ItemCallback<GroupMember>() {
        override fun areItemsTheSame(oldItem: GroupMember, newItem: GroupMember): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GroupMember, newItem: GroupMember): Boolean {
            return oldItem == newItem
        }
    }

    private val recyclerViewDiffer = AsyncListDiffer(this, diffUtil)

    var groupMembers: List<GroupMember>
        get() = recyclerViewDiffer.currentList
        set(value) = recyclerViewDiffer.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_group_member, parent, false)
        return GroupViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        //TODO implement dataBinding
        val groupMemberImg = holder.itemView.findViewById<ImageView>(R.id.groupMemberImgUrl)
        val groupMemberName = holder.itemView.findViewById<TextView>(R.id.groupMemberName)

        val groupMember = groupMembers[position]
        holder.itemView.apply {
            groupMemberName.text = "Name: ${groupMember.name}"
            glide.load(groupMember.profileImgUrl).into(groupMemberImg)
        }
    }

    override fun getItemCount(): Int {
        return groupMembers.size
    }

    class GroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}