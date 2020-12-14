package mundo;

import java.util.ArrayList;

public class SistemaDeRecomendacion {

	// public static String PROVEEDOR_AZURE = "Azure";
	// public static String PROVEEDOR_AWS = "AWS";
	// public static String PROVEEDOR_GCP = "GCP";

	public static String[] PROVEEDORES_CLOUD = { "Azure", "AWS", "GCP" };

	public static String URL_COMPARATIVA_DE_SERVICIOS_SECTOR_VENTAS = "./docs/Servicios por sector CSV/sectorventas.csv";
		public static String URL_COMPARATIVA_DE_SERVICIOS_DE_ALTO_USO_TECNOLOGICO = "./docs/Servicios por sector CSV/altousotecnologia.csv";
		public static String URL_COMPARATIVA_DE_SERVICIOS_CIENCIAS_BIOLOGICAS = "./docs/Servicios por sector CSV/cienciabiologicas.csv";
		public static String URL_COMPARATIVA_DE_SERVICIOS_INDUSTRIA_Y_FABRICACION = "./docs/Servicios por sector CSV/industriayfabricacion.csv";
		public static String URL_COMPARATIVA_DE_SERVICIOS_SECTOR_FINANCIERO = "./docs/Servicios por sector CSV/sectorfinanciero.csv";
		public static String URL_COMPARATIVA_DE_SERVICIOS_ESPECIALES = "./docs/Servicios por sector CSV/serviciostotal.csv";
		
	public static String URL_ARCHIVO_DE_PREGUNTAS_DEL_SECTOR = "./docs/Preguntas CSV/1preguntasSector.csv";
	public static String URL_ARCHIVO_DE_PREGUNTAS_DE_DEMAS_SECTORES = "./docs/Preguntas CSV/2preguntasAplicacionDemasSectores.csv";
	public static String URL_ARCHIVO_DE_PREGUNTAS_DEL_SECTOR_TECNOLOGICO = "./docs/Preguntas CSV/2preguntasAplicacionSectorTecnologico.csv";
	public static String URL_ARCHIVO_DE_PREGUNTAS_DE_LOS_PILARES = "./docs/Preguntas CSV/3preguntasPilares.csv";

	private Proveedor[] listaDeProveedoresCloud;

	private Cliente cliente;

	private Preguntas preguntasParaLaRecomendacion;

	// TERMINAR VARIABLES RELACIONADAS A LA REALIZACION DE LAS PREGUNTAS

	private int[][] tablaComparacionDeServiciosConPilares;

	private ArrayList<ServicioCloud> listaDeServiciosSectorVentas;
	private ArrayList<ServicioCloud> listaDeServiciosSectorFinanciero;
	private ArrayList<ServicioCloud> listaDeServiciosCienciasBiologicas;
	private ArrayList<ServicioCloud> listaDeServiciosIndustria;
	private ArrayList<ServicioCloud> listaDeServiciosTecnologia;
	private ArrayList<ServicioCloud> listaDeServiciosRecomendados;
	private ArrayList<String> listaDeProveedoresRelacionadosParaLosServiciosGenerales;
	private ArrayList<ServicioCloud> listaDeTiposDeServiciosADescartar;
	
	private int posicionDeProveedorDeBaseDeDatosSeleccionado;
	private int posicionDeProveedorDeComputoSeleccionado;



	public SistemaDeRecomendacion() throws Exception {
		super();
		
		posicionDeProveedorDeBaseDeDatosSeleccionado = -1;
		posicionDeProveedorDeComputoSeleccionado  = -1;

		listaDeProveedoresCloud = new Proveedor[3];

		preguntasParaLaRecomendacion = new Preguntas();

		cliente = new Cliente( preguntasParaLaRecomendacion.getPilaresCliente(),
				preguntasParaLaRecomendacion.getServiciosElegidos(),
				preguntasParaLaRecomendacion.getSector() );

		exclusionServiciosNoElegidos();

		try {
			construirTablaDeComparacionDeServicios(URL_COMPARATIVA_DE_SERVICIOS_SECTOR_VENTAS);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n");
		for (int i = 0; i < 5; i++) {
			System.out.println(cliente.getTopDePilaresDelCliente()[i].getValorDelPilar()+ " : " + cliente.getTopDePilaresDelCliente()[i].getNombreDelPilar()  );

		}

		//		System.out.println("\n");
		//		for (int i = 0; i < 2; i++) {
		//			System.out.println(cliente.getServiciosSeleccionados()+ " : " + cliente.getTopDePilaresDelCliente()[i].getNombreDelPilar()  );
		//
		//		}


		// 1. Perfilacion de eleccion de pilares del usuario
		// I) Preguntas - DATOS QUEMADOS DEL TOP DE PILARES
		// topDePilaresDelUsuario = new int[ServicioCloud.NUMERO_DE_PILARES];
		//
		// topDePilaresDelUsuario[0] = 5;
		// topDePilaresDelUsuario[1] = 4;
		// topDePilaresDelUsuario[2] = 3;
		// topDePilaresDelUsuario[3] = 2;
		// topDePilaresDelUsuario[4] = 1;
		// topDePilaresDelUsuario.sort(function(a, b) {
		// return a - b;
		// });
		//
		// II) Eleccion de tipo de empresa

		// 2. Eleccion de los servicios para la infraestructura
		// I) Pre-seleccion de tecnologias por parte del sistema - ESTA
		listaDeServiciosRecomendados = new ArrayList<ServicioCloud>();		


		//


		// II) Eleccion propia del usuario
		// 3. Recomendacion de servicios para la infraestructura
		// I) Recomendacion de todos los servicios entre Azure, AWS y GCP
		seleccionRecomendadaDeServiciosCloud(tablaComparacionDeServiciosConPilares);
		for (int i = 0; i < listaDeServiciosRecomendados.size(); i++) {
			System.out.println(" 	jeje " + listaDeServiciosRecomendados.get(i).getTipoDeServicio());
		}
		
		incluirServiciosDependientes(URL_COMPARATIVA_DE_SERVICIOS_ESPECIALES);

		System.out.println("\n\n 	OTROS ---------------------------------------------------------------" );
		for (int i = 0; i < listaDeServiciosRecomendados.size(); i++) {
			System.out.println(" 	OTROS" + listaDeServiciosRecomendados.get(i).getTipoDeServicio()+  "	Celebralo Curramba!: " + listaDeServiciosRecomendados.get(i).getNombreDeServicio());
		}
		//		for (int i = 0; i < PROVEEDORES_CLOUD.length; i++) {
		//			
		//			System.out.println("Estos son: " + cliente.get(i).getTipoDeServicio());
		//		}
		// II) Recomendacion de tecnologias de the 12 Factor App | Pendiente

	}

	public void exclusionServiciosNoElegidos()
	{
		listaDeTiposDeServiciosADescartar = new ArrayList<>();

		listaDeTiposDeServiciosADescartar.add( new ServicioCloud("NoSQL Database Options", "NN", 0, 0, 0, 0, 0) );
		listaDeTiposDeServiciosADescartar.add( new ServicioCloud("SQL Database Options", "NN", 0, 0, 0, 0, 0) );
		listaDeTiposDeServiciosADescartar.add( new ServicioCloud("Kubernetes Managed Service", "NN", 0, 0, 0, 0, 0) );
		listaDeTiposDeServiciosADescartar.add( new ServicioCloud("Container Support", "NN", 0, 0, 0, 0, 0) );
		listaDeTiposDeServiciosADescartar.add( new ServicioCloud("Compute Services", "NN", 0, 0, 0, 0, 0) );

		for (int i = 0; i < listaDeTiposDeServiciosADescartar.size(); i++) {
			//Eliminacion de la base de datos seleccionada
			if(listaDeTiposDeServiciosADescartar.get(i).getTipoDeServicio().equals(cliente.getServiciosSeleccionados()[0].getTipoDeServicio()))
			{
				listaDeTiposDeServiciosADescartar.remove(i);

			}

			//Eliminacion del tipo de computo seleccionado			
			if(listaDeTiposDeServiciosADescartar.get(i).getTipoDeServicio().equals(cliente.getServiciosSeleccionados()[1].getTipoDeServicio()))
			{
				listaDeTiposDeServiciosADescartar.remove(i);

			}			

		}

		System.out.println("\n");
		System.out.println(cliente.getServiciosSeleccionados()[0].getTipoDeServicio() + " COLEEEE " + cliente.getServiciosSeleccionados()[1].getTipoDeServicio() );		
		System.out.println("\n Servicios No Elegidos:");


		//La chinga quiso SQL y Contenedores

		for (int i = 0; i < listaDeTiposDeServiciosADescartar.size(); i++) {

			System.out.println(	"OIGA MIRE VEA "  + listaDeTiposDeServiciosADescartar.get(i).getTipoDeServicio());

		}
		System.out.println("\n");

	}
	public void incluirServiciosGenerales() {

	}

	/**
	 * Agrega al arreglo de recomendaci�n los servicios dependientes elegidos por el
	 * cliente
	 * 
	 * @param urlDelArchivoAConstruir Un URL que contiene la valoracion de los servicios especiales
	 * con los pilares ("./docs/Servicios por sector CSV/ARCHIVO_SECTOR.csv")
	 * 
	 * @param proveedor de los servicios elegido por el cliente
	 * 
	 * @example Cliente tipo: Sector Ventas : serviciosDependientes[101,103]
	 * proveedor[AWS,AZURE] (ESCOGIDO POR LOS PILARES)
	 * 
	 * @example Cliente tipo: Tecnolog�a : serviciosDependientes[101,102,103]
	 * proveedor[AWS,AWS,AZURE] (ESCOGIDO POR LOS PILARES)
	 */

	public void incluirServiciosDependientes( String urlDelArchivoAConstruir) throws Exception{


		int cantidadDeServicios = -1;

		for (int i = 0; i < listaDeProveedoresCloud.length; i++) {
			
			
			// Recuperacion de informacion de pilares de los tres proveedores
			listaDeProveedoresCloud[i] = new Proveedor(PROVEEDORES_CLOUD[i],
					urlDelArchivoAConstruir, listaDeTiposDeServiciosADescartar);

			cantidadDeServicios = listaDeProveedoresCloud[i].cantidadDeServicios();

		}

		tablaComparacionDeServiciosConPilares = new int[cantidadDeServicios * 5][listaDeProveedoresCloud.length];

		int offset = 0;

		for (int i = 0; i < cantidadDeServicios; i++) {

			offset = 5 * i;

			for (int j = 0; j < tablaComparacionDeServiciosConPilares[0].length; j++) {
				tablaComparacionDeServiciosConPilares[offset + 0][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[0].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 1][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[1].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 2][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[2].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 3][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[3].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 4][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[4].getValorDelPilar();

			}

		}


		//--------------------------------------------------------------------------------------------------------------------
		
		boolean servicioYaRecomendado = false;

		Pilar[] topEleccionDePilares = cliente.getTopDePilaresDelCliente();
		
		int[][] matrizDePilaresDeServicios = tablaComparacionDeServiciosConPilares;
		
		for (int i = 0; i < matrizDePilaresDeServicios.length; i += 5) {
			//			System.out.println(i + " Ojo ahi");
			//			if(matrizDePilaresDeServicios[i][0].  )


			servicioYaRecomendado = false;
//			int posicionCloudRecomendado = -1;
//			int cantidadDeProveedoresQueCuentanConElPilar = 0;
			int indiceDeTop = 0;
			// String[] proveedoresQueCuentanConElPilar = new
			// String[SistemaDeRecomendacion.PROVEEDORES_CLOUD.length];

			// String nombreDePilar = "";


			//HACER QUE LEA LAS ETIQUETAS !! DESDE EL ARCHIVO
			for (int j = 0; j < ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION.length && !servicioYaRecomendado; j++)
			{
//				cantidadDeProveedoresQueCuentanConElPilar = 0;
//				posicionCloudRecomendado = -1;



				if (topEleccionDePilares[indiceDeTop].getNombreDelPilar()
						.equals(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[j])) {
					
//					String[] proveedoresQueCuentanConElPilar = new String[PROVEEDORES_CLOUD.length];
					for (int k = 0; k < PROVEEDORES_CLOUD.length; k++) {

						// Se cuenta cuantos proveedores tienen el pilar buscado actualmente del top

						if (matrizDePilaresDeServicios[i + j][k] == 100) {
							
							for (int l = 0; l < PROVEEDORES_CLOUD.length; l++) {
								listaDeServiciosRecomendados.add(new ServicioCloud(
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getTipoDeServicio(),
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getNombreDeServicio(),
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getPilares()[0].getValorDelPilar(),
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getPilares()[1].getValorDelPilar(),
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getPilares()[2].getValorDelPilar(),
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getPilares()[3].getValorDelPilar(),
										listaDeProveedoresCloud[l].getListaDeServicios().get(i / 5)
										.getPilares()[4].getValorDelPilar()));
								servicioYaRecomendado = true;
								indiceDeTop = 0;
//								break;
							}
							
							break;
							
//							cantidadDeProveedoresQueCuentanConElPilar++;
//							posicionCloudRecomendado = k;
						}else if (matrizDePilaresDeServicios[i + j][k] == 101 || matrizDePilaresDeServicios[i + j][k] == 102) {
							

								listaDeServiciosRecomendados.add(new ServicioCloud(
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getTipoDeServicio(),
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getNombreDeServicio(),
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getPilares()[0].getValorDelPilar(),
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getPilares()[1].getValorDelPilar(),
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getPilares()[2].getValorDelPilar(),
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getPilares()[3].getValorDelPilar(),
										listaDeProveedoresCloud[posicionDeProveedorDeComputoSeleccionado].getListaDeServicios().get(i / 5)
										.getPilares()[4].getValorDelPilar()));
								servicioYaRecomendado = true;
								indiceDeTop = 0;
								break;

						}else if (matrizDePilaresDeServicios[i + j][k] == 103) {							

							listaDeServiciosRecomendados.add(new ServicioCloud(
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getTipoDeServicio(),
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getNombreDeServicio(),
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getPilares()[0].getValorDelPilar(),
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getPilares()[1].getValorDelPilar(),
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getPilares()[2].getValorDelPilar(),
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getPilares()[3].getValorDelPilar(),
									listaDeProveedoresCloud[posicionDeProveedorDeBaseDeDatosSeleccionado].getListaDeServicios().get(i / 5)
									.getPilares()[4].getValorDelPilar()));
							servicioYaRecomendado = true;
							indiceDeTop = 0;
							break;
//							cantidadDeProveedoresQueCuentanConElPilar++;
//							posicionCloudRecomendado = k;
						}

					}



				}


			}


		}
		
		

	}

	public String asignarSectorCliente() {
		String sector = "";




		return sector;
	}


	public Proveedor[] getProveedoresCloud() {
		return listaDeProveedoresCloud;
	}

	public void setProveedoresCloud(Proveedor[] proveedoresCloud) {
		this.listaDeProveedoresCloud = proveedoresCloud;
	}

	public int[][] getTablaComparacionDeServiciosConPilares() {
		return tablaComparacionDeServiciosConPilares;
	}

	public void setTablaComparacionDeServiciosConPilares(int[][] tablaComparacionDeServiciosConPilares) {
		this.tablaComparacionDeServiciosConPilares = tablaComparacionDeServiciosConPilares;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

	/**
	 * En este punto deberia tener un parametro que le pase el URL del archivo, dependiendo del tipo de negocio del usuario
	 * @throws Exception
	 */
	public void construirTablaDeComparacionDeServicios(String urlDelArchivoAConstruir) throws Exception {
		int cantidadDeServicios = -1;

		for (int i = 0; i < listaDeProveedoresCloud.length; i++) {
			// Recuperacion de informacion de pilares de los tres proveedores
			listaDeProveedoresCloud[i] = new Proveedor(PROVEEDORES_CLOUD[i],
					urlDelArchivoAConstruir, listaDeTiposDeServiciosADescartar);

			cantidadDeServicios = listaDeProveedoresCloud[i].cantidadDeServicios();

		}

		tablaComparacionDeServiciosConPilares = new int[cantidadDeServicios * 5][listaDeProveedoresCloud.length];

		int offset = 0;

		for (int i = 0; i < cantidadDeServicios; i++) {

			offset = 5 * i;

			for (int j = 0; j < tablaComparacionDeServiciosConPilares[0].length; j++) {
				tablaComparacionDeServiciosConPilares[offset + 0][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[0].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 1][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[1].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 2][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[2].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 3][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[3].getValorDelPilar();
				tablaComparacionDeServiciosConPilares[offset + 4][j] = listaDeProveedoresCloud[j].getListaDeServicios()
						.get(i).getPilares()[4].getValorDelPilar();

			}
		}
	}

	// /** Algoritmos*/


	public void seleccionRecomendadaDeServiciosCloud(int[][] matrizDePilaresDeServicios) {
		boolean servicioYaRecomendado = false;

		Pilar[] topEleccionDePilares = cliente.getTopDePilaresDelCliente();

		for (int i = 0; i < matrizDePilaresDeServicios.length; i += 5) {
			//			System.out.println(i + " Ojo ahi");
			//			if(matrizDePilaresDeServicios[i][0].  )


			servicioYaRecomendado = false;
			int posicionCloudRecomendado = -1;
			int cantidadDeProveedoresQueCuentanConElPilar = 0;
			int indiceDeTop = 0;
			// String[] proveedoresQueCuentanConElPilar = new
			// String[SistemaDeRecomendacion.PROVEEDORES_CLOUD.length];

			// String nombreDePilar = "";


			//HACER QUE LEA LAS ETIQUETAS !! DESDE EL ARCHIVO
			for (int j = 0; j < ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION.length && !servicioYaRecomendado; j++)
			{
				cantidadDeProveedoresQueCuentanConElPilar = 0;
				posicionCloudRecomendado = -1;



				if (topEleccionDePilares[indiceDeTop].getNombreDelPilar()
						.equals(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[j])) {
					for (int k = 0; k < PROVEEDORES_CLOUD.length; k++) {

						// Se cuenta cuantos proveedores tienen el pilar buscado actualmente del top

						if (matrizDePilaresDeServicios[i + j][k] == 1) {
							cantidadDeProveedoresQueCuentanConElPilar++;
							posicionCloudRecomendado = k;
						}

					}

					if (cantidadDeProveedoresQueCuentanConElPilar == 1) {
						

						listaDeServiciosRecomendados.add(new ServicioCloud(
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getTipoDeServicio(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getNombreDeServicio(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getPilares()[0].getValorDelPilar(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getPilares()[1].getValorDelPilar(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getPilares()[2].getValorDelPilar(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getPilares()[3].getValorDelPilar(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5)
								.getPilares()[4].getValorDelPilar()));
						
						for (int j2 = 0; j2 < topEleccionDePilares.length 
								&& listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5).getTipoDeServicio().equals(
										cliente.getServiciosSeleccionados()[0].getTipoDeServicio()); j2++) {
							posicionDeProveedorDeBaseDeDatosSeleccionado = posicionCloudRecomendado;
							
						}
						
						for (int j2 = 0; j2 < topEleccionDePilares.length 
								&& listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i / 5).getTipoDeServicio().equals(
										cliente.getServiciosSeleccionados()[1].getTipoDeServicio()); j2++) {
							posicionDeProveedorDeComputoSeleccionado = posicionCloudRecomendado;
							
						}
						
						servicioYaRecomendado = true;
						indiceDeTop = 0;
						break;
					} else {


						indiceDeTop++;
						j= -1;

						//						// servicios especiales: 100,101,102,103
					}


				}


			}


		}


	}



	public static void main(String[] args) {

		try {

			SistemaDeRecomendacion sis = new SistemaDeRecomendacion();

			System.out.println("Top de pilares");

			System.out.println("");
			//
			//			for (int i = 0; i < 5; i++) {
			//
			//				System.out.println("" + sis.getCliente().getTopDePilaresDelCliente()[i].getNombreDelPilar());
			//			}

			System.out.println("");

			System.out.println("Recomendacion de tecnologias Multi-Cloud Computing - Test");
			System.out.println("");
			//
			//			for (int i = 0; i < sis.listaDeServiciosRecomendados.size(); i++) {
			//				System.out.println(sis.listaDeServiciosRecomendados.get(i).getTipoDeServicio() + " 				recomendacion: " + sis.listaDeServiciosRecomendados.get(i).getNombreDeServicio());
			//
			//			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Preguntas getPreguntasParaLaRecomendacion() {
		return preguntasParaLaRecomendacion;
	}

	public void setPreguntasParaLaRecomendacion(Preguntas preguntasParaLaRecomendacion) {
		this.preguntasParaLaRecomendacion = preguntasParaLaRecomendacion;
	}



}
