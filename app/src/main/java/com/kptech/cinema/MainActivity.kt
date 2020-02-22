package com.kptech.cinema

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class SELECT_LIKE_TYPE  { NONE,LIKE, DISLIKE}
    private  var likeCnt :Int =50
    private  var disLikeCnt : Int  =50
    private  var selectedLikeType : SELECT_LIKE_TYPE = SELECT_LIKE_TYPE.NONE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comment_list.adapter = MainAdapter()
        comment_list.layoutManager = LinearLayoutManager(this)


        btn_like.setOnClickListener {

            if(selectedLikeType==SELECT_LIKE_TYPE.LIKE)
                return@setOnClickListener
            selectedLikeType=SELECT_LIKE_TYPE.LIKE
            likeCnt++
            if(disLikeCnt>0)
                disLikeCnt--
            likeCntText.text = likeCnt.toString()
            dislikeCntText.text = disLikeCnt.toString()
            btn_dislike.setImageResource(R.drawable.ic_thumb_down)
            btn_like.setImageResource(R.drawable.ic_thumb_up_selected)
        }

        btn_dislike.setOnClickListener {

            if(selectedLikeType==SELECT_LIKE_TYPE.DISLIKE)
                return@setOnClickListener
            selectedLikeType=SELECT_LIKE_TYPE.DISLIKE
            disLikeCnt++
            if(likeCnt>0)
                likeCnt--
            likeCntText.text = likeCnt.toString()
            dislikeCntText.text = disLikeCnt.toString()
            btn_like.setImageResource(R.drawable.ic_thumb_up)
            btn_dislike.setImageResource(R.drawable.ic_thumb_down_selected)

        }


        btn_all_Comment.setOnClickListener{
            Toast.makeText(this,"모두보기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()

        }

        btn_writeComment.setOnClickListener{
            Toast.makeText(this,"작성하기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()
        }

    }



}
