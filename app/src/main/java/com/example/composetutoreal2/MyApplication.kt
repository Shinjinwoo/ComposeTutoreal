package com.example.composetutoreal2

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

class MyApplication : Application() {
    override fun onCreate() {
        initLoggerPlugin()

        super.onCreate()
    }



    private fun initLoggerPlugin() {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false) // (Optional) Whether to show thread info or not. Default true
            .methodCount(2)        // (Optional) How many method line to show. Default 2
            .methodOffset(5)       // (Optional) Hides internal method calls up to offset. Default 5
            .tag("PRETTY_LOGGER")      // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }
}