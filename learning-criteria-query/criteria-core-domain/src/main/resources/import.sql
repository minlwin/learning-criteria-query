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