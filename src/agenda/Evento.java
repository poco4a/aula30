package agenda;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import agenda.utils.PeriodicidadeEnum;

public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date dataEvento;

	private String descEvento;
	private PeriodicidadeEnum periodicidade;
	private String emailEncaminhar;
	private int alarme;

	public Evento() {
		super();
	}

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescEvento() {
		return descEvento;
	}

	public void setDescEvento(String descEvento) {
		this.descEvento = descEvento;
	}

	public PeriodicidadeEnum getPeriodicidade() {
		return periodicidade;
	}

	public void setPeriodicidade(PeriodicidadeEnum periodicidade) {
		this.periodicidade = periodicidade;
	}

	public String getEmailEncaminhar() {
		return emailEncaminhar;
	}

	public void setEmailEncaminhar(String emailEncaminhar) {
		this.emailEncaminhar = emailEncaminhar;
	}

	public int getAlarme() {
		return alarme;
	}

	public void setAlarme(int alarme) {
		this.alarme = alarme;
	}

	public String toString() {
		SimpleDateFormat formatarData = new SimpleDateFormat("dd-MM-yyyy");
		return (formatarData.format(getDataEvento()) + "|" + getDescEvento()
				+ "|" + getPeriodicidade() + "|" + getEmailEncaminhar() + "|" + getAlarme());
	}
}
