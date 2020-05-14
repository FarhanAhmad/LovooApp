package com.black.lovooapp.domain.data.remote

import com.black.lovooapp.common.AppConstants
import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.domain.model.LovooRoomDTO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Credentials
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * Created by farhanahmad on 14/5/20.
 */
class NetworkDataSourceImpl(private val httpClient: OkHttpClient) :
        INetworkSource {

    override suspend fun getRooms(): List<LovooRoomDTO> {

        val creds = Credentials.basic("lovooTrialUser", "lovoo#2018")

        val request = Request.Builder()
                .url(AppConstants.URL)
                .header("Authorization", creds)
                .build()

        val response = httpClient.newCall(request).execute()

        if (response.isSuccessful) {
            val responseStr = response.body?.string()

            val type = object : TypeToken<ArrayList<LovooRoomDTO>>() {}.type
            return Gson().fromJson(responseStr, type)
        } else {
            //TODO: Error handling
        }


        return arrayListOf()
    }

}