package designMode.strategyMode;

public class Client {
	public static void main(String[] args){
		Strategy s = new ConcreteStrategyA();
		Context context = new Context(s);
		context.contextInterface();
	}

}
