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
import okhttp3.Headers
import java.util.regex.Pattern


object BiliBili : KotlinPlugin(
    JvmPluginDescription(
        id = "com.hcyacg.bilibili",
        name = "B站推送插件",
        version = "1.1.5-fix",
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


            val upName = Pattern.compile("(?i)^(up添加).+\$")
            val upNum = Pattern.compile("(?i)^(up添加)([0-9]*[1-9][0-9]*)\$")
            //https://api.bilibili.com/x/web-interface/search/type?page=1&page_size=36&keyword=%E8%8A%B1%E8%88%9E&search_type=bili_user&dynamic_offset=0
            content { upName.matcher(message.contentToString()).find() } reply {
                BiliBiliCenter.addUp(this)
            }

        }


    }

    override fun onDisable() {
        Setting.save()
        Data.save()
    }
}