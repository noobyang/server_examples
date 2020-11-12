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

4.











