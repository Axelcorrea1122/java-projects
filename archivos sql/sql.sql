INSERT INTO `autos`.`motores`
(`id`,
`marca`,
`modelo`,
`cilindrada`,
`tipoCombustible`)
VALUES
('m12',
'Mercedes Benz',
'V8',
'2.0',
'GNC');


INSERT INTO `autos`.`autos`
(`vin`,
`marca`,
`modelo`,
`color`,
`fechaFab`,
`cantPuertas`,
`idMotor`)
VALUES
('ASDFG!"#$%1234567',
'FIAT',
'Punto',
'Rojo',
'2019-06-08',
5,
'h15');

select *
from autos
join motores
  on idMotor = id;
  
select *
from motores
where tipoCombustible = 'Nafta';
