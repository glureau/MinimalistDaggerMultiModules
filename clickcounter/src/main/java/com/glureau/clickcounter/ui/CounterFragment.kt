package com.glureau.clickcounter.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.glureau.clickcounter.R
import com.glureau.clickcounter.di.clickCounterInjector
import com.glureau.clickcounter.features.ClickCounterService
import javax.inject.Inject

class CounterFragment : Fragment(R.layout.fragment_counter) {
    @Inject
    lateinit var clickCounterService: ClickCounterService

    private var clickListener: ClickCounterService.ClickCountListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clickCounterInjector().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.counter_textview).text = "no clicks"
        clickListener = object : ClickCounterService.ClickCountListener {
            override fun onClickCountChanged(clickCount: Int) {
                view.findViewById<TextView>(R.id.counter_textview).text = "$clickCount clicks"
            }
        }
        clickCounterService.addListener(clickListener!!)
    }

    override fun onDestroyView() {
        // Forgot to remove this listener and you leak the CounterFragment view!
        clickCounterService.removeListener(clickListener!!)
        super.onDestroyView()
    }
}