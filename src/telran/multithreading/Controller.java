package telran.multithreading;

import java.util.ArrayList;



public class Controller {
	private static final int N_NUMBERS = 100;
	private static final int N_PORTIONS = 10;
	private static final int N_PRINTERS = 4;


	public static void main(String[] args) {

		
		ArrayList<Printer> printersList = new ArrayList<>();
		for(int i = 1; i<= N_PRINTERS; i++) {
			printersList.add(new Printer(i, N_NUMBERS, N_PORTIONS));
			}
		for(int i = 0; i< N_PRINTERS-1; i++) {
				printersList.get(i).setNext(printersList.get(i+1));
			} 
		printersList.get(N_PRINTERS-1).setNext(printersList.get(0));
		printersList.forEach(p -> p.start());
		printersList.get(0).interrupt();

	}

	
}
