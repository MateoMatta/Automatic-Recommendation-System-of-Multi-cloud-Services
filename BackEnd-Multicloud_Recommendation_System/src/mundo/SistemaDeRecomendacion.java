package mundo;

import java.util.ArrayList;

public class SistemaDeRecomendacion {

	//	public static String PROVEEDOR_AZURE 	= "Azure";
	//	public static String PROVEEDOR_AWS 		= "AWS";
	//	public static String PROVEEDOR_GCP 		= "GCP";

	public static String[] PROVEEDORES_CLOUD = {"Azure", "AWS", "GCP"};

	public static String URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS = "./docs/PilaresDeServiciosDeProveedores.csv";

	private Proveedor[] listaDeProveedoresCloud;

	private Cliente cliente;


	//TERMINAR VARIABLES RELACIONADAS A LA REALIZACION DE LAS PREGUNTAS

	private int[][] tablaComparacionDeServiciosConPilares;

	private ArrayList<ServicioCloud> listaDeServiciosRecomendados;


	public SistemaDeRecomendacion() {
		super();
		listaDeProveedoresCloud = new Proveedor[3];

		cliente = new Cliente();



		try {
			construirTablaDeComparacionDeServicios();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//1. Perfilacion de eleccion de pilares del usuario
		//		I)	Preguntas - 										DATOS QUEMADOS DEL TOP DE PILARES 
		//				topDePilaresDelUsuario = new int[ServicioCloud.NUMERO_DE_PILARES];
		//				
		//				topDePilaresDelUsuario[0] = 5;
		//				topDePilaresDelUsuario[1] = 4;
		//				topDePilaresDelUsuario[2] = 3;
		//				topDePilaresDelUsuario[3] = 2;
		//				topDePilaresDelUsuario[4] = 1;
		//				topDePilaresDelUsuario.sort(function(a, b) {
		//					  return a - b;
		//					});
		//				
		//		II)	Eleccion de tipo de empresa

		//2. Eleccion de los servicios para la infraestructura
		//		I)	Pre-seleccion de tecnologias por parte del sistema - ESTA
		listaDeServiciosRecomendados = new ArrayList<ServicioCloud>();
		//		II)	Eleccion propia del usuario
		//3. Recomendacion de servicios para la infraestructura
		//		I)	Recomendacion de todos los servicios entre Azure, AWS y GCP
		seleccionRecomendadaDeServiciosCloud(tablaComparacionDeServiciosConPilares);

		//		II)	Recomendacion de tecnologias de the 12 Factor App | Pendiente


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



	//	
	public void construirTablaDeComparacionDeServicios() throws Exception
	{
		int cantidadDeServicios =-1;

		for (int i = 0; i < listaDeProveedoresCloud.length; i++) {
			//Recuperacion de informacion de pilares de los tres proveedores
			listaDeProveedoresCloud[i] = new Proveedor(PROVEEDORES_CLOUD[i], URL_ARCHIVO_DE_DATOS_COMPARATIVA_DE_SERVICIOS);

			cantidadDeServicios =  listaDeProveedoresCloud[i].cantidadDeServicios();

		}

		tablaComparacionDeServiciosConPilares = new int[cantidadDeServicios*5][listaDeProveedoresCloud.length];

		int offset = 0;

		for (int i = 0; i < cantidadDeServicios; i++) {

			offset = 5*i;

			for (int j = 0; j < tablaComparacionDeServiciosConPilares[0].length; j++) {
				tablaComparacionDeServiciosConPilares[offset+0][j] = listaDeProveedoresCloud[j].getListaDeServicios().get(i).getPilares()[0].getValorDelPilar();	
				tablaComparacionDeServiciosConPilares[offset+1][j] = listaDeProveedoresCloud[j].getListaDeServicios().get(i).getPilares()[1].getValorDelPilar();	
				tablaComparacionDeServiciosConPilares[offset+2][j] = listaDeProveedoresCloud[j].getListaDeServicios().get(i).getPilares()[2].getValorDelPilar();	
				tablaComparacionDeServiciosConPilares[offset+3][j] = listaDeProveedoresCloud[j].getListaDeServicios().get(i).getPilares()[3].getValorDelPilar();	
				tablaComparacionDeServiciosConPilares[offset+4][j] = listaDeProveedoresCloud[j].getListaDeServicios().get(i).getPilares()[4].getValorDelPilar();	

			}
		}
	}


	//	/** Algoritmos*/
	//
	//	public void seleccionRecomendadaDeServiciosCloud(int[][] matrizDePilaresDeServicios)
	//	{
	//		int cantidadDeServicios = (matrizDePilaresDeServicios.length/5);
	//
	//		for (int i = 0; i < cantidadDeServicios; i++) {
	//
	//
	//			for (int j = 0; j < ServicioCloud.NUMERO_DE_PILARES; j++) {
	//				
	//				int posicionCloudRecomendado=-1;
	//				int cantidadDeProveedoresQueCuentanConElPilar =0;
	//				int[] proveedoresQueCuentanConElPilar = new int[SistemaDeRecomendacion.PROVEEDORES_CLOUD.length];
	//		
	//				for (int k = 0; k < PROVEEDORES_CLOUD.length; k++) {
	//					
	//				}
	//				
	//				if(matrizDePilaresDeServicios[i][j] == 1)
	//				{
	//					
	//					
	//				}
	//				
	////				if(matrizDePilaresDeServicios[i][j] == 1 )
	////				{
	////					proveedoresQueCuentanConElPilar[j] = 1;
	////					cantidadDeProveedoresQueCuentanConElPilar++;
	////				}				
	//
	//			}
	//
	//			if(cantidadDeProveedoresQueCuentanConElPilar == 0)
	//			{
	//
	//
	//			}else if(cantidadDeProveedoresQueCuentanConElPilar == 1)
	//			{
	//
	//			}else if(cantidadDeProveedoresQueCuentanConElPilar == 2)
	//			{
	//
	//			}else if(cantidadDeProveedoresQueCuentanConElPilar == 3)
	//			{
	//
	//			}
	//
	//
	//		}
	//
	//
	//	}


	/** Algoritmos*/
	public void seleccionRecomendadaDeServiciosCloud(int[][] matrizDePilaresDeServicios)
	{
		boolean servicioYaRecomendado = false;
		
		Pilar[] topEleccionDePilares = cliente.getTopDePilaresDelCliente();

		for (int i = 0; i < matrizDePilaresDeServicios.length; i+=5) {
			System.out.println(i + " Ojo ahi");

			servicioYaRecomendado = false;
			int posicionCloudRecomendado=-1;
			int cantidadDeProveedoresQueCuentanConElPilar =0;
			int indiceDeTop = 0;
			//			String[] proveedoresQueCuentanConElPilar = new String[SistemaDeRecomendacion.PROVEEDORES_CLOUD.length];


			//			String nombreDePilar = "";
			for (int j = 0; j < ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION.length && !servicioYaRecomendado; j++) {
				cantidadDeProveedoresQueCuentanConElPilar =0;
				posicionCloudRecomendado = -1;

				//				posicionCloudRecomendado = -1;
				//				cantidadDeProveedoresQueCuentanConElPilar =0;
				if(topEleccionDePilares[indiceDeTop].getNombreDelPilar().equals(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[j]))
				{
					for (int k = 0; k < PROVEEDORES_CLOUD.length; k++) {

						//Se cuenta cuantos proveedores tienen el pilar buscado actualmente del top

						//						acaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa

						if(matrizDePilaresDeServicios[i+j][k] == 1)
						{
							cantidadDeProveedoresQueCuentanConElPilar++;
							posicionCloudRecomendado = k;
						}

					}


					if(cantidadDeProveedoresQueCuentanConElPilar == 1) {
						listaDeServiciosRecomendados.add(new ServicioCloud(listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getTipoDeServicio(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getNombreDeServicio(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[0].getValorDelPilar(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[1].getValorDelPilar(),
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[2].getValorDelPilar(), 
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[3].getValorDelPilar(), 
								listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[4].getValorDelPilar()));
						servicioYaRecomendado =true ;
						indiceDeTop =0;
//						posicionCloudRecomendado = -1;
						break;
					}else
					{

						indiceDeTop++;
						j=-1;
//						posicionCloudRecomendado = -1;
					}




					//						if(k==2 && cantidadDeProveedoresQueCuentanConElPilar ==  0)
					//						{
					//							indiceDeTop++;
					//						}

					//						if(k!=2)
					//						{
					//							//No se hace nada. Entonces se itera de nuevo para trabajar
					//							//con el siguiente pilar del top
					//							posicionCloudRecomendado = -1;
					//							
					//							
					//							if(cantidadDeProveedoresQueCuentanConElPilar > 1)
					//							{
					//								if(k==2)
					//								{
					//									
					//								}
					//								//Seria el proveedor ya previamente escogido en la tercera iteracion, el unico
					//													posicionCloudRecomendado = k;
					//								listaDeServiciosRecomendados.add(new ServicioCloud(listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getTipoDeServicio(),
					//										listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getNombreDeServicio(),
					//										listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[0].getValorDelPilar(),
					//										listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[1].getValorDelPilar(),
					//										listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[2].getValorDelPilar(), 
					//										listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[3].getValorDelPilar(), 
					//										listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[4].getValorDelPilar()));
					//								servicioYaRecomendado =true ;
					////								posicionCloudRecomendado = -1;
					////								indiceDeTop = 0;
					//
					////								break;
					//
					//							}
					//							
					//							
					//
					//						} 

					//				nombreDePilar = ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[j];

				}

//				else
//				{
////					indiceDeTop++;
//				}

				//				else if(cantidadDeProveedoresQueCuentanConElPilar == 3)
				//				{
				//
				//				}
				//				if(matrizDePilaresDeServicios[i][j] == 1 )
				//				{
				//					proveedoresQueCuentanConElPilar[j] = 1;
				//					cantidadDeProveedoresQueCuentanConElPilar++;
				//				}				

			}

			//			if(cantidadDeProveedoresQueCuentanConElPilar == 0)
			//			{
			//
			//
			//			}else if(cantidadDeProveedoresQueCuentanConElPilar == 1)
			//			{
			//
			//			}else if(cantidadDeProveedoresQueCuentanConElPilar == 2)
			//			{
			//
			//			}else if(cantidadDeProveedoresQueCuentanConElPilar == 3)
			//			{
			//
			//			}


		}


	}
	//	public void seleccionRecomendadaDeServiciosCloud(int[][] matrizDePilaresDeServicios)
	//	{
	//
	//		for (int i = 0; i < matrizDePilaresDeServicios.length; i+=5) {
	//
	//
	//			int posicionCloudRecomendado=-1;
	//			int cantidadDeProveedoresQueCuentanConElPilar =0;
	//			String[] proveedoresQueCuentanConElPilar = new String[SistemaDeRecomendacion.PROVEEDORES_CLOUD.length];
	//			
	//			
	//			
	//			String nombreDePilar = "";
	//			for (int j = 0; j < ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION.length; j++) {
	//
	////				nombreDePilar = ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[j];
	//				
	//				for (int k = 0; k < PROVEEDORES_CLOUD.length; k++) {
	//					
	//					if(matrizDePilaresDeServicios[i+j][k] == 1)
	//					{
	//						proveedoresQueCuentanConElPilar[j] += k+",";
	//						cantidadDeProveedoresQueCuentanConElPilar++;
	//						posicionCloudRecomendado = k;
	//					}
	//				}
	//
	//				if(cantidadDeProveedoresQueCuentanConElPilar == 0)
	//				{
	//					//No se hace nada. Entonces se itera de nuevo para trabajar
	//					//con el siguiente pilar del top
	//					posicionCloudRecomendado = -1;
	//					
	//				}else if(cantidadDeProveedoresQueCuentanConElPilar == 1)
	//				{
	//					//Seria el proveedor ya previamente escogido en la tercera iteracion, el unico
	////					posicionCloudRecomendado = k;
	//					listaDeServiciosRecomendados.add(new ServicioCloud(listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getTipoDeServicio(),
	//							listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getNombreDeServicio(),
	//							listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[0].getValorDelPilar(),
	//							listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[1].getValorDelPilar(),
	//							listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[2].getValorDelPilar(), 
	//							listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[3].getValorDelPilar(), 
	//							listaDeProveedoresCloud[posicionCloudRecomendado].getListaDeServicios().get(i/5).getPilares()[4].getValorDelPilar()));
	//					break;
	//
	//				}else if(cantidadDeProveedoresQueCuentanConElPilar > 1)
	//				{
	//					posicionCloudRecomendado = -1;
	//					for (int k = 0; k < proveedoresQueCuentanConElPilar.length; k++) {
	//						String[] posProveedoresQueCuentanConElPilar = proveedoresQueCuentanConElPilar[j].split(",");
	//						
	////						if()
	//					}
	//					if(cantidadDeProveedoresQueCuentanConElPilar > 2)
	//					{
	//						
	//					}else
	//					{
	//						
	//					}
	//
	//				}
	////				else if(cantidadDeProveedoresQueCuentanConElPilar == 3)
	////				{
	////
	////				}
	//				//				if(matrizDePilaresDeServicios[i][j] == 1 )
	//				//				{
	//				//					proveedoresQueCuentanConElPilar[j] = 1;
	//				//					cantidadDeProveedoresQueCuentanConElPilar++;
	//				//				}				
	//
	//			}
	//
	////			if(cantidadDeProveedoresQueCuentanConElPilar == 0)
	////			{
	////
	////
	////			}else if(cantidadDeProveedoresQueCuentanConElPilar == 1)
	////			{
	////
	////			}else if(cantidadDeProveedoresQueCuentanConElPilar == 2)
	////			{
	////
	////			}else if(cantidadDeProveedoresQueCuentanConElPilar == 3)
	////			{
	////
	////			}
	//
	//
	//		}
	//
	//
	//	}

	//	public int


	/** Carta Trampa*/



	public static void main(String[] args) {



		SistemaDeRecomendacion sis = new SistemaDeRecomendacion();




		System.out.println("Top de pilares"	);

		System.out.println(""	);

		for (int i = 0; i < 5; i++) {

			System.out.println( "" +   sis.getCliente().getTopDePilaresDelCliente()[i].getNombreDelPilar());
		}

		System.out.println(""	);
		System.out.println(""	);

		System.out.println("Recomendación de tecnologías Multi-Cloud Computing - Test"	);
		System.out.println(""	);


		for (int i = 0; i < sis.listaDeServiciosRecomendados.size(); i++) {
			System.out.println(sis.listaDeServiciosRecomendados.get(i).getNombreDeServicio());

		}


		//		for (int i = 0; i < args.length; i++) {
		//			System.out.println(	"hhey" + 	sis.topEleccionDePilares[i].getNombreDelPilar());
		//		}
		//		
		//		
		//		
		//		for (int i = 0; i < sis.getCliente().getTopDePilaresDelCliente().length; i++) {
		//			
		//			System.out.println(sis.getCliente().getTopDePilaresDelCliente()[i]);
		//		}
		////		
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[0][0] + " - " + sis.tablaComparacionDeServiciosConPilares[0][1] + " - " + sis.tablaComparacionDeServiciosConPilares[0][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[1][0] + " - " + sis.tablaComparacionDeServiciosConPilares[1][1] + " - " + sis.tablaComparacionDeServiciosConPilares[1][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[2][0] + " - " + sis.tablaComparacionDeServiciosConPilares[2][1] + " - " + sis.tablaComparacionDeServiciosConPilares[2][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[3][0] + " - " + sis.tablaComparacionDeServiciosConPilares[3][1] + " - " + sis.tablaComparacionDeServiciosConPilares[3][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[4][0] + " - " + sis.tablaComparacionDeServiciosConPilares[4][1] + " - " + sis.tablaComparacionDeServiciosConPilares[4][2] + "\n");
		//
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[5][0] + " - " + sis.tablaComparacionDeServiciosConPilares[5][1] + " - " + sis.tablaComparacionDeServiciosConPilares[5][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[6][0] + " - " + sis.tablaComparacionDeServiciosConPilares[6][1] + " - " + sis.tablaComparacionDeServiciosConPilares[6][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[7][0] + " - " + sis.tablaComparacionDeServiciosConPilares[7][1] + " - " + sis.tablaComparacionDeServiciosConPilares[7][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[8][0] + " - " + sis.tablaComparacionDeServiciosConPilares[8][1] + " - " + sis.tablaComparacionDeServiciosConPilares[8][2]);
		//		System.out.println(sis.tablaComparacionDeServiciosConPilares[9][0] + " - " + sis.tablaComparacionDeServiciosConPilares[9][1] + " - " + sis.tablaComparacionDeServiciosConPilares[9][2] + "\n");
		//



	}


}
