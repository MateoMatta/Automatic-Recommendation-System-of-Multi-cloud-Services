package mundo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

import java.util.ArrayList;

public class Proveedor {

	private String nombreDeProveedor;
	
	/*
	 * |AWS| 
	 *  Compute Service || EC2
	 * 
	 */


	private ArrayList<ServicioCloud> listaDeServicios;

	private BufferedReader br;

	private String linea;
	

	public Proveedor(String nombreDeProveedor, String URLArchivoDeDatosComparativaDeServicios) throws Exception {
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
		construirListaDeServiciosPorProveedor(br, posProveedor);

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

	public void construirListaDeServiciosPorProveedor(BufferedReader br, int posProveedor) {
		try {

			// Se lee la lista de proveedores
			linea = br.readLine();

			// 0=azure | 1=aws | 2=gcp
			// Se calcula un desfase que determina que datos se tomaran de que provedor

			int offset = 4 * (posProveedor + 1);

			// Se lee el rotulo de la lista de datos de un servicio cloud
			while ((linea = br.readLine()) != null) {
				String[] datos = linea.split(",");

				ServicioCloud sc = new ServicioCloud(datos[0], datos[posProveedor + 1],
						Integer.parseInt(datos[offset + posProveedor]),
						Integer.parseInt(datos[offset + posProveedor + 1]),
						Integer.parseInt(datos[offset + posProveedor + 2]),
						Integer.parseInt(datos[offset + posProveedor + 3]),
						Integer.parseInt(datos[offset + posProveedor + 4]));

				listaDeServicios.add(sc);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int cantidadDeServicios() {
		return listaDeServicios.size();
	}

	// public static void main(String[] args) throws Exception {
	//
	//
	// Proveedor pro = new Proveedor("Azure",
	// "./docs/PilaresDeServiciosDeProveedores.csv");
	//
	// System.out.println(pro.listaDeServicios.get(0).getTipoDeServicio() + " - " +
	// pro.listaDeServicios.get(0).getNombreDeServicio()+ " | " +
	// pro.listaDeServicios.get(0).getPilares()[0] + " - " +
	// pro.listaDeServicios.get(0).getPilares()[1] +" - " +
	// pro.listaDeServicios.get(0).getPilares()[2] +" - " +
	// pro.listaDeServicios.get(0).getPilares()[3]
	// +" - " + pro.listaDeServicios.get(0).getPilares()[4]);
	//
	// System.out.println(pro.listaDeServicios.get(1).getTipoDeServicio() + " - " +
	// pro.listaDeServicios.get(1).getNombreDeServicio()+ " | " +
	// pro.listaDeServicios.get(1).getPilares()[0] + " - " +
	// pro.listaDeServicios.get(1).getPilares()[1] +" - " +
	// pro.listaDeServicios.get(1).getPilares()[2] +" - " +
	// pro.listaDeServicios.get(1).getPilares()[3]
	// +" - " + pro.listaDeServicios.get(1).getPilares()[4]);
	//
	// System.out.println(pro.listaDeServicios.get(4).getTipoDeServicio() + " - " +
	// pro.listaDeServicios.get(2).getNombreDeServicio()+ " | " +
	// pro.listaDeServicios.get(2).getPilares()[0] + " - " +
	// pro.listaDeServicios.get(2).getPilares()[1] +" - " +
	// pro.listaDeServicios.get(2).getPilares()[2] +" - " +
	// pro.listaDeServicios.get(2).getPilares()[3]
	// +" - " + pro.listaDeServicios.get(2).getPilares()[4]);
	//
	//
	//
	//
	// }

	// private

}
