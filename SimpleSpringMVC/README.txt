1. IOException parsing XML document from ServletContext resource [/applicationContext.xml]; nested exception is java.io.FileNotFoundException: Could not open ServletContext resource [/applicationContext.xml]
   web.xml 中配置 <context-param>，
   applicationContext 的路径 spring 默认会到 WEB-INF/ 下，
   手动修改为 resources 下需要修改 web.xml 中的配置为 classpath:applicationContext.xml。

2. SpringMVC 工作流程
   用户发送请求
   请求交由核心控制器处理
   核心控制器找到映射器，映射器看看请求路径是什么
   核心控制器再找到适配器，看看有哪些类实现了Controller接口或者对应的bean对象
   将带过来的数据进行转换，格式化等等操作
   找到我们的控制器Action，处理完业务之后返回SimpleUrlHandlerMapping一个ModelAndView对象
   最后通过视图解析器来对ModelAndView进行解析
   跳转到对应的JSP/html页面

3. 映射器
   只要是.action 为后缀的请求都是会经过SpringMVC的核心Servlet
   org.springframework.web.servlet.handler.SimpleUrlHandlerMapping





















