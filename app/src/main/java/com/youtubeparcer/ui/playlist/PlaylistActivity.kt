package com.youtubeparcer.ui.playlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.youtubeparcer.R

class PlaylistActivity : AppCompatActivity() {
    private var viewModel: PlaylistViewModel? = null
    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
     viewModel = ViewModelProviders.of(this).get(PlaylistViewModel::class.java)
        setupToSubscribe()
    }
    private fun setupToSubscribe(){
        viewModel?.fetchPlayList()?.observe(this, Observer {
          Toast.makeText(this,it.toString(),Toast.LENGTH_LONG).show()
        })
    }
}
