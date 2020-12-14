package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Preguntas {

	private BufferedReader buffer;
	
	private String sector;
	private ServicioCloud[] serviciosElegidos;
	private Pilar[] pilaresCliente;

	private String[][] preguntasSector;
	private String[][] preguntasAplicacion;
	private String[][] preguntasPilares;

	private boolean[] respuestasSector;
	private boolean[] respuestasAplicaciones;
	private boolean[] respuestasPreguntasPilares;


	public Preguntas() throws Exception {
		// Importacion del CSV del sector a la variable PreguntasSector
		mostrarPreguntasSector(SistemaDeRecomendacion.URL_ARCHIVO_DE_PREGUNTAS_DEL_SECTOR);
		// Resultado de las respuestas a las preguntas del sector, hechas dsede la interfaz grafica. 
		//Mientras se integra el front con este back, hare un arreglo de prueba quemado
		respuestasSector = new boolean[preguntasSector.length];
		for (int i = 0; i < respuestasSector.length; i++) {
			respuestasSector[i] =false;
		}
		respuestasSector[0] = false;
		respuestasSector[1] = false;
		respuestasSector[2] = false;
		respuestasSector[3] = true;
		respuestasSector[4] = true;
		//-----------------------------------

		// Categorizacion de sector dadas las preguntas de perfilamiento
		sector = interpretarRespuestasSector();
		System.out.println(sector + "\n");


		// Preguntas sobre la aplicacion y los servicios dado un sector previamente definido
		if(sector.equals("Negocios con alto uso de tecnologia"))
		{
			mostrarPreguntasAplicacion(SistemaDeRecomendacion.URL_ARCHIVO_DE_PREGUNTAS_DEL_SECTOR_TECNOLOGICO);		

		}else
		{
			mostrarPreguntasAplicacion(SistemaDeRecomendacion.URL_ARCHIVO_DE_PREGUNTAS_DE_DEMAS_SECTORES);			
		}


		for (int i = 0; i < preguntasAplicacion.length; i++) {
			System.out.println(preguntasAplicacion[i][0] + " - " + preguntasAplicacion[i][1] );
		}

		System.out.println("\n--------------------");
		respuestasAplicaciones = new boolean[preguntasAplicacion.length];
		//QUEMADOOOOOOOOOOOOOOOOOOOOO. Pues de llos booleans de las respuestas dadas en el front end
		for (int i = 0; i < respuestasAplicaciones.length; i++) {
			respuestasAplicaciones[i] =false;
		}
		//Supongamos que del sector de ventas, eligio bases de datos |SQL|, estara con microservicios usando así instancias y  no usara Kubernetes
		respuestasAplicaciones[0] = false;
		respuestasAplicaciones[1] = true;
		respuestasAplicaciones[2] = false;   

		//------------------------------
		interpretarRespuestasAplicacion();
		//Se obtienen aqui los serviciosElegidos
		//Resultado: serviciosElegdos [SQL, Cómputo, kube]
		for (int i = 0; i < serviciosElegidos.length; i++) {

			System.out.println( serviciosElegidos[i].getTipoDeServicio() );
			//			System.out.println("\n");
			//			System.out.println(serviciosElegidos[1].getTipoDeServicio() + " hey");
			//			System.out.println(serviciosElegidos.length + " uy");
		}

		System.out.println("\n--------------------");
		//-------------------------

		//Ahora se obtendra el top de pilares correspondiente al cliente
			
		
		mostrarPreguntasPilares(SistemaDeRecomendacion.URL_ARCHIVO_DE_PREGUNTAS_DE_LOS_PILARES);

		respuestasPreguntasPilares = new boolean[preguntasPilares.length];

		
		
		for (int i = 0; i < respuestasPreguntasPilares.length; i++) {
			respuestasPreguntasPilares[i] = true;
			
		}
		// 22 Preguntas
		
		// 4/5
		respuestasPreguntasPilares[0] = false;
		
		// 5/5
		//YA Seguridad

		// 3/5
		respuestasPreguntasPilares[11] = false;
		respuestasPreguntasPilares[12] = false;
		
		// 2/5
		respuestasPreguntasPilares[15] = false;
		respuestasPreguntasPilares[16] = false;
		respuestasPreguntasPilares[17] = false;
		
		// 1/5
		respuestasPreguntasPilares[18] = false;
		respuestasPreguntasPilares[19] = false;
		respuestasPreguntasPilares[20] = false;
		
		interpretarRespuestasPilares();
		
		for (int i = 0; i < pilaresCliente.length; i++) {
//			System.out.println(pilaresCliente.length + "");
			System.out.println(pilaresCliente[i].getNombreDelPilar() + " - " + pilaresCliente[i].getValorDelPilar());
			
		}
		// pilares resultado: 4,5,3,2,1
		


	}




	/**
	 * Este metodo importa el CSV de sector, le asigna a la variable PreguntasSector el tamano de la matriz y finalmente
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
		buffer = new BufferedReader(new FileReader(urlSector));
		preguntasSector = new String[22][2];
		for (int i = 0; i < preguntasSector.length; i++) {
			preguntasSector[i] = buffer.readLine().split(",");			
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
		buffer = new BufferedReader(new FileReader(urlAplicacion));
		if(sector.equals("Negocios con alto uso de tecnologia")) {
			preguntasAplicacion = new String[2][2];
		}else {
			preguntasAplicacion = new String[3][2];
		}
		for (int i = 0; i < preguntasAplicacion.length; i++) {
			preguntasAplicacion[i] = buffer.readLine().split(",");
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
		buffer = new BufferedReader(new FileReader(urlPilares));
		preguntasPilares = new String[22][2];

		for (int i = 0; i < preguntasPilares.length; i++) {
			preguntasPilares[i] = buffer.readLine().split(",");
		}
	}


	/*
	 * En la interfaz se llama a
	 * SistemaDeRecomendacion.Preguntas.setRespuestasSector, aqui se interpretan
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
		}else if(tecnologia >=1 ) {
			setSector("Negocios con alto uso de tecnologia");
			respuesta="Negocios con alto uso de tecnologia";
		}else {
			setSector("Negocios con alto uso de tecnologia");
			respuesta="Negocios con alto uso de tecnologia";
		}

		return respuesta;

	}

	// 2
	public void interpretarRespuestasAplicacion() {

		//		System.out.println(sector + " ESTE");
		if(sector.equals("Negocios con alto uso de tecnologia")){
			serviciosElegidos = new ServicioCloud[1];
			//Si soy Alto uso de tech solo voy a preguntar si es kubernetes o support
			if(respuestasAplicaciones[0] == true) {
				if(respuestasAplicaciones[1] == true) {
					serviciosElegidos[0] = new ServicioCloud("Kubernetes Managed Service", "NN", 0, 0, 0, 0, 0);

				}else {
					serviciosElegidos[0] = new ServicioCloud("Container Support", "NN", 0, 0, 0, 0, 0);
				}
			}else {
				serviciosElegidos[0] = new ServicioCloud("Compute Services", "NN", 0, 0, 0, 0, 0);
			}
		}else {
			//			respuestasAplicaciones[0] = false;
			//			respuestasAplicaciones[1] = true;
			//			respuestasAplicaciones[2] = false;   
			//Supongamos que del sector de ventas, eligio bases de datos |SQL|, estara con microservicios usando así instancias y  no usara Kubernetes


			//Si no es alto uso de tech, significa que es cualquiera de los otros, que todos son iguales
			//BD
			
			serviciosElegidos = new ServicioCloud[2];
			if(respuestasAplicaciones[0] == true) {
				serviciosElegidos[0] = new ServicioCloud("NoSQL Database", "NN", 0, 0, 0, 0, 0);
			} else {
				serviciosElegidos[0] = new ServicioCloud("SQL Database", "NN", 0, 0, 0, 0, 0);
			}
			//Computo
			if(respuestasAplicaciones[1] == true) {
				if(respuestasAplicaciones[2] == true) {
					serviciosElegidos[1] = new ServicioCloud("Kubernetes Managed Service", "NN", 0, 0, 0, 0, 0);
				}else {
					serviciosElegidos[1] = new ServicioCloud("Container Support", "NN", 0, 0, 0, 0, 0);
				}
			}else {
				serviciosElegidos[1] = new ServicioCloud("Compute Services", "NN", 0, 0, 0, 0, 0);
			}
		}

	}


	public void interpretarRespuestasPilares() {
		
		int excelenciaOperativa=0;
		int seguridad=0;
		int fiabilidad=0;
		int eficienciaRendimiento=0;
		int optimizacionCostos=0;

		for (int i = 0; i < respuestasPreguntasPilares.length; i++) {
			if(respuestasPreguntasPilares[i]==true) {
				if(i>=0 && i<=4) {
					excelenciaOperativa +=1;
				}else if(i>=5 && i<=9) {
					seguridad +=1;
				}else if(i>=10 && i<=13) {
					if(i==10) {
						fiabilidad +=2;
					}else {
						fiabilidad +=1;
					}
				}else if(i>=14 && i<=17) {
					if(i==14) {
						eficienciaRendimiento +=2;
					}else {
						eficienciaRendimiento +=1;
					}
				}else if(i>=18 && i<=21) {
					if(i==18) {
						optimizacionCostos +=2;
					}else {
						optimizacionCostos +=1;
					}
				}
			}
		}
		

		
		pilaresCliente = new Pilar[5];
		pilaresCliente[0] = new Pilar( ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[1], excelenciaOperativa);
		pilaresCliente[1] = new Pilar( ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[4], seguridad);
		pilaresCliente[2] = new Pilar( ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[3], fiabilidad);
		pilaresCliente[3] = new Pilar( ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[2], eficienciaRendimiento);
		pilaresCliente[4] = new Pilar( ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[0], optimizacionCostos);

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


	public String[][] getPreguntasSector() {
		return preguntasSector;
	}


	public void setPreguntasSector(String[][] preguntasSector) {
		this.preguntasSector = preguntasSector;
	}

	public String[][] getPreguntasAplicacion() {
		return preguntasAplicacion;
	}


	public void setPreguntasAplicacion(String[][] preguntasAplicacion) {
		this.preguntasAplicacion = preguntasAplicacion;
	}


	public String[][] getPreguntasPilares() {
		return preguntasPilares;
	}


	public void setPreguntasPilares(String[][] preguntasPilares) {
		this.preguntasPilares = preguntasPilares;
	}


	
	
//
//	public static void main(String[] args) {
//		try {
//			Preguntas p = new Preguntas();
//
//
//
//
//
//
//
//
//
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
//

}
