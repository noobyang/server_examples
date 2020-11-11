1. PowerDesigner 在设计数据库表时，我们使用PowerDesigner来生成概念模型\物理模型…

2. Hibernate中对象的状态：
   临时/瞬时状态
   持久化状态
   游离状态

3. Hibernate有一级缓存和二级缓存之分，这里主要讲解一级缓存
   Hibernate中一级缓存，也叫做session的缓存，它可以在session范围内减少数据库的访问次数！  只在session范围有效！ Session关闭，一级缓存失效！
   只要是持久化对象状态的，都受Session管理，也就是说，都会在Session缓存中！
   Session的缓存由hibernate维护，用户不能操作缓存内容； 如果想操作缓存内容，必须通过hibernate提供的evit/clear方法操作。

4. 和缓存有关常用的方法有三个：
   session.flush();       让一级缓存与数据库同步
   session.evict(arg0);    清空一级缓存中指定的对象
   session.clear();       清空一级缓存中缓存的所有对象

   每隔一定记录数，先与数据库同步  flush()
   再清空缓存        clear()

5. list() 一次性把数据取出来，会放入缓存，但是不会从缓存中获取数据。推荐
   iterator() 一条一条查询数据，会放入缓存，也会从缓存中取数据。

6. 懒加载
   懒加载就是当使用数据的时候才去获取数据、执行对应的SQL语句…当还没用到数据的时候，就不加载对应的数据!
   主要目的就是为了提高Hibernate的性能，提高执行效率！
       get: 及时加载，只要调用get方法立刻向数据库查询
       load:默认使用懒加载，当用到数据的时候才向数据库查询。

7. 我们可以在对应的配置文件用通常lazy属性来设置
   关闭懒加载：
        <class name="IdCard" table="IdCard" lazy="false">

   lazy有三个属性:
   true   使用懒加载
   false   关闭懒加载
   extra   (在集合数据懒加载时候提升效率)【只有在set、list等集合标签中使用】
        在真正使用数据的时候才向数据库发送查询的sql；
        如果调用集合的size()/isEmpty()方法，只是统计，不真正查询数据！

8. Hibernate二级缓存
   前面我们已经讲解过了一级缓存，一级缓存也就是Session缓存，只在Session的范围内有效…作用时间就在Session的作用域中，范围比较小
   Hibernate为我们提供了二级缓存功能：二级缓存是基于应用程序的缓存，所有的Session都可以使用
   Hibernate提供的二级缓存有默认的实现，且是一种可插配的缓存框架！如果用户想用二级缓存，只需要在hibernate.cfg.xml中配置即可； 不想用，直接移除，不影响代码。
   如果用户觉得hibernate提供的框架框架不好用，自己可以换其他的缓存框架或自己实现缓存框架都可以。

    #hibernate.cache.use_second_level_cache false【二级缓存默认不开启，需要手动开启】
    #hibernate.cache.use_query_cache true      【开启查询缓存】
    ## choose a cache implementation        【二级缓存框架的实现】
    #hibernate.cache.provider_class org.hibernate.cache.EhCacheProvider
    #hibernate.cache.provider_class org.hibernate.cache.EmptyCacheProvider
    hibernate.cache.provider_class org.hibernate.cache.HashtableCacheProvider 默认实现
    #hibernate.cache.provider_class org.hibernate.cache.TreeCacheProvider
    #hibernate.cache.provider_class org.hibernate.cache.OSCacheProvider
    #hibernate.cache.provider_class org.hibernate.cache.SwarmCacheProvider

