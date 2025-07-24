package pruebasG;

import java.io.*;

public class Tarea {

	public Tarea(int id,String descripcion, boolean completado) {
		this.id = id;
		this.descripcion = descripcion;
		this.completado = completado;
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public boolean isCompletado() {
		return completado;
	}
	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	@Override
	public String toString() {
		return  this.getId()+"\n" + this.getDescripcion() + "\nCompletado:\n" + this.isCompletado()+"\n-----\n";
		
	}

	private String descripcion;
	private boolean completado;
	private int id;
	
}
