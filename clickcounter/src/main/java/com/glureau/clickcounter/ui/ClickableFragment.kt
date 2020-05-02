package com.glureau.clickcounter.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.glureau.clickcounter.R
import com.glureau.clickcounter.di.clickCounterInjector
import com.glureau.clickcounter.features.ClickCounterService
import javax.inject.Inject

class ClickableFragment : Fragment(R.layout.fragment_clickable) {

    @Inject
    lateinit var clickCounterService: ClickCounterService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clickCounterInjector().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // When the view is destroyed, the inner class (from this lambda) will be GCed.
        view.setOnClickListener { clickCounterService.incrementCounter() }
    }
}