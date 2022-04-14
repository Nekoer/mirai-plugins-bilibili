package com.hcyacg.utils

import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


object FileUtil {
    /**
     * @param fileUrl 资源地址
     * @Description: 网络资源转file, 用完以后必须删除该临时文件
     * @return: 返回值
     */
    fun urlToFile(fileUrl: String): File? {
        val path = System.getProperty("user.dir")
        val upload = File(path, "tmp")
        if (!upload.exists()) {
            upload.mkdirs()
        }
        return urlToFile(fileUrl, upload)
    }

    /**
     * @param fileUrl 资源地址
     * @param upload  临时文件路径
     * @Description: 网络资源转file, 用完以后必须删除该临时文件
     * @return: 返回值
     */
    fun urlToFile(fileUrl: String, upload: File): File? {
        val fileName = fileUrl.substring(fileUrl.lastIndexOf("/"))
        var downloadFile: FileOutputStream? = null
        var openStream: InputStream? = null
        var savedFile: File? = null
        try {
            savedFile = File(upload.absolutePath + fileName)
            val url = URL(fileUrl)
            val connection = url.openConnection() as HttpURLConnection
            openStream = connection.inputStream
            var index: Int
            val bytes = ByteArray(1024)
            downloadFile = FileOutputStream(savedFile)
            while (openStream.read(bytes).also { index = it } != -1) {
                downloadFile.write(bytes, 0, index)
                downloadFile.flush()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            try {
                openStream?.close()
                downloadFile?.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return savedFile
    }

}