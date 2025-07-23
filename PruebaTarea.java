package pruebasG;

import java.io.*;
import java.util.Scanner;

public class PruebaTarea {

public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	System.out.println("¿desea Usar la Lista de tareas?");
	String respuesta = sc.nextLine();
	GestionadorTareas gt = new GestionadorTareas();
	
	
	while(respuesta.equalsIgnoreCase("si")) {
		System.out.println("1- ver Lista de tareas");
		System.out.println("2-Agregar Tarea");
		System.out.println("3-Completar tarea");
		System.out.println("4-Salir");
		
		int eleccion = sc.nextInt();
		sc.nextLine();
		switch(eleccion) {
		case 1: gt.mostrarTareas();
		;
		break;
		case 2:
			System.out.println("coloque la descripcion de la tarea");
			String descripcion = sc.nextLine();
			gt.agregarTarea(new Tarea(descripcion,false));
			break;
		case 3:
			System.out.println("coloque el id de la tarea completada");
			int id = sc.nextInt();
			sc.nextLine();
			gt.completarTarea(id);
			break;
		case 4: respuesta= "No";
			break;
		}
		
		
	}
}
}
