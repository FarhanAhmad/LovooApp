package com.black.lovooapp.domain.data.remote

import com.black.lovooapp.common.AppConstants
import com.black.lovooapp.common.Logger
import com.black.lovooapp.domain.model.LovooRoomDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by farhanahmad on 14/5/20.
 */
class NetworkDataSourceImpl(private val httpClient: OkHttpClient) :
        INetworkSource {

    companion object {
        val TAG = "NetworkDataSource"
    }

    override suspend fun getRooms(): List<LovooRoomDTO> {

        val request = Request.Builder()
                .url(AppConstants.URL)
                .build()

        val response = httpClient.newCall(request).execute()
        Logger.e(TAG, "ResponseCode:${response.code}")
        if (response.isSuccessful) {
            val responseStr = response.body?.string()

            val type = object : TypeToken<ArrayList<LovooRoomDTO>>() {}.type
            return Gson().fromJson(responseStr, type)
        } else {
            Logger.e(TAG, response.message)
            //TODO: Error handling
        }


        return arrayListOf()
    }

}