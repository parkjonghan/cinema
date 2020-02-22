package com.kptech.cinema

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_main.view.*

class MainAdapter :  RecyclerView.Adapter <MainAdapter.MainViewHolder>() {

    var items: MutableList<MainData> = mutableListOf(MainData("kym71**",   "10분전","적당히 재밌다.오랜만에 잠 안 오는 영화 봤네" , rating = 5 ),
        MainData("blue**", "15분전","별루네요!!! ㅠ.ㅠ",rating = 3),MainData("redb**", "20분전","그냥 저냥 볼만 합니다",rating = 4))

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = MainViewHolder(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holer: MainViewHolder, position: Int) {
        items[position].let { item ->
            with(holer) {
                id.text = item.id
                timeElapsed.text = item.timeElapsed
                comment.text = item.comment
                rating = item.rating
            }
        }
    }

    inner class MainViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_main, parent, false)) {
        val id = itemView.id_text
        val timeElapsed = itemView.timeElapsed_text
        val comment = itemView.comment_text
        var rating = itemView.ratingBar.numStars

    }

}