package UD18;

public class MainApp {
	
	public static void main(String[] args) {
		LasQuerys lasQuerys = new LasQuerys();
		String[] basesDatos = new String[9];
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
		lasQuerys.crearTabla(basesDatos[0], "fabricantes"," (codigo INT NOT NULL AUTO_INCREMENT,"
				+ " nombre VARCHAR(100) DEFAULT NULL,"
				+ " PRIMARY KEY (codigo))");
		lasQuerys.crearTabla(basesDatos[0], "articulos"," (codigo int NOT NULL AUTO_INCREMENT,"
				+ "  nombre varchar(100) NOT NULL,"
				+ "  precio int NOT NULL,"
				+ "  fabricante int NOT NULL,"
				+ "  PRIMARY KEY (codigo),"
				+ "	 FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE CASCADE ON UPDATE CASCADE) ");
		
		
		lasQuerys.insertarDatos(basesDatos[0], "INSERT INTO fabricantes(nombre) VALUES ('Samsung'),"
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
		
		//lasQuerys.crearTabla(basesDatos[1], "empleados","");
		lasQuerys.cerrarCon();
	}
	

	
}
