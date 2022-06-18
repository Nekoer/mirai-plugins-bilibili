package com.hcyacg.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.ValueName
import net.mamoe.mirai.console.data.value

object Setting : AutoSavePluginConfig("Setting") {

    @ValueName("ups")
    @ValueDescription("B站UP主")
    val ups: MutableList<String> by value(mutableListOf("549739", "6750667"))

    @ValueName("groups")
    @ValueDescription("主动推送的群")
    val groups: List<Long> by value(listOf(123456))

    @ValueDescription("推送种类开关")
    @ValueName("enable")
    val enable: Enable by value()

    @ValueDescription("代理配置")
    @ValueName("proxy")
    val proxy: Proxy by value()

    @ValueDescription("是否忽略log")
    @ValueName("ignoreLog")
    val ignoreLog: Boolean by value(true)
}