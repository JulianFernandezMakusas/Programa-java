package com.utn.vista;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import com.sun.javafx.collections.MappingChange.Map;

import jdk.nashorn.internal.scripts.JO;

public class Main {

	public static void main(String[] args) {
		boolean datosAlumnoBoolean = true;
		boolean datosProfesorBoolean = true;
		Persona profesor = null;
		Persona alumno = null;
		int dni = 0;
		String dniS;
		TreeMap<Integer, Persona> listaProfesores = new TreeMap<Integer, Persona>();
		TreeMap<Integer, Persona> listaAlumnos = new TreeMap<Integer, Persona>();
		

		Path bDniAlumn = Paths
				.get("C:\\Users\\Raul\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Alumno.ser");
		Path bDniProf = Paths
				.get("C:\\Users\\Raul\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Profesor.ser");
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
		while (datosAlumnoBoolean = true) {
			try {
				try {
					ObjectInputStream datosAlumno = new ObjectInputStream(Files.newInputStream(bDniAlumn));
					alumno = (Alumno) datosAlumno.readObject();
					listaAlumnos.put(alumno.getDni(), alumno);
				} catch (ClassNotFoundException e) {

				}
			} catch (IOException e) {
				e.printStackTrace();
				datosAlumnoBoolean = false;
			}
			while (datosProfesorBoolean = true) {
				try {
					ObjectInputStream datosProfesor = new ObjectInputStream(Files.newInputStream(bDniProf));
					try {
						profesor = (Profesor) datosProfesor.readObject();
						listaProfesores.put(profesor.getDni(), profesor);
					} catch (ClassNotFoundException e) {

					}
				} catch (IOException e) {
					datosProfesorBoolean = false;
				}
			}
		}
		int optionType = 0;
		String[] options = {"Alumnos","Profesores"};
		JOptionPane.showMessageDialog(null, "Bienvenido");
		int seleccion = JOptionPane.showOptionDialog(null, "Ingrese la categoria en la que desea buscar: ", "Programa", optionType, 0, null, options, 0);
		
		switch (seleccion) {
		case 0://alumnos
			dniS = JOptionPane.showInputDialog("Ingrese el DNI que desea encontrar");
			dni = Integer.parseInt(dniS);			
			for (int i = 0; i < listaAlumnos.size(); i++) {
				if (listaAlumnos.equals(dni)) {
						JOptionPane.showMessageDialog(null, listaAlumnos.get(i));
				}else {
					System.out.println("no hay nada");
				}
			}
			break;
		case 1://profesores
			dniS = JOptionPane.showInputDialog("Ingrese el DNI que desea encontrar");
			dni = Integer.parseInt(dniS);
			for (int i = 0; i < listaProfesores.size(); i++) {
				
			}
			break;
		}
		
	}
}
