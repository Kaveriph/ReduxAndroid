package com.kaveri.samplereduxapp.redux.reducer

import com.kaveri.samplereduxapp.redux.state.AppState
import org.rekotlin.Action

fun appReducer(action: Action, appState: AppState?) : AppState {
    return AppState(touchCountReducer(appState?.touchCountState, action))
}