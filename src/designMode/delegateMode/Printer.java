package designMode.delegateMode;

public class Printer {
	public void print(){
		RealPrinter printer = new RealPrinter();
		printer.print();
	}

}
