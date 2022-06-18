package com.hcyacg.config

import net.mamoe.mirai.console.data.AutoSavePluginConfig
import net.mamoe.mirai.console.data.ValueDescription
import net.mamoe.mirai.console.data.ValueName
import net.mamoe.mirai.console.data.value

object Setting : AutoSavePluginConfig("Setting") {

    @ValueName("ups")
    @ValueDescription("BվUP��")
    val ups: MutableList<String> by value(mutableListOf("549739", "6750667"))

    @ValueName("groups")
    @ValueDescription("�������͵�Ⱥ")
    val groups: List<Long> by value(listOf(123456))

    @ValueDescription("�������࿪��")
    @ValueName("enable")
    val enable: Enable by value()

    @ValueDescription("��������")
    @ValueName("proxy")
    val proxy: Proxy by value()

    @ValueDescription("�Ƿ����log")
    @ValueName("ignoreLog")
    val ignoreLog: Boolean by value(true)
}