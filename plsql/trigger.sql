--before -after
create or replace trigger trg_add_user
before insert on t_user
for each row
when (new.user_id is null)-- :new ���������ʽ��:new��:old�ģ�����д��
declare
id number;
begin
   dbms_output.put_line('-------instrt--------');
   select seq_user.nextval into id from dual;
   :new.user_id := id;   -- :new \:old  �����������\ɾ�����ݵĻ�����������ӵ����ݻ�û����ʽд�����ݿ�֮ǰ��:new�С���û����ʽɾ��֮ǰ��:old�С�
end;

set serveroutput on;
insert into t_user(login_name, pwd, email, question, answer) values('xaba', '123456','xxx@123.com','1+1','2');
insert into t_user(login_name, pwd, email, question, answer) values ('xaba11', '123456','xxx@123.com','1+1','2');

insert into t_user(login_name, pwd) select login_name, pwd from t_user;

/
select * from t_user;