
public class MainApp {
	
	public static void main(String[] args) {
		LasQuerys lasQuerys = new LasQuerys();
		String[] basesDatos = new String[9];
		//Guardamos el nombre de todas las bases de datos en un array.
		basesDatos[0]="ud18latiendadeinformatica";
		basesDatos[1]="ud18empleados";
		basesDatos[2]="ud18losalmacenes";
		basesDatos[3]="ud18peliculasysalas";
		basesDatos[4]="ud18losdirectores";
		basesDatos[5]="ud18piezasyproveedores";
		basesDatos[6]="ud18loscientificos";
		basesDatos[7]="ud18losgrandesalmacenes";
		basesDatos[8]="ud18losinvestigadores";
		//Llamamos al método que establece la conexión.
		lasQuerys.establecerCon();
		//Creamos las bases de datos de todos los ejercicios para trabajar a partir de ellas.
		
		for(int i=0;i<9;i++) {
			lasQuerys.crearDB(basesDatos[i]);
		}
		
		//Creamos las tablas del EJERCICIO 1.
		
		lasQuerys.crearTabla(basesDatos[0], "fabricantes"," (codigo INT NOT NULL AUTO_INCREMENT,"
				+ " nombre varchar(100) DEFAULT NULL,"
				+ " PRIMARY KEY (codigo))");
				
		lasQuerys.crearTabla(basesDatos[0], "articulos"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  precio int NOT NULL,"
				+ "  fabricante int NOT NULL,"
				+ "  PRIMARY KEY (codigo),"
				+ "	 FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");

		
		//Insertamos los datos del EJERCICIO 1.
		
		lasQuerys.insertarDatos(basesDatos[0], "INSERT INTO fabricantes(nombre)"
				+ "VALUES ('Samsung'),"
				+ "('Apple'),"
				+ "('Motorola'),"
				+ "('HTC'),"
				+ "('Nokia')");
				
		lasQuerys.insertarDatos(basesDatos[0], "INSERT INTO articulos(nombre,precio,fabricante)"
				+ "VALUES ('Galaxy','400',1),"
				+ "('Iphone','600',2),"
				+ "('Edge','300',3),"
				+ "('3310','50',5),"
				+ "('One Desire','250',4)");
		
		
		//Creamos las tablas del EJERCICIO 2.
		 
		lasQuerys.crearTabla(basesDatos[1], "departamentos"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  presupuesto int NOT NULL,"
				+ "  PRIMARY KEY (codigo))");
		 
		lasQuerys.crearTabla(basesDatos[1], "empleados"," (dni varchar(9) NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  apellidos varchar(255) NOT NULL,"
				+ "  departamento int NOT NULL,"
				+ "  PRIMARY KEY (dni),"
				+ "	 FOREIGN KEY (departamento) REFERENCES departamentos(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");
		 
		//Insertamos los datos del EJERCICIO 2.
		 
		lasQuerys.insertarDatos(basesDatos[1], "INSERT INTO departamentos(nombre,presupuesto)"
				+ "VALUES ('RRHH','10000'),"
				+ "('IT','60000'),"
				+ "('Ventas','30000'),"
				+ "('Compras','50000'),"
				+ "('Internacional','130000')");
		 
		lasQuerys.insertarDatos(basesDatos[1], "INSERT INTO empleados(dni, nombre, apellidos, departamento)"
				+ "VALUES ('11111111A','Juan', 'V�zquez', '1'),"
				+ "('22222222B','Carlos', 'Garcia', '1'),"
				+ "('33333333C','Victor', 'Serrano', '2'),"
				+ "('44444444D','Marc', 'Bennasar', '3'),"
				+ "('55555555E','Adri�n', 'Toro', '4')");
				
		 
		//Creamos las tablas del EJERCICIO 3.
		 
		lasQuerys.crearTabla(basesDatos[2], "almacenes"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  lugar varchar(100) NOT NULL,"
				+ "  capacidad int NOT NULL,"
				+ "  PRIMARY KEY (codigo))");
		 
		lasQuerys.crearTabla(basesDatos[2], "cajas"," (numreferencia char(5) NOT NULL,"
				+ "  contenido varchar(100) NOT NULL,"
				+ "  valor int NOT NULL,"
				+ "  almacen int NOT NULL,"
				+ "  PRIMARY KEY (numreferencia),"
				+ "	 FOREIGN KEY (almacen) REFERENCES almacenes(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");
		 
		 
		//Insertamos los datos del EJERCICIO 3.
		 
		lasQuerys.insertarDatos(basesDatos[2], "INSERT INTO almacenes(lugar,capacidad)"
				+ "VALUES ('Barcelona','400'),"
				+ "('Bilbao','300'),"
				+ "('Madrid','500'),"
				+ "('Valencia','700'),"
				+ "('Girona','400')");
		 
		lasQuerys.insertarDatos(basesDatos[2], "INSERT INTO cajas(numreferencia, contenido, valor, almacen)"
				+ "VALUES ('A1A1A','Tornillos', 4, 1),"
				+ "('B2B2B','Grapas', 6, 2),"
				+ "('C3C3C','Escuadras', 5, 2),"
				+ "('D4D4D','Bisagras', 9, 5),"
				+ "('E5E5E','Brocas', 100, 4)");
		
		
		//Creamos las tablas del EJERCICIO 4.
		
		lasQuerys.crearTabla(basesDatos[3], "peliculas"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  calificacionedad int DEFAULT NULL,"
				+ "  PRIMARY KEY (codigo))");
		
		lasQuerys.crearTabla(basesDatos[3], "salas"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  pelicula int DEFAULT NULL,"
				+ "  PRIMARY KEY (codigo),"
				+ "	 FOREIGN KEY (pelicula) REFERENCES peliculas(codigo) ON DELETE CASCADE ON UPDATE CASCADE)");
		
		
		//Insertamos los datos del EJERCICIO 4.
		
		lasQuerys.insertarDatos(basesDatos[3], "INSERT INTO peliculas(nombre,calificacionedad)"
				+ "VALUES ('Ironman','12'),"
				+ "('Dune','18'),"
				+ "('Los pitufos','7'),"
				+ "('Scott pilgrim','14'),"
				+ "('Anabelle','18')");
		
		lasQuerys.insertarDatos(basesDatos[3], "INSERT INTO salas(nombre,pelicula)"
				+ "VALUES ('Sala 1',1),"
				+ "('Sala 2',3),"
				+ "('Sala 3',4),"
				+ "('Sala 4',5),"
				+ "('Sala 12',2)");		
		
		
		//Creamos las tablas del EJERCICIO 5.
		
		lasQuerys.crearTabla(basesDatos[4], "despachos"," (numero smallint NOT NULL,"
				+ "  capacidad smallint NOT NULL,"
				+ "  PRIMARY KEY (numero))");
				
		lasQuerys.crearTabla(basesDatos[4], "directores","(dni varchar(8) NOT NULL,"
				+ "  nomapels varchar(255) NOT NULL,"
				+ "  dnijefe varchar(8) DEFAULT NULL,"
				+ "  despacho smallint DEFAULT NULL,"
				+ "  PRIMARY KEY (dni),"
				+ "  FOREIGN KEY (dnijefe) REFERENCES directores(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (despacho) REFERENCES despachos(numero) ON DELETE CASCADE ON UPDATE CASCADE);");		
		
		
		//Insertamos los datos del EJERCICIO 5.
		
		lasQuerys.insertarDatos(basesDatos[4], "INSERT INTO despachos(numero,capacidad)"
				+ "VALUES (11,50),"
				+ "(12,50),"
				+ "(21,50),"
				+ "(22,100),"
				+ "(23,1)");
		
		//Recordamos insertar primero un jefe para que los empleados puedan referenciar a su DNI
		lasQuerys.insertarDatos(basesDatos[4], "INSERT INTO directores(dni,nomapels,despacho)"
				+ "VALUES ('5555555E','Pedro Sánchez',23)");
		
		lasQuerys.insertarDatos(basesDatos[4], "INSERT INTO directores(dni,nomapels,dnijefe,despacho)"
				+ "VALUES ('1111111A','Alberto Jimenez','5555555E',11),"
				+ "('2222222B','Carlos Lafuente','5555555E',12),"
				+ "('3333333C','Oscar Vilamitjana','5555555E',21),"
				+ "('4444444D','Perico Palotes','5555555E',22)");
		
		
		//Creamos las tablas del EJERCICIO 6.
		
		lasQuerys.crearTabla(basesDatos[5], "proveedores"," (id char(4) NOT NULL,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  PRIMARY KEY (id))");
		
		lasQuerys.crearTabla(basesDatos[5], "piezas"," (codigo INT NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  PRIMARY KEY (codigo))");
				
		lasQuerys.crearTabla(basesDatos[5], "suministra","(codigopieza int NOT NULL,"
				+ "  idproveedor char(4) NOT NULL,"
				+ "  precio int NOT NULL,"
				+ "  PRIMARY KEY (codigopieza,idproveedor),"
				+ "  FOREIGN KEY (codigopieza) REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (idproveedor) REFERENCES proveedores(id) ON DELETE CASCADE ON UPDATE CASCADE);");	

		//Insertamos los datos del EJERCICIO 6.
		
		lasQuerys.insertarDatos(basesDatos[5], "INSERT INTO proveedores(id,nombre)"
				+ "VALUES ('A','Ferreteria Pepe'),"
				+ "('B','Leroy Merlin'),"
				+ "('C','Droguería Maria Luisa'),"
				+ "('D','Bauhaus'),"
				+ "('E','Piezas Paco')");	
	
		lasQuerys.insertarDatos(basesDatos[5], "INSERT INTO piezas(codigo,nombre)"
				+ "VALUES (1,'Tuerca'),"
				+ "(2,'Visagra'),"
				+ "(3,'Junta'),"
				+ "(4,'Tornillo'),"
				+ "(5,'Masilla')");		
		
		lasQuerys.insertarDatos(basesDatos[5], "INSERT INTO suministra(codigopieza,idproveedor,precio)"
				+ "VALUES (2,'A',5),"
				+ "(3,'C',10),"
				+ "(4,'D',1),"
				+ "(1,'B',1),"
				+ "(5,'E',4)");
		
		
		//EJERCICIO 7
		
		lasQuerys.crearTabla(basesDatos[6], "cientificos"," (dni VARCHAR(8) NOT NULL PRIMARY KEY,"
				+ " nomapels NVARCHAR(255) NOT NULL"
				+ " )");
				
		lasQuerys.crearTabla(basesDatos[6], "proyecto"," (id CHAR(4) NOT NULL PRIMARY KEY,"
				+ "  nombre VARCHAR(255) NOT NULL,"
				+ "  horas INT NOT NULL"
				+ "	)");
				
		lasQuerys.crearTabla(basesDatos[6], "asignadoa"," (cientifico VARCHAR(8) NOT NULL,"
				+ "  proyecto CHAR(4) NOT NULL,"
				+ "  FOREIGN KEY (cientifico) REFERENCES cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (proyecto) REFERENCES proyecto(id) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");

		
		//Insertamos los datos del EJERCICIO 7.
		
		lasQuerys.insertarDatos(basesDatos[6], "INSERT INTO cientificos(dni, nomapels)"
				+ "VALUES ('57962980', 'Juan'),"
				+ "('50322133', 'Kat'),"
				+ "('38104182', 'Moira'),"
				+ "('68529401', 'Miguel'),"
				+ "('93897470', 'Maria')");
				
		lasQuerys.insertarDatos(basesDatos[6], "INSERT INTO proyecto(id,nombre,horas)"
				+ "VALUES ('3981','Galaxy',1),"
				+ "('3982','Iphone',2),"
				+ "('3983','Edge',3),"
				+ "('3984','Qualcom',4),"
				+ "('3985','One Desire',5)");
				
		lasQuerys.insertarDatos(basesDatos[6], "INSERT INTO asignadoa(cientifico, proyecto)"
				+ "VALUES ('57962980','3981'),"
				+ "('50322133','3982'),"
				+ "('38104182','3983'),"
				+ "('68529401','3984'),"
				+ "('93897470','3985')");
			
		
		//EJERCICIO 8
		
		lasQuerys.crearTabla(basesDatos[7], "cajeros"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ " nomapels NVARCHAR(255) NOT NULL"
				+ " )");
				
		lasQuerys.crearTabla(basesDatos[7], "productos"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "  nombre VARCHAR(100) NOT NULL,"
				+ "  precio INT NOT NULL"
				+ "	)");
				
		lasQuerys.crearTabla(basesDatos[7], "maquinasregistradoras"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ "  piso INT NOT NULL"
				+ "	)");
		
		lasQuerys.crearTabla(basesDatos[7], "venta"," (cajero INT NOT NULL,"
				+ "  maquina INT NOT NULL,"
				+ "  producto INT NOT NULL,"
				+ "  PRIMARY KEY (cajero,maquina,producto),"
				+ "  FOREIGN KEY (cajero) REFERENCES cajeros(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (maquina) REFERENCES maquinasregistradoras(codigo) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (producto) REFERENCES productos(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");

		
		//Insertamos los datos del EJERCICIO 8.
		
		lasQuerys.insertarDatos(basesDatos[7], "INSERT INTO cajeros(nomapels)"
				+ "VALUES ('Juan'),"
				+ "('Kat'),"
				+ "('Moira'),"
				+ "('Miguel'),"
				+ "('Maria')");
				
		lasQuerys.insertarDatos(basesDatos[7], "INSERT INTO productos(nombre,precio)"
				+ "VALUES ('Chocolate',1),"
				+ "('Pasta',2),"
				+ "('Pizza',3),"
				+ "('Pan',4),"
				+ "('Leche',5)");
				
		lasQuerys.insertarDatos(basesDatos[7], "INSERT INTO maquinasregistradoras(piso)"
				+ "VALUES (1),"
				+ "(1),"
				+ "(2),"
				+ "(2),"
				+ "(3)");
		
		lasQuerys.insertarDatos(basesDatos[7], "INSERT INTO venta(cajero,maquina,producto)"
				+ "VALUES (1, 1, 1),"
				+ "(2, 2, 2),"
				+ "(3, 3, 3),"
				+ "(4, 4, 4),"
				+ "(5, 5, 5)");
		
		
		//EJERCICIO 9
		
		lasQuerys.crearTabla(basesDatos[8], "facultad"," (codigo INT AUTO_INCREMENT PRIMARY KEY,"
				+ " nombre NVARCHAR(100) NOT NULL"
				+ " )");
				
		lasQuerys.crearTabla(basesDatos[8], "investigadores"," (dni VARCHAR(8) PRIMARY KEY,"
				+ "  nomapels NVARCHAR(255) NOT NULL,"
				+ "  facultad INT NOT NULL,"
				+ "	 FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");
				
		lasQuerys.crearTabla(basesDatos[8], "equipos"," (numserie CHAR(4) PRIMARY KEY,"
				+ "  nombre NVARCHAR(100) NOT NULL,"
				+ "  facultad INT NOT NULL, "
				+ "  FOREIGN KEY (facultad) REFERENCES facultad(codigo) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");
				
		lasQuerys.crearTabla(basesDatos[8], "reserva"," (dni VARCHAR(8) NOT NULL,"
				+ "  numserie CHAR(4) NOT NULL,"
				+ "  comienzo DATE NOT NULL,"
				+ "  fin DATE NOT NULL,"
				+ "  PRIMARY KEY (dni,numserie),"
				+ "  FOREIGN KEY (dni) REFERENCES investigadores(dni) ON DELETE CASCADE ON UPDATE CASCADE,"
				+ "  FOREIGN KEY (numserie) REFERENCES equipos(numserie) ON DELETE CASCADE ON UPDATE CASCADE"
				+ "	)");
		
		
		//Insertamos los datos del EJERCICIO 9.
		
		lasQuerys.insertarDatos(basesDatos[8], "INSERT INTO facultad(nombre)"
				+ "VALUES ('Brown'),"
				+ "('Cenntenial'),"
				+ "('Jiao Tong'),"
				+ "('Copenhague'),"
				+ "('Kioto')");
						
		lasQuerys.insertarDatos(basesDatos[8], "INSERT INTO investigadores(dni, nomapels, facultad)"
				+ "VALUES ('27381476', 'Juan',1),"
				+ "('27381475','Kat',2),"
				+ "('27381474','Moira',3),"
				+ "('27381473','Miguel',4),"
				+ "('27381472','Maria',5)");
						
		lasQuerys.insertarDatos(basesDatos[8], "INSERT INTO equipos(numserie, nombre, facultad)"
				+ "VALUES ('4823','T',1),"
				+ "('1862','E',2),"
				+ "('9541','A',3),"
				+ "('0560','M',4),"
				+ "('4381','5',5)");
				
		lasQuerys.insertarDatos(basesDatos[8], "INSERT INTO reserva(dni, numserie, comienzo, fin)"
				+ "VALUES ('27381476','4823', '2022-01-01','2022-02-01'),"
				+ "('27381475','1862', '2022-02-02','2022-03-02'),"
				+ "('27381474','9541', '2022-03-03','2022-04-03'),"
				+ "('27381473','0560', '2022-04-04','2022-05-04'),"
				+ "('27381472','4381', '2022-05-05','2022-06-05')");
		
		lasQuerys.cerrarCon();
		
	}
	
}
