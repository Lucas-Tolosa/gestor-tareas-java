package pruebasG;

import java.io.*;

public class Tarea {

	public Tarea(String descripcion,boolean completado) {
		this.descripcion = descripcion;
		this.completado = completado;
		Tarea.id++;
		this.tareaId=Tarea.id;
		
		
	}
	public void corroborarId() {
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(new File("C:/Users/Lucas/Desktop/ListaTareas.in")));
			int max = 0;
			String linea = bf.readLine();
			while(linea!=null) {
				int proxLn = Integer.parseInt(linea);
				bf.readLine();
				bf.readLine();
				if(proxLn>=max) {
					max= proxLn;
				}
				linea= bf.readLine();
			}
			Tarea.id = max+1;
			bf.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
		}
		
	public int getId() {
		return this.tareaId;
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
		return this.getId() + "\n" + this.getDescripcion() + "\n Completado:" + this.isCompletado()+"\n--";
		
	}

	private static int id = 0;
	private int tareaId;
	private String descripcion;
	private boolean completado;
	
	
}
