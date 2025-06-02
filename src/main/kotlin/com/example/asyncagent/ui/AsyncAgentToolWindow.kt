package com.example.asyncagent.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.content.ContentFactory
import javax.swing.JLabel
import javax.swing.JPanel

class AsyncAgentToolWindow : ToolWindowFactory {
    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        // Create a simple panel for now
        val panel = JPanel()
        panel.add(JLabel("Async Coding Agent Tool Window"))

        val contentFactory = ContentFactory.getInstance()
        val content = contentFactory.createContent(panel, "", false)
        toolWindow.contentManager.addContent(content)

        // TODO: Implement Chat interface
        // TODO: Implement Task queue viewer
        // TODO: Implement Settings panel
        // TODO: Implement History viewer
    }
}
