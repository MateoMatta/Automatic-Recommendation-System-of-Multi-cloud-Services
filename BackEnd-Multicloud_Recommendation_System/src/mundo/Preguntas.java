package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Preguntas {

	private BufferedReader br;
	private String sector;

	private String[][] preguntasSector;
	private String[][] preguntasAplicación;
	private String[][] preguntasPilares;

	private boolean[] respuestasSector;
	private boolean[] respuestasAplicaciones;
	private ServicioCloud[] serviciosElegidos;
	private Pilar[] pilaresCliente;

	public Preguntas() {

	}

	/**
	 * Este metodo importa el CSV de sector, le asigna a la variable PrguntasSector el tamano de la matriz y finalmente
	 * llena toda la matriz con el formato 
	 * 
	 * FORMATO
	 * | Sector | Pregunta  |
	 * | Sector | Pregunta  |
	 * 
	 * @param urlSector URL
	 * @throws Exception
	 */
	public void mostrarPreguntasSector(String urlSector) throws Exception {
		br = new BufferedReader(new FileReader(urlSector));
		preguntasSector = new String[22][2];
		for (int i = 0; i < preguntasSector.length; i++) {
			preguntasSector[i] = br.readLine().split(",");
		}

	}
	
	
	/**
	 * Este metodo importa el CSV de Aplicacion, le asigna a la variable PreguntasAplicacion el tamano de la matriz y finalmente
	 * llena toda la matriz con el FORMATO, este llenado depende directamente de la variable SECTOR 
	 * 
	 * FORMATO
	 * | Tipo de pregunta | Pregunta  |
	 * | Tipo de pregunta | Pregunta  |
	 * 
	 * @param urlSector URL
	 * @throws Exception
	 */
	public void mostrarPreguntasAplicacion(String urlAplicacion) throws Exception {
		br = new BufferedReader(new FileReader(urlAplicacion));
		if(sector.equals("Negocios con alto uso de tecnologia")) {
			preguntasAplicación = new String[2][2];
		}else {
			preguntasAplicación = new String[3][2];
		}
		for (int i = 0; i < preguntasAplicación.length; i++) {
			preguntasAplicación[i] = br.readLine().split(",");
		}
	}
	/**
	 * Este metodo importa el CSV de pilares, le asigna a la variable PreguntasPilares el tamano de la matriz y finalmente
	 * llena toda la matriz con el FORMATO
	 * 
	 * FORMATO
	 * | Pilar de la pregunta | Pregunta  |
	 * | Pilar de la pregunta | Pregunta  |
	 * 
	 * @param urlSector URL
	 * @throws Exception
	 */
	
	
	public void mostrarPreguntasPilares(String urlPilares) throws Exception {
		br = new BufferedReader(new FileReader(urlPilares));
			preguntasPilares = new String[22][2];
		
		for (int i = 0; i < preguntasAplicación.length; i++) {
			preguntasAplicación[i] = br.readLine().split(",");
		}
	}
	

	/*
	 * En la interfaz se llama a
	 * SistemaDeRecomendación.Preguntas.setRespuestasSector, aqui se interpretan
	 * esas respuestas
	 */

	/**
	 * Este metodo toma las respuestas provenientes de la interface ya asignadas en la variable RespuestasSector
	 * Evalua cuantos true tiene cada sector y lo asigna en variabls posteriormente busca el Mayor puntaje
	 * Si hay empate entonces se supone que el cliente tiene caracteristicas avanzadas y se le recomienda como si fuera tecnologico
	 * @return
	 */
	
	
	public String interpretarRespuestasSector() {
		int ventas = 0;
		int financiero = 0;
		int ciencias = 0;
		int industria = 0;
		int tecnologia = 0;
		String respuesta="";
		for (int i = 0; i < respuestasSector.length; i++) {
			if (respuestasSector[i] == true) {
				if (i <= 4) {
					ventas += 1;
				}else if (i >= 5 && i <= 9) {
					financiero += 1;
				}else if (i >= 10 && i <= 13) {
					ciencias += 1;
				}else if (i >= 14 && i <= 17) {
					industria += 1;
				}else if (i >= 18 && i <= 21) {
					tecnologia += 1;
				}
			}
		}
		if(ventas > financiero && ventas > ciencias && ventas > industria && ventas > tecnologia ) {
			setSector("Sector ventas");
			respuesta="Sector ventas";
		}else if(financiero > ventas && financiero > ciencias && financiero > industria && financiero > tecnologia ) {
			setSector("Sector financiero");
			respuesta="Sector financiero";
		}else if(ciencias > ventas && ciencias > financiero && ciencias > industria && ciencias > tecnologia ) {
			setSector("Ciencias biologicas y sector sanitario");
			respuesta="Ciencias biologicas y sector sanitario";
		}else if(industria > ventas && industria > financiero && industria > ciencias && industria > tecnologia ) {
			setSector("Industria y fabricacion");
			respuesta="Industria y fabricacion";
		}else if(industria > ventas && industria > financiero && industria > ciencias && industria > tecnologia ) {
			setSector("Industria y fabricacion");
			respuesta="Industria y fabricacion";
		}else if(tecnologia > ventas && tecnologia > financiero && tecnologia > ciencias && tecnologia > industria ) {
			setSector("Negocios con alto uso de tecnologia");
			respuesta="Negocios con alto uso de tecnologia";
		}else {
			setSector("Negocios con alto uso de tecnologia");
			respuesta="Negocios con alto uso de tecnologia";
		}
		
		return respuesta;

	}
	
	 

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public boolean[] getRespuestasSector() {
		return respuestasSector;
	}

	public void setRespuestasSector(boolean[] respuestasSector) {
		this.respuestasSector = respuestasSector;
	}

	public boolean[] getRespuestasAplicaciones() {
		return respuestasAplicaciones;
	}

	public void setRespuestasAplicaciones(boolean[] respuestasAplicaciones) {
		this.respuestasAplicaciones = respuestasAplicaciones;
	}

	public ServicioCloud[] getServiciosElegidos() {
		return serviciosElegidos;
	}

	public void setServiciosElegidos(ServicioCloud[] serviciosElegidos) {
		this.serviciosElegidos = serviciosElegidos;
	}

	public Pilar[] getPilaresCliente() {
		return pilaresCliente;
	}

	public void setPilaresCliente(Pilar[] pilaresCliente) {
		this.pilaresCliente = pilaresCliente;
	}

}
