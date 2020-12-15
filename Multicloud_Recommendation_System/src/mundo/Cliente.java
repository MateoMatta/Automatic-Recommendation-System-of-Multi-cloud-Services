package mundo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Cliente {

	private String sector;
	private ServicioCloud[] serviciosSeleccionados;
	private Pilar[] topDePilaresDelCliente;

	public Cliente(Pilar[] pilaresEvaluadosDelCliente, ServicioCloud[] serviciosEvaluados, String sectorEvaluado) {
		super();

		topDePilaresDelCliente = new Pilar[ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION.length];
		topDePilaresDelCliente = pilaresEvaluadosDelCliente;
		
		serviciosSeleccionados = serviciosEvaluados;
		
		sector = sectorEvaluado;

		// VALORES QUEMADOS DEL
		// CLIENTE------------------------------------------------------------------
		// Terminar algoritmo
		// ---------------------------------------------------------------------------
		// preguntasDePerfilacionDePilares()
		ordenarElTopDePilares();
	}
	
	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public ServicioCloud[] getServiciosSeleccionados() {
		return serviciosSeleccionados;
	}

	public void setServiciosSeleccionados(ServicioCloud[] serviciosSeleccionados) {
		this.serviciosSeleccionados = serviciosSeleccionados;
	}

	public Pilar[] getTopDePilaresDelCliente() {
		return topDePilaresDelCliente;
	}

	public void setTopDePilaresDelCliente(Pilar[] topDePilaresDelCliente) {
		this.topDePilaresDelCliente = topDePilaresDelCliente;
	}

	public void preguntasDePerfilacionDePilares() {
		// METODO DE PREGUNTAS | TERMINAR
		// ---------------------------------------------------------
	}

	public void ordenarElTopDePilares() {
		Pilar temp;

		for (int i = 0; i < topDePilaresDelCliente.length; i++) {
			for (int j = i + 1; j < topDePilaresDelCliente.length; j++) {
				if (topDePilaresDelCliente[i].getValorDelPilar() < topDePilaresDelCliente[j].getValorDelPilar()) {
					temp = topDePilaresDelCliente[i];
					topDePilaresDelCliente[i] = topDePilaresDelCliente[j];
					topDePilaresDelCliente[j] = temp;
				}
			}
		}
	}

}
