# mirai-plugins-bilibili

BiliBili推送

- 直播通知
- 用户专栏、视频、动态、转发等主动推送

唯一命令：/rss list 查看订阅的UP

~~请复制的时候去掉#以及后面的字~~ 这就不要我说了吧（

```
ups:  #B站UP主
  - 11783021
  - 6750667
groups:  #主动推送的群
  - 77708393
  - 960879198
enable:  #推送开关
  article: true #专栏
  forward: true #转发
  live: true #直播
  video: true #视频
  dynamic: true #普通动态
```
