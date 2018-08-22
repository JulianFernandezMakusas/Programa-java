package com.utn.vista;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

public class Main {

	public static void main(String[] args) {
		Alumno alumno2 = null;
		Profesor profesor2 = null;
		int casos = 0;
		int siNo2 = 0;
		String nombre;
		String apellido;
		String dni;
		int dni2;
		String[] siNo = { "Si", "No" };
		String[] opciones = { "Profesor", "Alumno" };
		String nLegajo;
		int nLegajo2;
		String nPadron;
		int nPadron2;
		ArrayList<Persona> lista = new ArrayList<Persona>();
		Persona p;
		Persona profesor = null;
		Persona alumno = null;
		String lines = " ";
		Path alumn = Paths
				.get("C:\\Users\\Raul\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Alumno.ser");
		Path prof = Paths
				.get("C:\\Users\\Raul\\Desktop\\Padron de profesores Legajos de alumnos2.0\\Datos_Profesor.ser");
		JOptionPane.showMessageDialog(null, "Bienvenido", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
		int archivos = JOptionPane.showConfirmDialog(null, "¿Desea crear archivos?");
		if (archivos == 0) {
			try {
				Files.createFile(alumn);
				Files.createFile(prof);
			} catch (IOException e) {
				System.out.println("Error: " + e);
			}
		} else if (archivos == 1) {
			JOptionPane.showMessageDialog(null, "OK");
		}
		ObjectOutputStream lAlumno = null;
		ObjectOutputStream lProfesor = null;
		try {
			lAlumno = new ObjectOutputStream(Files.newOutputStream(alumn));
			lProfesor = new ObjectOutputStream(Files.newOutputStream(prof));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		while (JOptionPane.showOptionDialog(null, "¿Desea ingresar informaciòn?", "Informacion", siNo2,
				JOptionPane.INFORMATION_MESSAGE, null, siNo, 0) == 0) {
			int seleccion = JOptionPane.showOptionDialog(null, "Selecione una opcion", "Informaciòn", casos,
					JOptionPane.INFORMATION_MESSAGE, null, opciones, 0);
			try {
				switch (seleccion) {
				// profesor
				case 0:
					nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre", "Informaciòn", 1);
					apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido", "Informaciòn", 1);
					dni = JOptionPane.showInputDialog(null, "Ingrese su DNI", "Informaciòn", 1);
					dni2 = Integer.parseInt(dni);
					nPadron = JOptionPane.showInputDialog(null, "Ingrese su numero de padron", "Informaciòn", 1);
					nPadron2 = Integer.parseInt(nPadron);
					profesor = new Profesor(nombre, apellido, dni2, nPadron2);
					if (lista.isEmpty() == true) {
						lista.add(profesor);
					} else {
						for (int i = 0; i < lista.size(); i++) {
							p = lista.get(i);
							if (profesor.equals(p)) {
								JOptionPane.showMessageDialog(null, "Error: duplicado", "Programa", 0);
							}
						}
					}
					lista.add(profesor);
					System.out.println(profesor.hashCode());
					ObjectOutputStream iProfesor = new ObjectOutputStream(Files.newOutputStream(prof));
					lProfesor.writeObject(profesor2);
					break;
				// alumno
				case 1:
					nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre", "Informaciòn", 1);
					apellido = JOptionPane.showInputDialog(null, "Ingrese su apellido", "Informaciòn", 1);
					dni = JOptionPane.showInputDialog(null, "Ingrese su DNI", "Informaciòn", 1);
					dni2 = Integer.parseInt(dni);
					nLegajo = JOptionPane.showInputDialog(null, "Ingrese su numero de legajo", "Informaciòn", 1);
					nLegajo2 = Integer.parseInt(nLegajo);
					alumno = new Alumno(nombre, apellido, dni2, nLegajo2);
					if (lista.isEmpty() == true) {
						lista.add(alumno);
					} else {
						for (int i = 0; i < lista.size(); i++) {
							p = lista.get(i);
							if (alumno.equals(p)) {
								JOptionPane.showMessageDialog(null, "Error: duplicado", "Programa", 0);
								break;
							}
						}
					}
					lista.add(alumno);
					System.out.println(alumno.hashCode());
					ObjectOutputStream iAlumno = new ObjectOutputStream(Files.newOutputStream(alumn));
					lAlumno.writeObject(alumno2);
					break;
				default:
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error, el programa se cerrara.");
			}
		}
		try {
			ObjectInputStream in = new ObjectInputStream(Files.newInputStream(prof));
			try {
				while (true) {
					profesor2 = (Profesor) in.readObject();
					JOptionPane.showMessageDialog(null, profesor.getNombre());
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			System.out.println("Hola mundo");
		}
		try {
			ObjectInputStream in = new ObjectInputStream(Files.newInputStream(alumn));
			while (true) {
				try {
					alumno2 = (Alumno) in.readObject();					
					JOptionPane.showMessageDialog(null, alumno.getNombre());
				} catch ( ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			System.out.println("Hola mundo");
		}
	}
}
