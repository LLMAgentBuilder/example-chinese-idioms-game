package io.github.llmagentbuilder.example.chineseidiomsgame.tool

import io.github.llmagentbuilder.core.tool.AgentTool
import io.github.llmagentbuilder.core.tool.AgentToolFactory
import org.apache.commons.lang3.StringUtils

const val chineseIdiomsCheckToolId = "checkChineseIdiom"

class ChineseIdiomsCheckTool :
    AgentTool<IdiomCheckRequest, IdiomCheckResponse> {
    override fun id(): String {
        return chineseIdiomsCheckToolId
    }

    override fun name(): String {
        return chineseIdiomsCheckToolId
    }

    override fun description(): String {
        return "check if a chinese idiom is valid with last chinese idiom"
    }

    override fun apply(request: IdiomCheckRequest): IdiomCheckResponse {
        if (StringUtils.isNotEmpty(request.lastIdiom) && request.lastIdiom.last() != request.currentIdiom.first()) {
            return IdiomCheckResponse(false)
        }
        return IdiomCheckResponse(Idioms.isIdiom(request.currentIdiom))
    }
}

class ChineseIdiomsCheckToolFactory : AgentToolFactory<ChineseIdiomsCheckTool> {
    override fun create(): ChineseIdiomsCheckTool {
        return ChineseIdiomsCheckTool()
    }
}

const val getChineseIdiomsStartWithToolId = "getChineseIdiomsStartWith"

class GetChineseIdiomsStartWithTool :
    AgentTool<GetChineseIdiomsStartWithRequest, GetChineseIdiomsStartWithResponse> {
    override fun id(): String {
        return getChineseIdiomsStartWithToolId
    }

    override fun name(): String {
        return getChineseIdiomsStartWithToolId
    }

    override fun description(): String {
        return "get a list of Chinese idioms start with the given word"
    }

    override fun apply(request: GetChineseIdiomsStartWithRequest): GetChineseIdiomsStartWithResponse {
        return GetChineseIdiomsStartWithResponse(
            Idioms.idiomsBeginWith(
                request.word,
                request.limit
            )
        )
    }
}

class GetChineseIdiomsStartWithToolFactory :
    AgentToolFactory<GetChineseIdiomsStartWithTool> {
    override fun create(): GetChineseIdiomsStartWithTool {
        return GetChineseIdiomsStartWithTool()
    }
}