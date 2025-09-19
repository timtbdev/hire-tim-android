package com.hire.tim.app

import android.app.Application
import cat.ereza.customactivityoncrash.config.CaocConfig
import dagger.hilt.android.HiltAndroidApp
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.disk.DiskCache
import coil.util.DebugLogger


@HiltAndroidApp
class HireTimApp: Application(), ImageLoaderFactory {
    override fun onCreate() {
        super.onCreate()
        CaocConfig.Builder.create().restartActivity(MainActivity::class.java).apply()
    }
    override fun newImageLoader(): ImageLoader {
        val coilOkhttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .build()

        return ImageLoader(this).newBuilder()
            .memoryCachePolicy(CachePolicy.ENABLED)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.25)
                    .strongReferencesEnabled(true)
                    .build()
            }
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                DiskCache.Builder()
                    .maxSizePercent(0.05)
                    .directory(cacheDir)
                    .build()
            }
            .okHttpClient(coilOkhttpClient)
            .logger(DebugLogger())
            .build()
    }
}