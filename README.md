#Logger日志框架
一款漂亮和实用的Android日志框架一直是Android程序员喜欢的工具.
本文基于Logger日志框架,改写的poponLogger日志框架,有以下特点:

 - 支持map,json,xml,以及数组的打印;
 - 可以把日志缓存到文件中;
 - 可以控制日志的显示和缓存级别;

-------------------
[我的博客](http://blog.csdn.net/zybieku/article/details/53467341)  
[poponLogger.jar包下载](http://download.csdn.net/detail/zybieku/9702363)  
-------------------
### 使用详解###
 **1.无特殊需求,直接可以使用,默认配置,无需手动初始化操作:**
```
 Logger.e( "onCreate: 智慧与掉渣天并存");
 Logger.t(TAG).e("onCreate: 英雄与侠义的化身");
```
>打印效果如下(这里只举例log.e级别的日志,map之类的也支持):
>
![这里写图片描述](http://img.blog.csdn.net/20161205182002067)

-------------------

 **2.自定义初始化操作 **
 >  初始化配置,在Application中初始化即可,根据不同的情况配置
```
 Logger.init("logger") // 默认全局的TAG
     //.hideThreadInfo() //隐藏线程信息
       .methodCount(1)  //定位的方法数及代码行数
       .logLevel(LogLevel.INFO)  // 默认是打印所有(FULL)                                                      
       .methodOffset(2);     //定位的偏移量
     
```
>效果如下:
>
![这里写图片描述](http://img.blog.csdn.net/20161205185245145)


效果是不是很不错,是不是想自己尝试一下捏;

别着急,我们还需要注意几点:

 > - xml,json,map信息都是属于Info级别的日志,我们需要在init中吧level设置在info或者以下,否则将不会在控制台打印.
 

```
.logLevel(LogLevel.INFO)
```


----------
 **2.文件缓存操作 **
>可能有些情况,我们需要对一些日志进行文件缓存操作,
>那我们可以在上述init中配置后面缓存路径.

```
   Logger.init("logger") // 默认为的TAG
               //  .hideThreadInfo() //异常线程信息
                .methodCount(1)  //定位的方法数及代码行数
                .logLevel(LogLevel.INFO)  // 默认是打印所有
                .methodOffset(1)     //定位的偏移量
                .cacheFile(CachePath.LOG);//CachePath.LOG为日志路径
```
>另外记得在Manifest文件中添加权限,并处理.
>这样就可以对打印的日志进行缓存了,文件将会存到我们设定的路径下;

注意  
>文件缓存默认是对控制台打印的日志进行缓存的;
>如果我们只对指定的日志进行缓存的话,我们需要在上述init中配置logAdapter,然后重写LogAdapter即可;
配置如下:

```
        Logger.init("logger") // 默认为的TAG
               //  .hideThreadInfo() //异常线程信息
              .methodCount(1)  //定位的方法数及代码行数
              .logLevel(LogLevel.INFO)  // 默认是打印所有(FULL),
              .methodOffset(1)   //定位的偏移量      
              .cacheFile(CachePath.LOG)//CachePath.LOG为日志路径
              .logAdapter(new CacheAdapter());//重写logAdapter.
```
>下面是重写的logAdapter
```
**
 * desc:CacheAdapter
 * Author: znq
 * Date: 2016-12-05 19:17
 */
public class CacheAdapter implements LogAdapter {
    @Override
    public void d(String tag, String message, String path) {
        Log.d(tag, message);
    }

    @Override
    public void e(String tag, String message, String path) {
        Log.e(tag, message);
        if (!TextUtils.isEmpty(path)) {
            RollingFileUtils.getInstance().saveCrashInfo2File(message, path);
        }
    }

    @Override
    public void eCache(String tag, String message, String path) {
        Log.e(tag, message);
       
    }

    @Override
    public void w(String tag, String message, String path) {
        Log.w(tag, message);
    }

    @Override
    public void i(String tag, String message, String path) {
        Log.i(tag, message);
    }

```

>我们发现不同级别日志执行的方法,最后调用的还是系统的log日志;
>我们完全可以在这些方法中自定义<包括使用自己的日志打印,和文件缓存>
>也可以在需要缓存的日志级别下加入以下代码进行文件缓存:
```
 if (!TextUtils.isEmpty(path)) {                  RollingFileUtils.getInstance() .saveCrashInfo2File(message, path);
 }
```
最后,我们就可以进入我们制定的文件路径找到我们保存的日志文件了


