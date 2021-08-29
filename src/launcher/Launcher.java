package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	String rutaFoto= this.getClass().getResource("/images/mifoto.jpeg").toString();
            	Student estudiante= new Student(111106,"Martinez Ocampo","Brenda Belen","brenh_97@hotmail.com","https://github.com/BrendaMartinez103",rutaFoto);
            	SimplePresentationScreen gui=new SimplePresentationScreen(estudiante);
            	gui.setVisible(true);
            }
        });
    }
}