--ers_reimbursement table
create table ers_reimbursement (
	reimb_id serial primary key,
    reimb_amount int,
    reimb_submitted timestamp,
    reimb_resolved timestamp,
    reimb_description text,
    
    reimb_author_fk int references ers_users(ers_users_id),
    reimb_resolver_fk int references ers_users(ers_users_id),
    reimb_status_id_fk int references ers_reimbursement_status(reimb_status_id),
    reimb_type_id_fk int references ers_reimbursement_type(reimb_type_id)
);

insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author_fk, reimb_resolver_fk, reimb_status_id_fk, reimb_type_id_fk)
values (500, current_timestamp, current_timestamp, 'phone cracked', 2, 2, 1, 1 ),
       (430, current_timestamp, current_timestamp, 'expired food', 1, 1, 2, 2),
       (787, current_timestamp, current_timestamp, 'gas price', 5, 5, 1, 1),
       (93, current_timestamp, current_timestamp, 'other', 3, 3, 2, 2);

select * from ers_reimbursement;

drop table ers_reimbursement  cascade;


--ers_users table
create table ers_users (
	ers_users_id serial primary key,
    ers_username varchar(50) unique not null,
    ers_password varchar(50) not null,
    user_first_name varchar(100) not null,
    user_last_name varchar(100) not null,
    user_email varchar(150) unique not null,
    
    user_role_id_fk int references ers_user_roles(ers_user_role_id)

);

insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id_fk)
values ('user', 'password', 'rabin', 'basnet','rbasnet@yahoo.com',1),
	   ('user1', 'password', 'james', 'jordan', 'jjordan@gmail.com',2),
	   ('user3', 'password', 'robert', 'grey', 'roberts@yahoo.com',3);
	   
select * from ers_users;
--update ers_users set ers_password = 'password' where ers_users_id =7;


--ers_reimbursement_status table
create table ers_reimbursement_status (
	reimb_status_id serial primary key,
    reimb_status varchar(10) not null

);

insert into ers_reimbursement_status (reimb_status)
values ('approved'),
       ('denied');
      
select * from ers_reimbursement_status;



--ers_reimbursement_type table
create table ers_reimbursement_type (
	reimb_type_id serial primary key,
    reimb_type varchar(10) not null

);

insert into ers_reimbursement_type (reimb_type)
values ('lodging'),
       ('travel'),
       ('food'),
       ('other');
      
 select * from ers_reimbursement_type; 


--ers_user_roles table
create table ers_user_roles (
	ers_user_role_id serial primary key,
    user_role varchar(10) not null

);

insert into ers_user_roles (user_role)
values ('doctor'),
       ('engineer'),
       ('developer');
      
select * from ers_user_roles;

drop table ers_users  cascade;