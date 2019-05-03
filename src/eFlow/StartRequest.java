package eFlow;

import java.io.IOException;
import java.util.List;

public class StartRequest {

	// Use this to auto raise HR-04
	public static void main(String[] args) throws InterruptedException {
		List<String> OTDays = CheckOTDays.getOTDays();
		AutoHR04.raiseRequest(OTDays);
	}

	public static void killProcess() {
		String command = "taskkill /f /im EvernoteSubprocess.exe";
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Kill process success");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
