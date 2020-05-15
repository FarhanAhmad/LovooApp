package com.black.lovooapp.di

import com.black.lovooapp.domain.AppRepository
import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.domain.data.remote.NetworkDataSourceImpl
import okhttp3.OkHttpClient
import org.koin.dsl.module.module

/**
 * Created by farhanahmad on 14/5/20.
 */

private val utilModule = module {
    single { OkHttpClient() }
}
private val dataModule = module {
    single<INetworkSource> { NetworkDataSourceImpl(get()) }
    single<IAppRepository> { AppRepository(get()) }
}

val moduleList = listOf(utilModule, dataModule)
