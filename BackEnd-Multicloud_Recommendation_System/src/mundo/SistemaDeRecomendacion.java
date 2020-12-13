package mundo;

import java.util.ArrayList;

public class SistemaDeRecomendacion {

	// public static String PROVEEDOR_AZURE = "Azure";
	// public static String PROVEEDOR_AWS = "AWS";
	// public static String PROVEEDOR_GCP = "GCP";

	public static String[] PROVEEDORES_CLOUD = { "Azure", "AWS", "GCP" };

	public static String URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS = "./docs/Servicios por sector CSV/sectorventas.csv";
	//	public static String URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS = "./docs/PilaresDeServiciosDeProveedores.csv";
	//	public static String URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS = "./docs/PilaresDeServiciosDeProveedores.csv";
	//	public static String URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS = "./docs/PilaresDeServiciosDeProveedores.csv";
	//	public static String URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS = "./docs/PilaresDeServiciosDeProveedores.csv";
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


	public SistemaDeRecomendacion() throws Exception {
		super();

		listaDeProveedoresCloud = new Proveedor[3];

		preguntasParaLaRecomendacion = new Preguntas();

		cliente = new Cliente( preguntasParaLaRecomendacion.getPilaresCliente(),
				preguntasParaLaRecomendacion.getServiciosElegidos(),
				preguntasParaLaRecomendacion.getSector() );

		try {
			construirTablaDeComparacionDeServicios();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("\n");
		for (int i = 0; i < 5; i++) {
			System.out.println(cliente.getTopDePilaresDelCliente()[i].getValorDelPilar()+ " : " + cliente.getTopDePilaresDelCliente()[i].getNombreDelPilar()  );

		}


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
		// II) Eleccion propia del usuario
		// 3. Recomendacion de servicios para la infraestructura
		// I) Recomendacion de todos los servicios entre Azure, AWS y GCP
		seleccionRecomendadaDeServiciosCloud(tablaComparacionDeServiciosConPilares);

		// II) Recomendacion de tecnologias de the 12 Factor App | Pendiente

	}

	public void incluirServiciosGenerales() {

	}

	/*
	 * Agrega al arreglo de recomendaci�n los servicios dependientes elegidos por el
	 * cliente
	 * 
	 * @param serviciosDependientes Un arreglo con el c�digo del servicio (101
	 * compute services, 102 container support, 103 SQL database)
	 * 
	 * @param proveedor de los servicios elegido por el cliente
	 * 
	 * @example Cliente tipo: Sector Ventas : serviciosDependientes[101,103]
	 * proveedor[AWS,AZURE] (ESCOGIDO POR LOS PILARES)
	 * 
	 * @example Cliente tipo: Tecnolog�a : serviciosDependientes[101,102,103]
	 * proveedor[AWS,AWS,AZURE] (ESCOGIDO POR LOS PILARES)
	 */

	public void incluirServiciosDependientes(Integer[] serviciosDependientes, Proveedor[] proveedor) {

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
	public void construirTablaDeComparacionDeServicios() throws Exception {
		int cantidadDeServicios = -1;

		for (int i = 0; i < listaDeProveedoresCloud.length; i++) {
			// Recuperacion de informacion de pilares de los tres proveedores
			listaDeProveedoresCloud[i] = new Proveedor(PROVEEDORES_CLOUD[i],
					URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS);

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

			servicioYaRecomendado = false;
			int posicionCloudRecomendado = -1;
			int cantidadDeProveedoresQueCuentanConElPilar = 0;
			int indiceDeTop = 0;
			// String[] proveedoresQueCuentanConElPilar = new
			// String[SistemaDeRecomendacion.PROVEEDORES_CLOUD.length];

			// String nombreDePilar = "";
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

			for (int i = 0; i < sis.listaDeServiciosRecomendados.size(); i++) {
				System.out.println(sis.listaDeServiciosRecomendados.get(i).getNombreDeServicio());

			}

			// for (int i = 0; i < args.length; i++) {
			// System.out.println( "hhey" +
			// sis.topEleccionDePilares[i].getNombreDelPilar());
			// }
			//
			//
			//
			// for (int i = 0; i < sis.getCliente().getTopDePilaresDelCliente().length; i++)
			// {
			//
			// System.out.println(sis.getCliente().getTopDePilaresDelCliente()[i]);
			// }
			////
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[0][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[0][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[0][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[1][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[1][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[1][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[2][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[2][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[2][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[3][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[3][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[3][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[4][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[4][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[4][2] + "\n");
			//
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[5][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[5][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[5][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[6][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[6][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[6][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[7][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[7][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[7][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[8][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[8][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[8][2]);
			// System.out.println(sis.tablaComparacionDeServiciosConPilares[9][0] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[9][1] + " - " +
			// sis.tablaComparacionDeServiciosConPilares[9][2] + "\n");
			//

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
