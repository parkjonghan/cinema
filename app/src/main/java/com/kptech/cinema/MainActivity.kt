package com.kptech.cinema

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var likeCnt :Int =50
    private  var disLikeCnt : Int  =50
    private  var likeBtnStatus : Int = -1; // -1은 아무것도 선택이되지 않은 상태, 0 : 선택되지 않은 상태 , 1: 선택된 상태



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        comment_list.adapter = MainAdapter()
        comment_list.layoutManager = LinearLayoutManager(this)

        Log.d("MainActivity","MainActivity Create")
        btn_like.text = App.prefs.myLikeCntText
        btn_dislike.text = App.prefs.myDislikeCntText
        likeBtnStatus = App.prefs.myLikeBntStatus

        btn_like.setOnClickListener {

            if(likeBtnStatus == 1)
                return@setOnClickListener
            likeBtnStatus = 1
            likeCnt++
            if(disLikeCnt>0)
                disLikeCnt--
            btn_like.text = "  "+likeCnt.toString()
            btn_dislike.text = "  "+disLikeCnt.toString()
            UpdatePreferences()
        }

        btn_dislike.setOnClickListener {

            if(likeBtnStatus == 0)
                return@setOnClickListener
            likeBtnStatus = 0
            disLikeCnt++
            if(likeCnt>0)
                likeCnt--
            btn_like.text = "  "+likeCnt.toString()
            btn_dislike.text = "  "+disLikeCnt.toString()
            UpdatePreferences()
        }


        btn_all_Comment.setOnClickListener{
            Toast.makeText(this,"모두보기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()

        }

        btn_writeComment.setOnClickListener{
            Toast.makeText(this,"작성하기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()
        }

    }

    fun UpdatePreferences()
    {
        App.prefs.myLikeCntText = btn_like.text as String?
        App.prefs.myDislikeCntText = btn_dislike.text as String?
        App.prefs.myLikeBntStatus = likeBtnStatus
        Log.d("MainActivity","like cnt :"+btn_like.text +"  dislike cnt :" + btn_dislike.text )
    }

}
