import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ONode {
    public ONode(String ip) {
        try {
            ServerSocket server = new ServerSocket(5000);
            Socket socket = server.accept();
            Socket socketR = new Socket(ip, 5000);
            DataInputStream in = new DataInputStream(socketR.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
                System.out.println("Server: " + str);
                out.writeUTF(str);
                out.flush();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ONode oNode = new ONode(args[0]);
    }
}
