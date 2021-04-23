package com.github.billman64.acronymapp_albertsons_challenge.View

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.billman64.acronymapp_albertsons_challenge.Model.Data.Lf
import com.github.billman64.acronymapp_albertsons_challenge.R
import com.github.billman64.acronymapp_albertsons_challenge.databinding.AcronymItemLayoutBinding

class AcroAdapter( private var acroList:List<Lf>): RecyclerView.Adapter<AcroAdapter.AcronymViewHolder>() {

    inner class AcronymViewHolder(val binding: AcronymItemLayoutBinding): RecyclerView.ViewHolder(binding.root)

    fun updateList(acroList: List<Lf>){
        this.acroList = acroList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcronymViewHolder {
        val binding = AcronymItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AcronymViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AcronymViewHolder, position: Int) {
        holder.binding.longformTextview.text = acroList[position].lf
    }

    override fun getItemCount(): Int = acroList.size

}