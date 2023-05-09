conn system/java1234 as sysdba

drop user mimi cascade;
alter session set "_oracle_script"=true;
create user mimi identified by mimi1234;
grant connect, resource, unlimited tablespace to mimi;
conn mimi/mimi1234
show user;