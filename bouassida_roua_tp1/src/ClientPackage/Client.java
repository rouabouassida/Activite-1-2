package ClientPackage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
public class Client {
public static void main (String[] args) throws IOException{
try {
//création de l’objet socket coté client 
Socket socket=new Socket("localhost",1234) ;
System.out.println("je suis un client connecté") ;
InputStream is = socket.getInputStream() ;
OutputStream os =socket.getOutputStream();
//donner la main pour donner un nombre
Scanner scanner= new Scanner (System.in) ;
System.out.println("donner un nombre=") ;
int nb= scanner.nextInt() ;
//envoyer le nombre donner au serveur
os.write(nb) ;
//lire la résultat donner d’après le serveur
int rep=is.read() ;
System.out.println("reponse="+rep) ;
}
catch (IOException e) {
e.printStackTrace() ;
}
InputStream socket = null ;
socket.close() ;
}}