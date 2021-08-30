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

   --null;-- PL/SQL�������п����
end;
/

--==================���̿���========================
--=================if.... then..... else..... end if;=================
declare
i number;
begin

 i:= round(dbms_random.value()*100);
 dbms_output.put_line(i);
 if mod(i, 2)=0 then
    dbms_output.put_line('ż��');
 else
   dbms_output.put_line('����');
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
  for i in (select * from t_user) loop -- i �ǲ�ѯ����ÿһ����¼
     dbms_output.put_line(i.user_id ||',' ||i.login_name);
  end loop;
end;
/
--======================= dml in pl/sql�﷨��SQL�����һ���ġ�ֻ�ǿ���ʹ�ñ���
declare
name varchar2(20);
id number;
begin
    name := 'Will';
    id := 10;
    update t_user set login_name=name where user_id = id;
end;
/
--======��PL/SQL��ʹ�ò�ѯ����SQL�в�ͬ===����Ϊ��ֵ���飬�鲻��������쳣��==================
--  select a, b into i, j  from ......
declare
id number;
name nvarchar2(20);
c number;
p t_user.pwd%type; --  ���ձ�.�ֶε�����
begin
   id := 10;
    select count(*) into c from t_user where user_id=id;
   
    if c = 1 then
       select login_name, pwd into name, p from t_user where user_id=id;
       dbms_output.put_line(name || ':' || p);
    else
       dbms_output.put_line('��ѯ�������û�ID��'|| ID || '���û���');
    end if;
end;
/
--======================= %rowtype ==========================
declare
id number;
type_name varchar2(20);
i t_type%rowtype;  -- ���ձ�ġ������͡�
begin
   select * into i from t_type where type_id=1;
   dbms_output.put_line(i.type_id || ':' || i.type_name); -- ȡ���е��ֶ�
end;
/
-- == exception---------------------------
declare
i t_type%rowtype;  -- ���ձ�ġ������͡�
begin
   select * into i from t_type where type_id=12;
   dbms_output.put_line(i.type_name);
   exception
--   when too_many_rows then
--      dbms_output.put_line('��ѯ����ֻһ����¼');
--   when no_data_found then   
--      dbms_output.put_line('��ѯ������¼');
   when others then
      dbms_output.put_line('������������������������');
end;
/
