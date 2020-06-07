insert into employee (id, name, last_name, age, pesel, employee_role)
values(100,'Ed', 'Edovsky', 44, 77777777777, 'CEO');

insert into employee (id, name, last_name, age, pesel, employee_role)
values(200,'Rob', 'Robovsky', 33, 66666666666, 'WORKER');

insert into address (id, employee_id, address_type, city, home_number, province, street, zip )
values(100, 100, 'HOME', 'Wroclaw', 21, 'dolnoslaskie', 'Armii Krajowej', '50-550');

insert into address (id, employee_id, address_type, city, home_number, province, street, zip )
values(200, 200, 'HOME', 'Wroclaw', 21, 'dolnoslaskie', 'Armii Krajowej', '50-550');
