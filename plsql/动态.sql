set serveroutput on;
-- 使用游标变量实现
declare
i t_type%rowtype;
cur sys_refcursor;
stm varchar2(2000 char);
begin
   stm := 'select * from t_type where type_id in (:a, :b)'; 
   open cur for stm using 1, 3;
   loop
      fetch cur into i;
      exit when cur%notfound;
      dbms_output.put_line(i.type_id ||':' || i.type_name);
   end loop; 
   close cur;
end;
/

--===================== execute immediate ==========================================
create or replace procedure p_test(v in number) as
stm varchar2(200 char);
begin
   stm:='insert into t_test values(:v)';
   execute immediate stm using v;
null;
end;
/

declare
stm varchar2(300 char);
p nchar(6);
begin
   stm := 'delete from t_article where article_id=:id';
   execute immediate stm using 100;
   dbms_output.put_line(sql%rowcount);
   
   stm := 'update t_type set type_name=:name where type_id=:id';
   EXECUTE IMMEDIATE stm using 'C++', 1;
    dbms_output.put_line(sql%rowcount);
    
    stm := 'select pwd from t_user where login_name=:login';
    execute immediate stm into p using 'Xi1234';
    dbms_output.put_line(p);
    
end;
/
select * from t_type;
