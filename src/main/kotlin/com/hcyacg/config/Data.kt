package com.hcyacg.config

import net.mamoe.mirai.console.data.AutoSavePluginData
import net.mamoe.mirai.console.data.value

object Data : AutoSavePluginData("Data") {
    var live: MutableMap<String, Int> by value()
    var dynamic: MutableMap<String, MutableMap<String, String>> by value()
}