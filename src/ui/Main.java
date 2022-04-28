package ui;

import java.util.Scanner;

import structures.CircularDoubleLinkedList;

public class Main {

	private static Scanner lector = new Scanner(System.in);
	private static CircularDoubleLinkedList<Integer> turnos = new CircularDoubleLinkedList<>();
	private final static int AVAILABLE_TURNS =50;

	public static void main(String[] args) {
		boolean continuar = true;
		do {
			System.out.println("Select the option to perform.");
			System.out.println("1. Run the program.");
			System.out.println("2. Run the example/escenary.");
			int option = lector.nextInt();
			switch(option) {
				case 1: run1();
					break;
				default: run2();
			}
		}while(continuar == true);
		
	}
	
	public static void showMenu() {
		System.out.println("Selecciona la opcion que quieras realizar.");
		System.out.println("1. Dar turno");
		System.out.println("2. Mostrar turno");
		System.out.println("3. Pasar turno");
		System.out.println("4. Eliminar turno");
		System.out.println("5. Exit");
	}
	
	public static void run1() {
		boolean continuar = true;
		int contador = 1;
		while(continuar == true) {
			showMenu();
			int option = lector.nextInt();
			switch(option) {
				case 1: if(contador <50) {
							turnos.add(contador);
							contador++;
						}else {
							System.out.println("Se ha sobrepasado la cantidad de turnos permitida ("+AVAILABLE_TURNS+").");
						}
					break;
				case 2: System.out.println(turnos.showActualTurn());
					break;
				case 3: turnos.passTurn();
					break;
				case 4: turnos.remove(1);
					break;
				case 5: continuar = false;
					break;
			}
		}
	}
	
	public static void run2() {
		int initialTurns = 6;
		int contador = 1;
		for(int i=0;i<initialTurns;i++) {
			turnos.add(contador);
			contador++;
		}
		turnos.showActualTurn();
		turnos.removeActualTurn();
		turnos.showActualTurn();
		turnos.passTurn();
		turnos.showActualTurn();
		for(int i=0;i<3;i++) {
			turnos.passTurn();
		}
		turnos.showActualTurn();
		turnos.removeActualTurn();
		turnos.showActualTurn();
	}
	
	
}
