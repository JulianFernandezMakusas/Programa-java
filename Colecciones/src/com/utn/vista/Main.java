package com.utn.vista;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException {
		boolean salir = false;
		Persona profesor = null;
		Persona alumno = null;
		int dni;
		String dniS;
		Map<Integer, Persona> listaDeProfesores = new TreeMap<>();
		Map<Integer, Persona> listaDeAlumnos = new TreeMap<>();

		Path bDniAlumn = Paths
				.get("C:\\Users\\Java\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Alumno.ser");
		Path bDniProf = Paths
				.get("C:\\Users\\Java\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Profesor.ser");
		ObjectInputStream datosProfesor = null;
		ObjectInputStream datosAlumno = null;
		try {
			datosAlumno = new ObjectInputStream(Files.newInputStream(bDniAlumn));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			datosProfesor = new ObjectInputStream(Files.newInputStream(bDniProf));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (Files.exists(bDniProf) == false) {
			System.out.println("No se cargaron profesores");
		} else {
			System.out.println("Abriendo archivo de Profesores");
		}
		if (Files.exists(bDniAlumn) == false) {
			System.out.println("No se cargaron alumnos");
		} else {
			System.out.println("Abriendo archivo de Alumnos");
		}
		try {
		while (true) {
					alumno = (Alumno) datosAlumno.readObject();
					int dniAlumno = alumno.getDni();
					listaDeAlumnos.put(dniAlumno, alumno);
		}		
			} catch (EOFException | ClassNotFoundException e) {		
				System.out.println(e.getCause());
			}	
	
		try {
		while (true) {
				profesor = (Profesor) datosProfesor.readObject();
				int dniProfesor = profesor.getDni();
				listaDeProfesores.put(dniProfesor, profesor);
			} 
		}catch (EOFException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		dniS = JOptionPane.showInputDialog("Ingrese el DNI que desea buscar: ");
		dni = Integer.parseInt(dniS);
		if (alumno instanceof Persona) {
			JOptionPane.showMessageDialog(null, listaDeAlumnos.get(dni), "Programa", 0);			
		}if (profesor instanceof Persona) {
			JOptionPane.showMessageDialog(null, listaDeProfesores.get(dni), "Programa", 0);
		}
		
		
	}
}