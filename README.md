# <img src="src/docs/asciidoc/images/spring-framework.png" width="80" height="80"> Spring Framework 


## Spring Source Build -- 本项目 build 指引:
前置安装：
1. jdk 1.8+
2. gradle
3. IDEA 

## Steps -- 步骤：

1. Clone下来之后需要预先编译：
  ```shell script
  ./gradlew :spring-oxm:compileTestJava
  ```
  该步骤会启动 Gradle 编译，spring-framework-5.2.8 默认用的是 gradle-5.6.4, 如果你的电脑没有会自动下载，由于 Gradle 下载较慢，你可以实现下载好压缩包，当启动上述命令之后，停止该命令，会在 .gradle/wrapper/dists/gradle-5.6.4-bin/下新建一个哈希命令的文件夹，将你的 gradle 压缩包放入里面再执行上述命令即可。


2. 导入到 IDEA 会自动启动 gradle build(如果没有请手动执行)

3. 右键 spring-aspects 模块将其 `unload`(因为用了字节码生成类,在 IDEA 里面会有很多报错)


>> 详细 [参见文件 import-into-idea](./import-into-idea.md)


## Documentation

The Spring Framework maintains reference documentation ([published](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/) and [source](src/docs/asciidoc)), Github [wiki pages](https://github.com/spring-projects/spring-framework/wiki), and an
[API reference](https://docs.spring.io/spring-framework/docs/current/javadoc-api/). There are also [guides and tutorials](https://spring.io/guides) across Spring projects.

## Build from Source

See the [Build from Source](https://github.com/spring-projects/spring-framework/wiki/Build-from-Source) Wiki page and the [CONTRIBUTING.md](CONTRIBUTING.md) file.
