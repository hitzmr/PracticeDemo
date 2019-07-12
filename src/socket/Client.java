package socket;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9081);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        bufferedWriter.write("Hi server!\n");
        bufferedWriter.flush();
        bufferedWriter.write("This is Client!\n");
        bufferedWriter.flush();
//        bufferedWriter.close();


        String line = null;
        while((line = bufferedReader.readLine()) != null){
            System.out.println("Get message from server: " + line);
        }
//            System.out.println("Get message from server: " + bufferedReader.readLine());
//            System.out.println("Get message from server: " + bufferedReader.readLine());

//        bufferedReader.close();


    }

}
