package com.glureau.minimaldagger

import android.app.Application
import com.glureau.clickcounter.di.ClickCounterInjectorProvider
import com.glureau.minimaldagger.di.AppComponent
import com.glureau.minimaldagger.di.DaggerAppComponent

class MainApplication : Application(), ClickCounterInjectorProvider {
    private val appComponent: AppComponent = DaggerAppComponent.create()
    override fun clickCounterInjector() = appComponent
}