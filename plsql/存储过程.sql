set serveroutput on;

-- 创建过程
create or replace procedure p_greet(greet in nvarchar2:='hello' , who in nvarchar2)--参数可以有默认值
as
begin
    dbms_output.put_line(greet ||' ' || who);
end;

--调用过程,有两种，一种是在SQL环境下：exec 过程名。在PL/SQL下 没有exec,直接调用过程名。
begin
 p_greet(who=>'Wang', greet=>'你好'); -- 参数可以按顺序赋值，也可以指定参数值。
end;

-- 创建一个有输出参数的过程
create or replace procedure p_exist_loginname(name in nvarchar2, exist out boolean )
as 
counter binary_integer;
begin
   select count(*) into counter from t_user where login_name=name;
   if counter=1 then
      exist:=true;
    else
      exist := false;
    end if;
end;

-- pl/sql
declare
exist boolean;
begin
    p_exist_loginname('Xi1234', exist);
    if exist then
      dbms_output.put_line('exist');
    else
      dbms_output.put_line('not exist');
    end if;
end;

-- 使用过程实现查询
create or replace procedure p_list_user(page number, len number, cur out sys_refcursor)
as
begin
   open cur for select user_id, login_name, pwd, email, question, answer from ( select a.*, rownum ro from (select * from t_user order by user_id)a where rownum<=(page*len))where ro >((page-1)*len);
end;

-- 调用查询返回结果的过程
declare
type user_record is record(id number, login NVARCHAR2(20), pwd char(6), email nvarchar2(50), q nvarchar2(50), a nvarchar2(50));
cur sys_refcursor;
i user_record;
begin
   p_list_user(1, 3, cur);
   loop
      fetch cur into i;
      exit when cur%notfound;
      dbms_output.put_line(i.id ||', '||i.login || ', ' || i.pwd || ',' ||i.email ||', ' || i.q || ', ' || i.a);
   end loop;
   close cur;
end;

--创建函数
create or replace function f_grad(n number) return nvarchar2
as
grad nvarchar2(30):= '不受欢迎';
begin
   if n >10000 then
      grad := '受欢迎';
   end if;
   return grad;
end;
/
--==========================sql语句中使用函数====================================
select title, access_count, f_grad(access_count) from t_article;

--=====================PL/SQL中函数可以直接调用
declare
g nvarchar2(30);
begin
   g := f_grad(222222);
   dbms_output.put_line(g);
end;
