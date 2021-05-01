package com.kaveri.samplereduxapp.redux.reducer

import com.kaveri.samplereduxapp.redux.action.IncrementCounter
import com.kaveri.samplereduxapp.redux.state.TouchCountState
import org.rekotlin.Action
import org.rekotlin.StateType

fun touchCountReducer(touchCountState: TouchCountState?, action: Action): TouchCountState {
    var state = touchCountState ?: TouchCountState()
    when(action) {
        is IncrementCounter -> {
            state.touchCount = state.touchCount + 1
        }
    }
    return state
}