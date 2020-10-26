1. applicationContext 中配置的 <bean class="com.noobyang.aop.AOP" /> 和
   <context:component-scan base-package="com.noobyang" /> 自动扫描出来的 @Component 和 @Autowired 等注解效果相同

2. <bean id="aop4" class="com.noobyang.aop.AOP" /> 可以声明多个对象出来

3. execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
符号讲解：
    ?号代表0或1，可以不写
    “*”号代表任意类型，0或多
    方法参数为..表示为可变参数

参数讲解：
    modifiers-pattern?【修饰的类型，可以不写】
    ret-type-pattern【方法返回值类型，必写】
    declaring-type-pattern?【方法声明的类型，可以不写】
    name-pattern(param-pattern)【要匹配的名称，括号里面是方法的参数】
    throws-pattern?【方法抛出的异常类型，可以不写】

example:
        <!-- 【拦截所有public方法】 -->
        <!--<aop:pointcut expression="execution(public * *(..))" id="pt"/>-->

        <!-- 【拦截所有save开头的方法Log4j 】 -->
        <!--<aop:pointcut expression="execution(* save*(..))" id="pt"/>-->

        <!-- 【拦截指定类的指定方法, 拦截时候一定要定位到方法】 -->
        <!--<aop:pointcut expression="execution(public * cn.itcast.g_pointcut.OrderDao.save(..))" id="pt"/>-->

        <!-- 【拦截指定类的所有方法】 -->
        <!--<aop:pointcut expression="execution(* cn.itcast.g_pointcut.UserDao.*(..))" id="pt"/>-->

        <!-- 【拦截指定包，以及其自包下所有类的所有方法】 -->
        <!--<aop:pointcut expression="execution(* cn..*.*(..))" id="pt"/>-->

        <!-- 【多个表达式】 -->
        <!--<aop:pointcut expression="execution(* cn.itcast.g_pointcut.UserDao.save()) || execution(* cn.itcast.g_pointcut.OrderDao.save())" id="pt"/>-->
        <!--<aop:pointcut expression="execution(* cn.itcast.g_pointcut.UserDao.save()) or execution(* cn.itcast.g_pointcut.OrderDao.save())" id="pt"/>-->
        <!-- 下面2个且关系的，没有意义 -->
        <!--<aop:pointcut expression="execution(* cn.itcast.g_pointcut.UserDao.save()) &amp;&amp; execution(* cn.itcast.g_pointcut.OrderDao.save())" id="pt"/>-->
        <!--<aop:pointcut expression="execution(* cn.itcast.g_pointcut.UserDao.save()) and execution(* cn.itcast.g_pointcut.OrderDao.save())" id="pt"/>-->

        <!-- 【取非值】 -->
        <!--<aop:pointcut expression="!execution(* cn.itcast.g_pointcut.OrderDao.save())" id="pt"/>-->

4. dao 事务
    Spring声明式事务管理器类：
        Jdbc技术：DataSourceTransactionManager
        Hibernate技术：HibernateTransactionManager

































