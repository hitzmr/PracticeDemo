package killProcess;

import java.io.IOException;

public class KillProcessDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		String command = "taskkill /f /im chromedriver.exe";  
		String command = "taskkill /f /im EvernoteSubprocess.exe";  
		Runtime.getRuntime().exec(command);
	}

}
