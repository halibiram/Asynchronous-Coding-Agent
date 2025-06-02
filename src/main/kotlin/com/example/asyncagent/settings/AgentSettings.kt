package com.example.asyncagent.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "com.example.asyncagent.settings.AgentSettings",
    storages = [Storage("AsyncCodingAgentSettings.xml")]
)
class AgentSettings : PersistentStateComponent<AgentSettings.State> {

    data class State(
        var geminiApiKey: String = "",
        var autoSuggestEnabled: Boolean = true,
        var contextDepth: Int = 5,
        var cacheEnabled: Boolean = true
    )

    private var myState = State()

    override fun getState(): State {
        return myState
    }

    override fun loadState(state: State) {
        XmlSerializerUtil.copyBean(state, myState)
    }

    companion object {
        val instance: AgentSettings
            get() = ApplicationManager.getApplication().getService(AgentSettings::class.java)
    }
}
