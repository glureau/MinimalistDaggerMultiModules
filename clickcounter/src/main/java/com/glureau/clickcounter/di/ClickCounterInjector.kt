package com.glureau.clickcounter.di

import androidx.fragment.app.Fragment
import com.glureau.clickcounter.ui.ClickableFragment
import com.glureau.clickcounter.ui.CounterFragment

interface ClickCounterInjectorProvider { // Will be implemented by the Application itself
    fun clickCounterInjector(): ClickCounterInjector
}

fun Fragment.clickCounterInjector() =
    (this.activity?.application as ClickCounterInjectorProvider?)?.clickCounterInjector()
        ?: error("Cannot inject without a proper reference to the application")

interface ClickCounterInjector {
    fun inject(f: ClickableFragment)
    fun inject(f: CounterFragment)
}
