1. IOException parsing XML document from ServletContext resource [/applicationContext.xml]; nested exception is java.io.FileNotFoundException: Could not open ServletContext resource [/applicationContext.xml]
   web.xml 中配置 <context-param>，
   applicationContext 的路径 spring 默认会到 WEB-INF/ 下，
   手动修改为 resources 下需要修改 web.xml 中的配置为 classpath:applicationContext.xml。










