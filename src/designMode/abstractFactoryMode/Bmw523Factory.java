package designMode.abstractFactoryMode;

public class Bmw523Factory extends AbstractFactory{

	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new EngineB();
	}

	@Override
	public AirCondition createAirCondition() {
		return new AirConditionB();
	}
	

}
