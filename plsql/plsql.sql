set serveroutput on;

declare
i number;
j number := 1;
k varchar2(20 char);
begin
   k := 'hi';
   dbms_output.put_line(k);
   
   i := 90;
   i := i + j;
   dbms_output.put_line(i);

   --null;-- PL/SQL不允许有空语句
end;
/

--==================流程控制========================
--=================if.... then..... else..... end if;=================
declare
i number;
begin

 i:= round(dbms_random.value()*100);
 dbms_output.put_line(i);
 if mod(i, 2)=0 then
    dbms_output.put_line('偶数');
 else
   dbms_output.put_line('奇数');
 end if;
null;
end;
/
declare
i number;
begin
   i := round( dbms_random.value()*10);
   dbms_output.put_line(i);
   if i <4 then
     dbms_output.put_line('less 4');
   elsif i>=4 and i<=7 then
     dbms_output.put_line('between 4 and 7');
   else
      dbms_output.put_line('great 7');
   end if;
end;

--=========================while============================
declare
i number;
j number;
begin
   i := 1;
   while i<=9 loop
      j := 1;
      while j<=i loop
          dbms_output.put(j || '*' || i || '=' || (j*i) ||'  ');
          j :=j+1;
      end loop;
      dbms_output.new_line();
      i:=i+1;
   end loop;
end;
--=========================loop=========================
declare
i number :=1;
j number ;
begin
   loop
     exit when i>9;
     j:=1;
     loop
        if j>i then
           exit;
        end if;
        dbms_output.put(j || '*' || i || '=' || (j*i) ||'  ');
        j :=j+1;
     end loop;
     dbms_output.new_line();
     i := i+1;
   end loop;
end;
/

--========================== for =======================
begin
    for i in reverse 1..9 loop
       for j in reverse 1..i loop
           dbms_output.put(j || '*' || i || '=' || (j*i) ||'  ');
       end loop;
       dbms_output.new_line();
    end loop;
end;

--=========================for in select ==========================
begin
  for i in (select * from t_user) loop -- i 是查询出的每一条记录
     dbms_output.put_line(i.user_id ||',' ||i.login_name);
  end loop;
end;
/
--======================= dml in pl/sql语法与SQL语句中一样的。只是可以使用变量
declare
name varchar2(20);
id number;
begin
    name := 'Will';
    id := 10;
    update t_user set login_name=name where user_id = id;
end;
/
--======在PL/SQL中使用查询与在SQL中不同===必须为赋值而查，查不到还会出异常。==================
--  select a, b into i, j  from ......
declare
id number;
name nvarchar2(20);
c number;
p t_user.pwd%type; --  参照表.字段的类型
begin
   id := 10;
    select count(*) into c from t_user where user_id=id;
   
    if c = 1 then
       select login_name, pwd into name, p from t_user where user_id=id;
       dbms_output.put_line(name || ':' || p);
    else
       dbms_output.put_line('查询不到，用户ID：'|| ID || '的用户。');
    end if;
end;
/
--======================= %rowtype ==========================
declare
id number;
type_name varchar2(20);
i t_type%rowtype;  -- 参照表的”行类型“
begin
   select * into i from t_type where type_id=1;
   dbms_output.put_line(i.type_id || ':' || i.type_name); -- 取行中的字段
end;
/
-- == exception---------------------------
declare
i t_type%rowtype;  -- 参照表的”行类型“
begin
   select * into i from t_type where type_id=12;
   dbms_output.put_line(i.type_name);
   exception
--   when too_many_rows then
--      dbms_output.put_line('查询到不只一条记录');
--   when no_data_found then   
--      dbms_output.put_line('查询不到记录');
   when others then
      dbms_output.put_line('出错啦。。。。。。。。。');
end;
/
