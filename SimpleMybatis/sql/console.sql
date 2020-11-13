# 一对一
create table card(
                      cid int(5) primary key,
                      cnum varchar(10)
);

create table student2(
                         sid int(5) primary key,
                         sname varchar(10),
                         scid int(5),
                         constraint scid_fk foreign key(scid) references card(cid)
);

insert into card(cid,cnum) values(1,'111');
insert into student2(sid,sname,scid) values(1,'哈哈',1);

select * from student2 s,card c where c.cid = s.scid and sid=1;

# 一对多
create table grade(
                       gid int(5) primary key,
                       gname varchar(10)
);

create table student3(
                         sid int(5) primary key,
                         sname varchar(10),
                         sgid int(5),
                         constraint sgid_fk foreign key(sgid) references grade(gid)
);


insert into grade(gid,gname) values(1,'java');

insert into student3(sid,sname,sgid) values(1,'哈哈',1);
insert into student3(sid,sname,sgid) values(2,'呵呵',1);

select * from student3 s, grade g WHERE s.sgid=g.gid and g.gname='java';


# 多对多
create table student4(
                         sid int(5) primary key,
                         sname varchar(10)
);

create table course(
                        cid int(5) primary key,
                        cname varchar(10)
);

create table middle(
                        msid int(5),
                        mcid int(5),
                        primary key(msid,mcid)
);

insert into student4(sid,sname) values(1,'哈哈');
insert into student4(sid,sname) values(2,'呵呵');

insert into course(cid,cname) values(1,'java');
insert into course(cid,cname) values(2,'android');

insert into middle(msid,mcid) values(1,1);
insert into middle(msid,mcid) values(1,2);
insert into middle(msid,mcid) values(2,1);
insert into middle(msid,mcid) values(2,2);







