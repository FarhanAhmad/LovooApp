package com.black.lovooapp.di

import android.app.Application
import android.content.Context
import com.black.lovooapp.domain.data.remote.INetworkSource
import com.black.lovooapp.domain.data.remote.NetworkDataSourceImpl
import okhttp3.OkHttpClient
import org.junit.Test
import org.koin.dsl.module.module
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.get
import org.koin.test.KoinTest
import org.koin.test.checkModules
import org.mockito.Mockito

/**
 * Created by farhanahmad on 14/5/20.
 */
class DITest : KoinTest {

    @Test
    fun testDIGraph() {
        val mockApplication = module(override = true) {
            single { Mockito.mock(Application::class.java) }
            single { Mockito.mock(Context::class.java) }
        }

        val modules = moduleList + mockApplication

        checkModules(modules)
    }

    @Test
    fun testOkHttpClientObj(){
        val module = module {
            single { OkHttpClient() }
        }

        startKoin(listOf(module))

        val httpClient: OkHttpClient = get()

        assert(httpClient != null)
    }

    @Test
    fun testNetworkDataSourceObj() {

        val module = module {
            single { OkHttpClient() }
            single<INetworkSource> { NetworkDataSourceImpl(get()) }
        }

        startKoin(listOf(module))

        val networkSource: INetworkSource = get()

        assert(networkSource != null)

    }
}