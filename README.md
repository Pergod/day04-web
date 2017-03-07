1.使用Range头实现断点续传    connection.setRequestProperty("Range", "bytes=5-");
2.设置输出格式               resp
3.设置以下载方式打开文件      resp
4.数据压缩                   resp
5.设置数据刷新时间，单位为秒   resp
6.实现SingleThreadModel接口可以实现线程安全 @Deprecated
