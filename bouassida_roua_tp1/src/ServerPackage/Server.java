package ServerPackage;

import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
public class Server{
public static void main (String [] args){
//création de l’objet ServerSocket
	try {
 ServerSocket ss =new ServerSocket(1234) ;
//un serveur pas encore connecter
 System.out.println("je suis un serveur en attente la connexion d’un client") ;
//attendre la connexion d’un client
Socket s= ss.accept() ;
InputStream is= s.getInputStream() ;
OutputStream os= s.getOutputStream();
System.out.println("j’attends un nombre") ;
//lire le nombre donner par le client
int nb= is.read() ;
//calculer la résultat
int res= nb*5 ;
//envoyer la resultat au client
os.write(res) ;
//fermeture de la socket
s.close() ;
	}catch (IOException e) {
		e.printStackTrace() ;
	}
}}