package com.hcyacg


import com.hcyacg.bilibili.BiliBiliCenter
import com.hcyacg.config.Data
import com.hcyacg.config.Setting
import net.mamoe.mirai.console.extension.PluginComponentStorage
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.console.plugin.name
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.event.subscribeGroupMessages
import net.mamoe.mirai.utils.info


object BiliBili : KotlinPlugin(
    JvmPluginDescription(
        id = "com.hcyacg.bilibili",
        name = "B站推送插件",
        version = "1.0",
    ) {
        author("Nekoer")
        info("""B站推送插件""")
    }
) {

    override fun PluginComponentStorage.onLoad() {
        Data.save()
    }


    override fun onEnable() {
        Setting.reload()

        Data.save()
        Data.reload()

        BiliBiliCenter.load()

        logger.info { "$name 已加载" }
        globalEventChannel().subscribeGroupMessages {

            content { message.contentToString().contentEquals("/rss list") } quoteReply {
                BiliBiliCenter.statistical(
                    this
                )
            }
        }


    }
}