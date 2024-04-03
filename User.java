import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

    }
}
