

drop sequence test1_sq;
drop table test1;
create table test1(
   tseq number primary key,
   tcurr number not null
);
create sequence test1_sq start with 1 nocache;
insert into test1 values(test1_sq.nextval, test1_sq.currval);
--insert into test1 values(test1_sq.nextval, test1_sq.currval);

select * from test1;

drop sequence test2_sq;
drop table test2;
create table test2(
   t2seq number primary key,
   t2curr number not null
);
create sequence test2_sq start with 1 nocache;
insert into test2 values(test2_sq.nextval, test1_sq.currval);
select * from test1;
select * from test2;
insert into test2 values(test2_sq.nextval, test1_sq.currval);
select * from test1;
select * from test2;

drop sequence test3_sq;
drop table test3;
create table test3(
   t2seq number primary key,
   t2curr number not null
);
create sequence test3_sq start with 1 nocache;
insert into test3 values(test3_sq.nextval, test3_sq.currval);
select * from test3;