create or REPLACE package my
as
    procedure p_qa(e nvarchar2, q nvarchar2, a out nvarchar2);
end;

create or replace package body my 
as
   procedure p_qa(e nvarchar2, q nvarchar2, a out nvarchar2)
   as
   begin
      select answer into a from t_user where email=e and question=q;
   end;
end;
/


declare
a nvarchar2(40);
begin
    my.p_qa('jack@123.com','1+2=?',a);
    dbms_output.put_line(a);
end;


SELECT
    *
FROM t_user;