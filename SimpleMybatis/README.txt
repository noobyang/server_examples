1. 占位符
   在Mybatis中，有两种占位符
       #{}解析传递进来的参数数据
       ${}对传递进来的参数原样拼接在SQL中

2. 有的时候，我们看别的映射文件，可能看不到以下这么一段代码：
    <resultMap id="userListResultMap" type="user" >
        id_,username_,birthday_
        id：要映射结果集的唯 一标识 ，称为主键
        column：结果集的列名
        property：type指定的哪个属性中
        <id column="id_" property="id"/>

        result就是普通列的映射配置
        <result column="username_" property="username"/>
        <result column="birthday_" property="birthday"/>
    </resultMap>
    因为，如果我们的数据表的字段和JavaBean的属性名称是相同时，我们就不用上面那段代码了。Mybatis会自动帮我们把返回的结果进行封装成JavaBean
    那当我们数据表的字段和JavaBean的属性名称不是相同时，我们就需要使用resultMap，也就是上面那段代码

3. 注意：这个insert/update/delete标签只是一个模板，在做操作时，其实是以SQL语句为核心的
   即在做增/删/时，insert/update/delete标签可通用，
   但做查询时只能用select标签
   我们提倡什么操作就用什么标签

4. Mybatis一级缓存
   第一次发出一个查询sql，sql查询结果写入sqlsession的一级缓存中，缓存使用的数据结构是一个map
       key：hashcode+sql+sql输入参数+输出参数（sql的唯一标识）
       value：用户信息

   同一个sqlsession再次发出相同的sql，就从缓存中取不走数据库。
   如果两次中间出现commit操作（修改、添加、删除），本sqlsession中的一级缓存区域全部清空，
   下次再去缓存中查询不到所以要从数据库查询，从数据库查询到再写入缓存。

    Mybatis一级缓存值得注意的地方：
        Mybatis默认就是支持一级缓存的，并不需要我们配置.
        mybatis和spring整合后进行mapper代理开发，不支持一级缓存，mybatis和spring整合，
        spring按照mapper的模板去生成mapper代理对象，模板中在最后统一关闭sqlsession。

5. Mybatis二级缓存
   二级缓存的范围是mapper级别（mapper同一个命名空间），mapper以命名空间为单位创建缓存数据结构，结构是map。

       <!-- 全局配置参数 -->
       <settings>
           <!-- 开启二级缓存 -->
           <setting name="cacheEnabled" value="true"/>
       </settings>

   上面已经说了，二级缓存的范围是mapper级别的，因此我们的Mapper如果要使用二级缓存，还需要在对应的映射文件中配置..
   <cache/>

6. 查询结果映射的pojo序列化
    mybatis二级缓存需要将查询结果映射的pojo实现 java.io.serializable接口，如果不实现则抛出异常：
    org.apache.ibatis.cache.CacheException: Error serializing object.  Cause: java.io.NotSerializableException: cn.itcast.mybatis.po.User
    二级缓存可以将内存的数据写到磁盘，存在对象的序列化和反序列化，所以要实现java.io.serializable接口。
    如果结果映射的pojo中还包括了pojo，都要实现java.io.serializable接口。

7. 禁用二级缓存 useCache
    对于变化频率较高的sql，需要禁用二级缓存：
    在statement中设置useCache=false可以禁用当前select语句的二级缓存，即每次查询都会发出sql去查询，默认情况是true，即该sql使用二级缓存。、、
    <select id="findOrderListResultMap" resultMap="ordersUserMap" useCache="false">

8. 刷新缓存 flushCache
    有的同学到这里可能会有一个疑问：为什么缓存我们都是在查询语句中配置？？而使用增删改的时候，缓存默认就会被清空【刷新了】？？？
    缓存其实就是为我们的查询服务的，对于增删改而言，如果我们的缓存保存了增删改后的数据，那么再次读取时就会读到脏数据了！
    我们在特定的情况下，还可以单独配置刷新缓存【但不建议使用】flushCache，默认是的true
        <update id="updateUser" parameterType="cn.itcast.mybatis.po.User" flushCache="false">
            update user set username=#{username},birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}
        </update>

9. 了解Mybatis缓存的一些参数
    mybatis的cache参数只适用于mybatis维护缓存。
    flushInterval（刷新间隔）可以被设置为任意的正整数，而且它们代表一个合理的毫秒形式的时间段。默认情况是不设置，也就是没有刷新间隔，缓存仅仅调用语句时刷新。
    size（引用数目）可以被设置为任意正整数，要记住你缓存的对象数目和你运行环境的可用内存资源数目。默认值是1024。
    readOnly（只读）属性可以被设置为true或false。只读的缓存会给所有调用者返回缓存对象的相同实例。因此这些对象不能被修改。这提供了很重要的性能优势。可读写的缓存会返回缓存对象的拷贝（通过序列化）。这会慢一些，但是安全，因此默认是false。
    如下例子：
        <cache  eviction="FIFO"  flushInterval="60000"  size="512"  readOnly="true"/>
    这个更高级的配置创建了一个 FIFO 缓存,并每隔 60 秒刷新,存数结果对象或列表的 512 个引用,而且返回的对象被认为是只读的,因此在不同线程中的调用者之间修改它们会导致冲突。可用的收回策略有, 默认的是 LRU:
        1.LRU – 最近最少使用的:移除最长时间不被使用的对象。
        2.FIFO – 先进先出:按对象进入缓存的顺序来移除它们。
        3.SOFT – 软引用:移除基于垃圾回收器状态和软引用规则的对象。
        4.WEAK – 弱引用:更积极地移除基于垃圾收集器状态和弱引用规则的对象。


