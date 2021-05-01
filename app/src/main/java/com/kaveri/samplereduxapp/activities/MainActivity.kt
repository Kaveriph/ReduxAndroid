package com.kaveri.samplereduxapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kaveri.samplereduxapp.databinding.ActivityMainBinding
import com.kaveri.samplereduxapp.interfaces.TouchCountStateReciver
import com.kaveri.samplereduxapp.redux.action.IncrementCounter
import com.kaveri.samplereduxapp.redux.handler.TouchCountHandler
import com.kaveri.samplereduxapp.redux.reducer.appReducer
import com.kaveri.samplereduxapp.redux.state.AppState
import com.kaveri.samplereduxapp.redux.store.appStore
import org.rekotlin.Store

class MainActivity : AppCompatActivity() , TouchCountStateReciver {

    private val touchCountHandler = TouchCountHandler(this)
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        appStore = Store(::appReducer, null)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.touchMeBtn.setOnClickListener {
            appStore.dispatch(IncrementCounter())
        }
    }

    override fun onStart() {
        super.onStart()
        touchCountHandler.onStart()
    }

    override fun onStop() {
        super.onStop()
        touchCountHandler.onStop()
    }

    override fun onTouchCountReceived(count: Int) {
        binding.touchCountTv.text = "Touch Count $count"
    }
}