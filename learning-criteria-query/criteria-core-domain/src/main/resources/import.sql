insert into department(code, name, phone, email, extra_phone) values ('ACE', 'Accident and emergency', '0911112222', 'ace@hospital.com', '0911112242');
insert into department(code, name, phone, email, extra_phone) values ('ANS', 'Anesthetics', '0911112223', 'ans@hospital.com', '0911112243');
insert into department(code, name, phone, email, extra_phone) values ('CAD', 'Cardiology', '0911112224', 'cad@hospital.com', '0911112244');
insert into department(code, name, phone, email, extra_phone) values ('CCU', 'Coronary Care Unit', '0911112225', 'ccu@hospital.com', '0911112245');
insert into department(code, name, phone, email, extra_phone) values ('DIG', 'Diagnostic Imaging', '0911112226', 'dig@hospital.com', '0911112246');
insert into department(code, name, phone, email, extra_phone) values ('GTR', 'Gastroenterology', '0911112227', 'gtr@hospital.com', '0911112247');
insert into department(code, name, phone, email, extra_phone) values ('GSG', 'General Surgery', '0911112228', 'gsg@hospital.com', '0911112248');
insert into department(code, name, phone, email, extra_phone) values ('ICU', 'Intensive Care Unit', '0911112229', 'icu@hospital.com', '0911112249');
insert into department(code, name, phone, email, extra_phone) values ('MTE', 'Maternity', '0911112230', 'mte@hospital.com', '0911112250');
insert into department(code, name, phone, email, extra_phone) values ('NUO', 'Neurology', '0911112231', 'nuo@hospital.com', '0911112251');

insert into account(login_id, password, role, activated) values ('aung@hospital.com', 'aungaung', 0, true);
insert into account(login_id, password, role, activated) values ('thidar@hospital.com', 'thidar', 0, true);
insert into account(login_id, password, role, activated) values ('nilar@hospital.com', 'nilar', 0, true);

insert into doctor (account_login_id, email, name, phone, gender, degree, id) values ('aung@hospital.com', 'aung@hospital.com', 'Aung Aung', '0933334444', 0, 'MBBS', 1);
insert into doctor (account_login_id, email, name, phone, gender, degree, id) values ('thidar@hospital.com', 'thidar@hospital.com', 'Thidar', '0933335555', 1, 'MED', 2);
insert into doctor (account_login_id, email, name, phone, gender, degree, id) values ('nilar@hospital.com', 'nilar@hospital.com', 'Nilar Aung', '0933336666', 1, 'PHD', 3);

insert into doctor_department values (1, 'ICU');
insert into doctor_department values (2, 'ICU');
insert into doctor_department values (3, 'GSG');

insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (1, 0, '9:00', '12:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (1, 0, '16:00', '20:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (1, 1, '9:00', '12:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (1, 1, '16:00', '20:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (2, 2, '9:00', '12:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (2, 2, '16:00', '20:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (2, 3, '9:00', '12:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (2, 3, '16:00', '20:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (3, 4, '16:00', '20:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (3, 5, '16:00', '20:00', 50);
insert into doctor_schedule(doctor_id, day_of_week, start_time, end_time, max_patient) values (3, 6, '16:00', '20:00', 50);

insert into account(login_id, password, role, activated) values ('kkzin@gmail.com', 'kkzin@gmail.com', 1, true);
insert into account(login_id, password, role, activated) values ('theint@gmail.com', 'theint@gmail.com', 1, true);
insert into account(login_id, password, role, activated) values ('zlhtet@gmail.com', 'zlhtet@gmail.com', 1, true);
insert into account(login_id, password, role, activated) values ('pphyo@gmail.com', 'pphyo@gmail.com', 1, true);
insert into account(login_id, password, role, activated) values ('mkthu@gmail.com', 'mkthu@gmail.com', 1, true);
insert into account(login_id, password, role, activated) values ('klwin@gmail.com', 'klwin@gmail.com', 1, true);

insert into patient(id, name, phone, email, gender, dob, regist_at, address, account_login_id) values (1, 'Kyaw Khant Zin', '0911223344', ',kkzin@gmail.com', 0, '1999-01-19', '2024-05-10 10:00', 'South Okkalarpa, Yangon', 'kkzin@gmail.com');
insert into patient(id, name, phone, email, gender, dob, regist_at, address, account_login_id) values (2, 'Theint Teint Thu', '0911223355', ',theint@gmail.com', 1, '2005-01-10', '2024-03-20 16:30', 'Kamayut, Yangon', 'theint@gmail.com');
insert into patient(id, name, phone, email, gender, dob, regist_at, address, account_login_id) values (3, 'Zin Lin Htet', '0911223366', ',zlhtet@gmail.com', 0, '2002-06-15', '2024-01-30 16:30', 'Mayangone, Yangon', 'zlhtet@gmail.com');
insert into patient(id, name, phone, email, gender, dob, regist_at, address, account_login_id) values (4, 'Pyae Phyo', '0911223377', ',pphyo@gmail.com', 0, '2000-06-20', '2023-12-15 16:30', 'Kamayut, Yangon', 'pphyo@gmail.com');
insert into patient(id, name, phone, email, gender, dob, regist_at, address, account_login_id) values (5, 'Min Khan Thu', '0911223388', ',mkthu@gmail.com', 0, '1995-10-01', '2023-10-20 16:30', 'Kamayut, Yangon', 'mkthu@gmail.com');
insert into patient(id, name, phone, email, gender, dob, regist_at, address, account_login_id) values (6, 'Kyaw Lwin', '0911223399', ',klwin@gmail.com', 0, '1990-05-20', '2023-09-15 16:30', 'Hlaing, Yangon', 'klwin@gmail.com');