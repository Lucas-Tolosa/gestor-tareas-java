package pruebasG;

import java.io.*;
import java.util.ArrayList;

import pruebasG.Tarea;

public class GestionadorTareas {
 public GestionadorTareas() {
 }
 public void agregarTarea(Tarea t1) {
	 this.tareas.add(t1);
 }
 public void mostrarTareas() {
	 
	  for(int x = 0; x<this.tareas.size(); x++) {
		 System.out.println(tareas.get(x).toString());
	 }
	 
	
 }
 public void completarTarea(int numTarea) {
	 for(int x = 0; x<this.tareas.size(); x++) {
		 if( tareas.get(x).getId()==(numTarea)) {
			 tareas.get(x).setCompletado(true);
		 }
	 }
	 
 }
 
 
 
 private ArrayList<Tarea> tareas = new ArrayList<Tarea>();
}

