package com.hcyacg.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueName
import net.mamoe.mirai.console.data.value

object Setting : AutoSavePluginConfig("Setting") {

    @ValueName("ups")
    val ups: List<String> by value(listOf("549739", "6750667"))

    @ValueName("groups")
    val groups: List<Long> by value(listOf(123456))

    @ValueName("enable")
    val enable: Enable by value()
}