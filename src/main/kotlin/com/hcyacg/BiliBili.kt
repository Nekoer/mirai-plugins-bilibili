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
import net.mamoe.mirai.message.data.AtAll
import net.mamoe.mirai.utils.info


object BiliBili : KotlinPlugin(
    JvmPluginDescription(
        id = "com.hcyacg.bilibili",
        name = "B站推送插件",
        version = "1.1.4-dev-2",
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

        logger.info("检查到B站 文字动态：${Setting.enable.dynamic} 转发动态：${Setting.enable.forward} 直播监控：${Setting.enable.live} 专栏动态：${Setting.enable.article} 视频动态：${Setting.enable.video}")
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