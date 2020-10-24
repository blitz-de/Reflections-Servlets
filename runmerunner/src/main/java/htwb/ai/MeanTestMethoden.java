package htwb.ai;

// -- Import Annotations

//-- Import Reflections

public class MeanTestMethoden {

	// Nur RunMe Methoden sollten vom Terminal ausgefuehrt.. Wie!!
	/*Answer: Man kann es ueber die Verwendung von classpath scanning machen
	 *  Grundsätzlich geht man jede Methode jeder Klasse im Klassenpfad durch 
	 *  und erhaltet alle Anmerkungen mit Ihrer angegebenen Anmerkung. 
	 *  Danach ruft man die gefundenen Methoden auf.
	 *  --> die Methode runAllAnnotatedWith() kann diese Aufgabe erledigen mit der Verwendung von Reflections
	 *  Q: <https://stackoverflow.com/questions/16996033/how-to-run-all-methods-with-a-given-annotation>
	 */
	@RunMe(name = "methode1")
	public void findMeRunMe1() {
		
	}
	
	@RunMe(name = "methode2")
	public void findMeRunMe2() {
		
	}
	
	@RunMe(name = "methode3")
	public void findMeRunMe3() {
		
	}
	
	public void findMeOhneRM1() {
		
	}
	
	public void findMeOhneRM2() {
		
	}

	private void findMePrivate1() {
		//System.out.println("private method");
	}
	
	private void findMePrivate2() {
	}
}
