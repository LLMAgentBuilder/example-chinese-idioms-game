package io.github.llmagentbuilder.example.chineseidiomsgame

import io.github.llmagentbuilder.core.planner.PatchLastUserMessageChatHistoryCustomizer
import org.springframework.ai.chat.messages.AssistantMessage

class IdiomsChatHistoryCustomizer :
    PatchLastUserMessageChatHistoryCustomizer({ messages, content ->
        val prefix = "Final Answer:"
        val lastIdiom = messages.lastOrNull {
            it is AssistantMessage
        }?.content?.let {
            it.lines().firstOrNull { line ->
                line.startsWith(prefix)
            }?.removePrefix(prefix)
        }
        lastIdiom?.let { idiom ->
            """
            $content
                                
            上一个成语：$idiom
            """.trimIndent()
        } ?: content

    })
