package com.black.lovooapp.di

import com.black.lovooapp.BuildConfig
import com.black.lovooapp.common.BasicAuthInterceptor
import com.black.lovooapp.domain.AppRepository
import com.black.lovooapp.domain.IAppRepository
import com.black.lovooapp.domain.data.local.ILocalSource
import com.black.lovooapp.domain.data.local.LocalDataSource
import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.domain.data.remote.NetworkDataSourceImpl
import com.black.lovooapp.domain.db.AppDatabase
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by farhanahmad on 14/5/20.
 */

private val utilModule = module {
    single {
        OkHttpClient().newBuilder()
                .addInterceptor(BasicAuthInterceptor(BuildConfig.USERNAME, BuildConfig.PASSWORD))
                .build()
    }

    single {
        AppDatabase.getDB(androidContext()).getAppDao()
    }
}
private val dataModule = module {
    single<INetworkSource> { NetworkDataSourceImpl(get()) }
    single<ILocalSource> { LocalDataSource(get()) }
    single<IAppRepository> { AppRepository(get(), get()) }
}

val moduleList = listOf(utilModule, dataModule)
