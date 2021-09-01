--before -after
create or replace trigger trg_add_user
before insert on t_user
for each row
when (new.user_id is null)-- :new 在条件表达式中:new和:old的：不能写。
declare
id number;
begin
   dbms_output.put_line('-------instrt--------');
   select seq_user.nextval into id from dual;
   :new.user_id := id;   -- :new \:old  是我们新添加\删除数据的缓冲区。新添加的数据还没有正式写入数据库之前在:new中。还没有正式删除之前在:old中。
end;

set serveroutput on;
insert into t_user(login_name, pwd, email, question, answer) values('xaba', '123456','xxx@123.com','1+1','2');
insert into t_user(login_name, pwd, email, question, answer) values ('xaba11', '123456','xxx@123.com','1+1','2');

insert into t_user(login_name, pwd) select login_name, pwd from t_user;

/
select * from t_user;