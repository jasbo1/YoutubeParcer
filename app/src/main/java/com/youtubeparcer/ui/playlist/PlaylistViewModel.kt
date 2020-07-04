package com.youtubeparcer.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.youtubeparcer.model.Playlist
import com.youtubeparcer.network.RetrofitClient
import com.youtubeparcer.network.YoutubeApi
import retrofit2.Call

import retrofit2.Response
import javax.security.auth.callback.Callback

class PlaylistViewModel : ViewModel() {
    fun fetchPlayList(): LiveData<Playlist> {
        return fetchYoutubePlaylist()

    }

    val channelId = "UC_IfiZu3VkesO3L58L9WPhA"
    val apiKey = "AIzaSyCWK-EoCHecYMMFAvl-DI5iegR9s1WW20Y"
    val part = "snippet,contentDetails"
    val maxResult = "50"

    private  var apiServise: YoutubeApi? = null
    fun fetchYoutubePlaylist(): LiveData<Playlist> {
        apiServise = RetrofitClient.create()
        val data = MutableLiveData<Playlist>()
        apiServise?.fetchAllPlaylists(part, apiKey, channelId, maxResult)?.enqueue(object :
             retrofit2.Callback<Playlist> {
            override fun onFailure(call: Call<Playlist>, t: Throwable) {
            }

            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                data.value = response.body()
            }

        })
        return data

    }

}