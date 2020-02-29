package com.kptech.cinema

import android.content.res.Configuration
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

        btn_like.setOnClickListener {

            if(likeBtnStatus == 1)
                return@setOnClickListener
            likeBtnStatus = 1
            likeCnt++
            if(disLikeCnt>0)
                disLikeCnt--
            btn_like.text = "  "+likeCnt.toString()
            btn_dislike.text = "  "+disLikeCnt.toString()
            updatePreferences()
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
            updatePreferences()
        }


        btn_all_Comment.setOnClickListener{
            Toast.makeText(this,"모두보기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()

        }

        btn_writeComment.setOnClickListener{
            Toast.makeText(this,"작성하기 버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        btn_like.text = MySharedPref.LoadPrefLikeCntText(applicationContext)
        btn_dislike.text = MySharedPref.LoadPrefDislikeCntText(applicationContext)
        likeBtnStatus = MySharedPref.LoadPrefLikeBtnStatus(applicationContext)

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
                Toast.makeText(this, "세로모드", Toast.LENGTH_SHORT).show();
         }

         if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                Toast.makeText(this, "가로모드", Toast.LENGTH_SHORT).show();
         }

    }

    fun updatePreferences()
    {
        MySharedPref.SavePrefLikeCntText(applicationContext, btn_like.text as String?)
        MySharedPref.SavePrefDislikeCntText(applicationContext, btn_dislike.text as String?)
        MySharedPref.SavePrefLikeBtnStatus(applicationContext, likeBtnStatus)
        Log.d("MainActivity","like cnt :"+btn_like.text +"  dislike cnt :" + btn_dislike.text )
    }

}
