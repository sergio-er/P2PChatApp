import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class User {
    public static void main(String[] arg) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(">Enter username & port # for this user:");
        String[] setupValues = bufferedReader.readLine().split(" "); //we want to automate this with an online server

        ServerThread serverThread = new ServerThread(setupValues[1]);
        serverThread.start();
        new User().updateListenToPeers(bufferedReader, setupValues[0], serverThread);

    }
    public void updateListenToPeers(BufferedReader bufferedReader, String username, ServerThread serverThread) throws Exception{
        System.out.println(">Enter (space separated) hostname:port#");
        System.out.println(" peer to receive messages from (s to skip):");
        String input = bufferedReader.readLine();
        String[] inputValues = input.split(" ");

        if (!input.equals("s")) for (int i = 0; i< inputValues.length; i++){
            String[] address = inputValues[i].split(":");
            Socket socket = null;
            try {
                socket = new Socket(address[0], Integer.valueOf(address[1]));
                new PeerThread(socket).start();
            } catch (Exception e) {
                if (socket !=null) socket.close();
                else System.out.println("Invalid input. Skipping to next step.");//change on later implementation
            }
        }
        communicate(bufferedReader,username,serverThread);
    }

    public void communicate(BufferedReader bufferedReader, String username, ServerThread serverThread){

    }
}
