package designMode.strategyMode;

public class Context {
	// ����һ��������ԵĶ���
	private Strategy strategy;

	/**
	 * ���캯��������һ��������Զ���
	 * @param strategy
	 *            ������Զ���
	 */
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * ���Է���
	 */
	public void contextInterface() {
		strategy.algorithmInterface();
	}
}