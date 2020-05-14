package com.black.lovooapp.di

import com.black.lovooapp.domain.INetworkSource
import com.black.lovooapp.domain.NetworkDataSourceImpl
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
}

val moduleList = listOf(utilModule, dataModule)
