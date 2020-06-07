insert into employee (id, name, last_name, age, pesel, employee_role)
values(1,'Ed', 'Edovsky', 44, 77777777777, 'CEO');

insert into employee (id, name, last_name, age, pesel, employee_role)
values(2,'Rob', 'Robovsky', 33, 66666666666, 'WORKER');

insert into address (id, employee_id, address_type, city, home_number, province, street, zip )
values(1, 1, 'HOME', 'Wroclaw', 21, 'dolnoslaskie', 'Armii Krajowej', '50-550');

insert into address (id, employee_id, address_type, city, home_number, province, street, zip )
values(2, 2, 'HOME', 'Wroclaw', 21, 'dolnoslaskie', 'Armii Krajowej', '50-550');
