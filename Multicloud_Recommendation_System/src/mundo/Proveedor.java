package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class Proveedor {

	//	public static String[] SERVICIOS_ESPECIALES = {"Compute Services", "Container Support", "Kubernetes Managed Service", "SQL Database", "NoSQL Database"};

	private String nombreDeProveedor;

	/*
	 * |AWS| 
	 *  Compute Service || EC2
	 * 
	 */


	private ArrayList<ServicioCloud> listaDeServicios;

	private BufferedReader br;

	private String linea;


	public Proveedor(String nombreDeProveedor, String URLArchivoDeDatosComparativaDeServicios, ArrayList<ServicioCloud> serviciosADescartar) throws Exception {
		super();
		this.nombreDeProveedor = nombreDeProveedor;
		listaDeServicios = new ArrayList<ServicioCloud>();

		br = new BufferedReader(new FileReader(URLArchivoDeDatosComparativaDeServicios));

		// Se lee el rotulo de la lista de proveedores
		linea = br.readLine();
		// Se lee el rotulo de la lista de proveedores
		String linea = br.readLine();

		String[] listaDeProveedores = linea.split(",");
		int posProveedor = -1;

		for (int i = 0; i < listaDeProveedores.length; i++) {
			if (listaDeProveedores[i].equals(nombreDeProveedor)) {
				posProveedor = i;
				break;
			}
		}
		//		serviciosADescartar = new ArrayList<ServicioCloud>();
		construirListaDeServiciosPorProveedor(br, posProveedor, serviciosADescartar);

	}

	public String getNombreDeProveedor() {
		return nombreDeProveedor;
	}

	public void setNombreDeProveedor(String nombreDeProveedor) {
		this.nombreDeProveedor = nombreDeProveedor;
	}

	public ArrayList<ServicioCloud> getListaDeServicios() {
		return listaDeServicios;
	}

	public void setListaDeServicios(ArrayList<ServicioCloud> listaDeServicios) {
		this.listaDeServicios = listaDeServicios;
	}

	public void construirListaDeServiciosPorProveedor(BufferedReader br, int posProveedor, 	ArrayList<ServicioCloud> listaDeTiposDeServiciosADescartar) {
		//		lista
		try {

			// Se lee la lista de proveedores
			linea = br.readLine();

			// 0=azure | 1=aws | 2=gcp
			// Se calcula un desfase que determina que datos se tomaran de que provedor

			int offset = 4 * (posProveedor + 1);

			// Se lee el rotulo de la lista de datos de un servicio cloud


			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");
				//				(datos[0] + " 				iguales a " +listaDeTiposDeServiciosADescartar.get(0).getTipoDeServicio() );

				boolean evitar= false;
				for (int i = 0; i < listaDeTiposDeServiciosADescartar.size(); i++) {
					if(datos[0].equals(listaDeTiposDeServiciosADescartar.get(i).getTipoDeServicio())) {
						evitar = true;
						//						();

						//						("			Curramba " + datos[0] + "        iguales a " +listaDeTiposDeServiciosADescartar.get(i).getTipoDeServicio() );
						break;

					}

				}
				
				if(evitar == false )
				{
					ServicioCloud sc = new ServicioCloud(datos[0], datos[posProveedor + 1],
							Integer.parseInt(datos[offset + posProveedor]),
							Integer.parseInt(datos[offset + posProveedor + 1]),
							Integer.parseInt(datos[offset + posProveedor + 2]),
							Integer.parseInt(datos[offset + posProveedor + 3]),
							Integer.parseInt(datos[offset + posProveedor + 4]));

					listaDeServicios.add(sc);
					//						("agregado");


				}


			}


			//			for (int i = 0; i < listaDeServicios.size(); i++) {
			//				(nombreDeProveedor + " mis: " + listaDeServicios.get(i).getTipoDeServicio());
			//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int cantidadDeServicios() {
		return listaDeServicios.size();
	}



}
