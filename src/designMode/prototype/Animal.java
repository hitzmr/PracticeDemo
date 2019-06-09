package designMode.prototype;

public abstract class Animal implements Cloneable{
	public abstract void tell();

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	
}
