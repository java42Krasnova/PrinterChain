package telran.multithreading;

public class Printer extends Thread {

	private Printer next;
	private int countOfSymbols;
	private int portionSize;
	private int printerNumner;

	public Printer(int printerNumner, int countOfSymbols, int portionSize) {
		this.printerNumner = printerNumner;
		this.countOfSymbols = countOfSymbols;
		this.portionSize = portionSize;
	}

	public void setNext(Printer next) {
		this.next = next;
	}

	@Override
	public void run() {
		int countOfRepeats = countOfSymbols / portionSize;
		int currentRepeat = 1;
		while (currentRepeat <= countOfRepeats) {
			try {
				// V.R. Why it is hard coded? Generally it isn't recommended
				sleep(7000);
			} catch (InterruptedException e) {
				System.out.println(("" + printerNumner).repeat(portionSize));
				if (printerNumner == 4) {
					System.out.println("+++++++++++++++++" + currentRepeat);
				}
				currentRepeat++;
				next.interrupt();
			}
		}
	}
}
