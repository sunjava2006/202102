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
select * from t_users;
alter table t_users add gender nchar(1);

create table t_users as select * from t_user;
--
create or replace trigger trg_update_insert_users_gener
before insert or update of gender on t_users
for each row
when (new.gender not in ('F','M'))
begin
    if inserting then
       :new.gender := 'F';
    elsif updating then
       :new.gender := null;
    end if;
   
end;

insert into t_users(user_id, login_name, pwd, gender)values(222, 'FaFa', '123456','x');
update t_users set gender = 'r';

create or replace view v_user_aritcle as select a.title, a.content article_content,a.publish_date, v.content, v.publish_date review_publish_date
from t_article a left join t_review v on a.article_id=v.article_id;

select * from v_user_aritcle;

--=============================================================
create or replace trigger trg_update_v_user_article 
instead of update on v_user_aritcle
begin
   dbms_output.put_line('update v_user_aritcle');
   null;
end;

update v_user_aritcle set content = 'xxxx';


--=============================ddl====================
create or replace trigger trg_ddl
before create or alter or drop on SCHEMA
begin
   dbms_output.put_line(login_user ||' ' || sysdate ||' '|| sys.sysevent ||' ' || SYS.dictionary_obj_name ||' ' || SYS.dictionary_obj_type);
end;

create table t_xx(id number);
drop table t_xx;
