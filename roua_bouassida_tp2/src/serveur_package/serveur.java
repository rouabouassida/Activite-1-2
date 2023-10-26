package serveur_package;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class serveur {
public static void main (String[] args) {
try {
ServerSocket serverSocket = new ServerSocket(1234);
System.out.println("I am a serveur waiting for a client connexion...");
Socket socket = serverSocket.accept();
InputStream inputStream = socket.getInputStream();
OutputStream outputStream = socket.getOutputStream();
System.out.println("Waiting for a number 1... ");
int nb = inputStream.read();
System.out.println("Data received : " + nb);
System.out.println("Waiting for a number 2... ");
int nb1 = inputStream.read();
System.out.println("Data received : " + nb1);
int choice = inputStream.read();
int rep;
switch (choice) {
case 1:
System.out.println("The client selected Addition operation");
rep = nb1 + nb;
outputStream.write(rep);
break;
case 2:
System.out.println("The client selected Soustraction operation");

rep = nb - nb1;
outputStream.write(rep);
break;
case 3:
System.out.println("The client selected Multiplication operation");
rep = nb * nb1;
outputStream.write(rep);
break;
case 4:
System.out.println("The client selected Division operation");
rep = nb / nb1;
outputStream.write(rep);
break;
default:
System.out.println("Return to Client.");
}

System.out.println("Closing the socket...");
socket.close();
serverSocket.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}