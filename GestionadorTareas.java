package pruebasG;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionadorTareas{
 public GestionadorTareas() {
	this.verificar();
	this.iniciar();
 }
 
 private void iniciar() {
	 while(respuesta) {
			System.out.println("1- ver Lista de tareas");
			System.out.println("2-Agregar Tarea");
			System.out.println("3-Completar tarea");
			System.out.println("4-Salir");
			
			int eleccion = sc.nextInt();
			sc.nextLine();
			switch(eleccion) {
			case 1: this.mostrarTareas();
			break;
			
			case 2:
				System.out.println("coloque la descripcion de la tarea");
				String descripcion = sc.nextLine();
				this.agregarTarea(descripcion);
				break;
				
			case 3:
				System.out.println("coloque el id de la tarea completada");
				int id = sc.nextInt();
				sc.nextLine();
				this.completarTarea(id);
				break;
				
			case 4: respuesta= false;
				break;
				
			default:
				System.out.println("Caracter no reconocido");
			}		
		}
 }
 
 //verificamos si en el archivo hay alguna tarea guardada y los anotamos en un arraylist
 private void verificar() {
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("C:/Users/Lucas/Desktop/ListaTareas.in")));
			
			String linea = bf.readLine();
			int maxNum=0;
			if(linea==null) {
				GestionadorTareas.id = maxNum;
			}else while(linea!=null) {
				
				String desc = bf.readLine();
				bf.readLine();
				boolean c = Boolean.parseBoolean(bf.readLine());
				bf.readLine();
				maxNum = Integer.parseInt(linea);
				this.tareas.add(new Tarea (maxNum,desc,c));
				
				linea = bf.readLine();
			}
			GestionadorTareas.id =maxNum+1;
			bf.close();
			
			
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		
}
		
	private void anotador(Tarea ta) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/Users/Lucas/Desktop/ListaTareas.in"),true));
			bw.write(ta.toString());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
 public void agregarTarea(String descripcion) {
	 Tarea t = new Tarea(GestionadorTareas.id,descripcion,false );
	 this.tareas.add(t);
	 this.anotador(t);
	 GestionadorTareas.id++;
 }
 public void mostrarTareas() {
	for(Tarea e: this.tareas ) {
		System.out.println(e.toString());
	}
	 }

 public void completarTarea(int id) {
	 try {
		this.tareas.get(id-1).setCompletado(true);
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:/Users/Lucas/Desktop/ListaTareas.in")));
		
		for(int x = 0; x<this.tareas.size(); x++) {
		bw.write( this.tareas.get(x).toString());	
		}
		bw.close();
	 } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch(IndexOutOfBoundsException e) {
		e.printStackTrace();
	}
		
	 
 }
 
 private static int id ;
 private Scanner sc = new Scanner(System.in);
 private boolean respuesta = true;

 private ArrayList<Tarea> tareas = new ArrayList<Tarea>();
}

