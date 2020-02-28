package com.kptech.cinema

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var likeCnt :Int =50
    private  var disLikeCnt : Int  =50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comment_list.adapter = MainAdapter()
        comment_list.layoutManager = LinearLayoutManager(this)


        btn_like.setOnClickListener {

            if(btn_like.isChecked)
                return@setOnClickListener
            likeCnt++
            if(disLikeCnt>0)
                disLikeCnt--
            btn_like.text = "  "+likeCnt.toString()
            btn_dislike.text = "  "+disLikeCnt.toString()
        }

        btn_dislike.setOnClickListener {

            if(btn_dislike.isChecked)
                return@setOnClickListener
            disLikeCnt++
            if(likeCnt>0)
                likeCnt--
            btn_like.text = "  "+likeCnt.toString()
            btn_dislike.text = "  "+disLikeCnt.toString()
        }


        btn_all_Comment.setOnClickListener{
            Toast.makeText(this,"모두보기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()

        }

        btn_writeComment.setOnClickListener{
            Toast.makeText(this,"작성하기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()
        }

    }



}
