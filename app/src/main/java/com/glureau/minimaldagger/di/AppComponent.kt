package com.glureau.minimaldagger.di

import com.glureau.clickcounter.di.ClickCounterInjector
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent : ClickCounterInjector {
}
