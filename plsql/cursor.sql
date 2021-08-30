set serveroutput on;
begin
   update t_type set type_name=type_name;
   dbms_output.put_line(sql%rowcount);
end;
/
select * from t_type;

--================== 显示游标======显示使用======================
declare
cursor cur(a number,b number) is select * from t_type where type_id between a and b;
i t_type%rowtype;
begin
   open cur(1,3);  -- 必须先打开
   loop
       fetch cur into i; -- fetch 移动游标，并取出数据
       exit when cur%notfound; -- fetch不到数据 notfound属性为true。
       dbms_output.put_line(i.type_id || ':' ||i.type_name);
   end loop;
   close cur;  -- 用完要释放
end;
/
--================显示游标 隐式使用=================
declare
cursor cur(a number,b number) is select * from t_type where type_id between a and b;
begin
   for i in cur(1,4) loop
      dbms_output.put_line(i.type_id || ':' ||i.type_name);
   end loop;
end;
/

--=========================使用游标更改数据=======delete update ====================
declare
cursor cur is select * from t_type for update; -- 可写游标
i t_type%rowtype;
begin
   open cur;
   loop
     fetch cur into i;
     exit when cur%notfound;
     
     if i.type_name='Java' then
        update t_type set type_name = 'java' where current of cur;
        dbms_output.put_line('java -->  Java');
     end if;
   end loop;
   close cur;
end;
/

select * from t_type;

--=============================== 游标量变 引用游标 =============================
declare
--type refcur is ref cursor; -- 定义了一个引用游标“类型”。
--cur refcur;  --  ucr 是一个变量
cur sys_refcursor; -- oracle 中已经预先定义了一个sys_refcursor 是一个引用游标“类型”。
i t_type%rowtype;
stm varchar2(200 char);
begin
   stm := 'select * from t_type';
   open cur for stm;
   loop
      fetch cur into i;
      exit when cur%notfound;
     dbms_output.put_line(i.type_id || ':' ||i.type_name);
      
   end loop;
   close cur;
end;
