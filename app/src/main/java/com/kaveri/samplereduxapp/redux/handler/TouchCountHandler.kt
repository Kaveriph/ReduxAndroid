package com.kaveri.samplereduxapp.redux.handler

import com.kaveri.samplereduxapp.interfaces.TouchCountStateReciver
import com.kaveri.samplereduxapp.redux.reducer.touchCountReducer
import com.kaveri.samplereduxapp.redux.state.TouchCountState
import com.kaveri.samplereduxapp.redux.store.appStore
import org.rekotlin.StoreSubscriber
import org.rekotlin.Subscription

class TouchCountHandler( val touchCountStateReceiver: TouchCountStateReciver) : StoreSubscriber<TouchCountState?> {

    override fun newState(state: TouchCountState?) {
        touchCountStateReceiver.onTouchCountReceived(state?.touchCount ?: 0)
    }

    fun onStart() {
        appStore.subscribe(this) {
            it.select {
                it.touchCountState
            }
        }
    }

    fun onStop() {
        appStore.unsubscribe(this)
    }

}