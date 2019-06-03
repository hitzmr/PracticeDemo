package designMode.abstractFactoryMode;

public class Bmw430Factory extends AbstractFactory{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new EngineA();
	}

	@Override
	public AirCondition createAirCondition() {
		return new AirConditionA();
	}
	

}
