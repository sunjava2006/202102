set serveroutput on;

-- ��������
create or replace procedure p_greet(greet in nvarchar2:='hello' , who in nvarchar2)--����������Ĭ��ֵ
as
begin
    dbms_output.put_line(greet ||' ' || who);
end;

--���ù���,�����֣�һ������SQL�����£�exec ����������PL/SQL�� û��exec,ֱ�ӵ��ù�������
begin
 p_greet(who=>'Wang', greet=>'���'); -- �������԰�˳��ֵ��Ҳ����ָ������ֵ��
end;

-- ����һ������������Ĺ���
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

-- ʹ�ù���ʵ�ֲ�ѯ
create or replace procedure p_list_user(page number, len number, cur out sys_refcursor)
as
begin
   open cur for select user_id, login_name, pwd, email, question, answer from ( select a.*, rownum ro from (select * from t_user order by user_id)a where rownum<=(page*len))where ro >((page-1)*len);
end;

-- ���ò�ѯ���ؽ���Ĺ���
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

--��������
create or replace function f_grad(n number) return nvarchar2
as
grad nvarchar2(30):= '���ܻ�ӭ';
begin
   if n >10000 then
      grad := '�ܻ�ӭ';
   end if;
   return grad;
end;
/
--==========================sql�����ʹ�ú���====================================
select title, access_count, f_grad(access_count) from t_article;

--=====================PL/SQL�к�������ֱ�ӵ���
declare
g nvarchar2(30);
begin
   g := f_grad(222222);
   dbms_output.put_line(g);
end;
