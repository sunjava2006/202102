set serveroutput on;
begin
   update t_type set type_name=type_name;
   dbms_output.put_line(sql%rowcount);
end;
/
select * from t_type;

--================== ��ʾ�α�======��ʾʹ��======================
declare
cursor cur(a number,b number) is select * from t_type where type_id between a and b;
i t_type%rowtype;
begin
   open cur(1,3);  -- �����ȴ�
   loop
       fetch cur into i; -- fetch �ƶ��α꣬��ȡ������
       exit when cur%notfound; -- fetch�������� notfound����Ϊtrue��
       dbms_output.put_line(i.type_id || ':' ||i.type_name);
   end loop;
   close cur;  -- ����Ҫ�ͷ�
end;
/
--================��ʾ�α� ��ʽʹ��=================
declare
cursor cur(a number,b number) is select * from t_type where type_id between a and b;
begin
   for i in cur(1,4) loop
      dbms_output.put_line(i.type_id || ':' ||i.type_name);
   end loop;
end;
/

--=========================ʹ���α��������=======delete update ====================
declare
cursor cur is select * from t_type for update; -- ��д�α�
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

--=============================== �α����� �����α� =============================
declare
--type refcur is ref cursor; -- ������һ�������αꡰ���͡���
--cur refcur;  --  ucr ��һ������
cur sys_refcursor; -- oracle ���Ѿ�Ԥ�ȶ�����һ��sys_refcursor ��һ�������αꡰ���͡���
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
