package com.example.phs.ui.home

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.phs.R

class AppListAdapter(data: MutableList<String>?) :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_app, data) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.name,item)
    }
}
