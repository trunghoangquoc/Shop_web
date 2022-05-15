use shopspringboot;

insert into role(code,name) values('ADMIN','Quản Trị');
insert into role(code,name) values('ADMIN_PRODUCT','Quản Trị Sản Phẩm');
insert into role(code,name) values('ADMIN_USER','Quản Trị Người Dùng');
insert into role(code,name) values('ADMIN_ORDER','Quản Trị Đặt Hàng');
insert into role(code,name) values('ADMIN_FEEDBACK','Quản Trị FeedBack');
insert into role(code,name) values('USER','Người Dùng');

insert into user(username,password,fullname,status,email)
values('adminManager','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoang quoc trung',1,'trung@gmail.com');
insert into user(username,password,fullname,status,email)
values('adminProduct','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoang trung product',1,'trung1@gmail.com');
insert into user(username,password,fullname,status,email)
values('adminUser','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoang trung user',1,'trung2@gmail.com');
insert into user(username,password,fullname,status,email)
values('adminOrder','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoang  trung oder',1,'trung3@gmail.com');
insert into user(username,password,fullname,status,email)
values('adminFeedBack','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoang trung feedback',1,'trung4@gmail.com');
insert into user(username,password,fullname,status,email)
values('nguyenvana','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn A',1,'A@gmail.com');
insert into user(username,password,fullname,status,email)
values('nguyenvanb','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyễn văn B',1,'B@gmail.com');
insert into user(username,password,fullname,status,email)
values('hoangvantrunga','$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','hoang van trung',1,'trunguser@gmail.com');

INSERT INTO user_role(user_id,role_id) VALUES (1,1);
INSERT INTO user_role(user_id,role_id) VALUES (1,2);
INSERT INTO user_role(user_id,role_id) VALUES (1,3);
INSERT INTO user_role(user_id,role_id) VALUES (1,4);
INSERT INTO user_role(user_id,role_id) VALUES (1,5);
INSERT INTO user_role(user_id,role_id) VALUES (1,6);

INSERT INTO user_role(user_id,role_id) VALUES (2,1);
INSERT INTO user_role(user_id,role_id) VALUES (2,5);
INSERT INTO user_role(user_id,role_id) VALUES (2,6);

INSERT INTO user_role(user_id,role_id) VALUES (3,2);
INSERT INTO user_role(user_id,role_id) VALUES (3,5);
INSERT INTO user_role(user_id,role_id) VALUES (3,6);

INSERT INTO user_role(user_id,role_id) VALUES (4,3);
INSERT INTO user_role(user_id,role_id) VALUES (4,5);
INSERT INTO user_role(user_id,role_id) VALUES (4,6);

INSERT INTO user_role(user_id,role_id) VALUES (5,4);
INSERT INTO user_role(user_id,role_id) VALUES (5,5);
INSERT INTO user_role(user_id,role_id) VALUES (5,6);

insert into category(code,name) values('Rau-Cu','Rau Củ');
insert into category(code,name) values('Hoa-Qua','Hoa Quả');