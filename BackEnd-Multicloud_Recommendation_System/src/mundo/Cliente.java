package mundo;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class Cliente {

	private Pilar[] topDePilaresDelCliente;

	public Cliente() {
		super();

		topDePilaresDelCliente = new Pilar[ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION.length];


		//VALORES QUEMADOS DEL CLIENTE------------------------------------------------------------------ 
		//Terminar algoritmo ---------------------------------------------------------------------------
		//preguntasDePerfilacionDePilares()


		topDePilaresDelCliente[0] = new Pilar(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[0], 6);
		topDePilaresDelCliente[1] = new Pilar(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[1], 9);
		topDePilaresDelCliente[2] = new Pilar(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[2], 2);
		topDePilaresDelCliente[3] = new Pilar(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[3], 12);
		topDePilaresDelCliente[4] = new Pilar(ServicioCloud.PILARES_DE_CRITERIOS_DE_SELECCION[4], 1);

		ordenarElTopDePilares();
	}

	public Pilar[] getTopDePilaresDelCliente() {
		return topDePilaresDelCliente;
	}

	public void setTopDePilaresDelCliente(Pilar[] topDePilaresDelCliente) {
		this.topDePilaresDelCliente = topDePilaresDelCliente;
	}

	public void preguntasDePerfilacionDePilares()
	{
		//METODO DE PREGUNTAS | TERMINAR ---------------------------------------------------------
	}

	public void ordenarElTopDePilares()
	{
		Pilar temp;

		for (int i = 0; i < topDePilaresDelCliente.length; i++)   
		{  
			for (int j = i + 1; j <topDePilaresDelCliente.length; j++)   
			{  
				if (topDePilaresDelCliente[i].getValorDelPilar() < topDePilaresDelCliente[j].getValorDelPilar())   
				{  
					temp = topDePilaresDelCliente[i];  
					topDePilaresDelCliente[i] = topDePilaresDelCliente[j];  
					topDePilaresDelCliente[j] = temp;  
				}  
			}  
		}  			
	}


}
