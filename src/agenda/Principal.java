package agenda;

import agenda.gui.AgendaFrame;

public class Principal {

	public static void main(String[] args) {

		Principal p = new Principal();
		p.iniciarTela();

	}

	private void iniciarTela() {
		AgendaFrame frame = new AgendaFrame();
		frame.setVisible(true);
	}

}
