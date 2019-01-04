package main;

import control.Controller;
import model.Model;
import view.ConsoleView;

public class StartOfEverything {

	public static void main(String[] args) {
		
		Model model	=	new Model();
		ConsoleView	consoleView = new ConsoleView("TerminListe 1.0");
		Controller controller	= new Controller(model, consoleView);
		controller.initController();
	}

}
