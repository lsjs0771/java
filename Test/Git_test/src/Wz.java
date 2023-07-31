
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Wz{
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("hello nanning");
        String s="/home/wjs/12.png";
        File file=new File(s);
        String name=file.getName();

        FileInputStream fileInputStream=new FileInputStream(file);
        byte[] b=new byte[fileInputStream.available()];
        fileInputStream.read(b);

        ServerSocket serverSocket=new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeUTF(name);
        objectOutputStream.flush();
        objectOutputStream.writeObject(b);
        objectOutputStream.flush();
        socket.close();
        fileInputStream.close();
    }
}