insert into user_details(id, birth_date, name)
values (10001, current_date(), 'Bryan');

insert into user_details(id, birth_date, name)
values (10002, current_date(), 'Jonah');

insert into user_details(id, birth_date, name)
values (10003, current_date(), 'Johann');

insert into user_details(id, birth_date, name)
values (10004, current_date(), 'Nico');

insert into post(id, description, user_id)
values (20001, 'I want to be a fullstack developer.', 10001);

insert into post(id, description, user_id)
values (20002, 'I want to learn DevOps', 10001);

insert into post(id, description, user_id)
values (20003, 'I want to be a software engineer.', 10002);

insert into post(id, description, user_id)
values (20004, 'I want to learn Spring Boot', 10002);