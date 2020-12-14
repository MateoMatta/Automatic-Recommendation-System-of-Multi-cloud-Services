package mundo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServicioCloud {

	/** Pilares de los criterios de selección:
	 * -	Optimización de Costos
	 * -	Excelencia Operativa
	 * - 	Eficacia del Rendimiento
	 * -	Fiabilidad 
	 * -	Seguridad */


	public static String[]  PILARES_DE_CRITERIOS_DE_SELECCION = {"Optimizacion de Costos", "Excelencia Operativa", "Eficacia del Rendimiento", "Fiabilidad", "Seguridad" };


	private String tipoDeServicio;	

	private String nombreDeServicio;

	private Pilar[] pilares;



	public ServicioCloud(String tipoDeServicio, String nombreDeServicio, int valorCos, int valorEO, int valorEf, int valorFia, int valorSeg) {
		super();
		this.tipoDeServicio = tipoDeServicio;
		this.nombreDeServicio = nombreDeServicio;
		pilares = new Pilar[PILARES_DE_CRITERIOS_DE_SELECCION.length];

		pilares[0] = new Pilar(PILARES_DE_CRITERIOS_DE_SELECCION[0], valorCos);
		pilares[1] = new Pilar(PILARES_DE_CRITERIOS_DE_SELECCION[1], valorEO);
		pilares[2] = new Pilar(PILARES_DE_CRITERIOS_DE_SELECCION[2], valorEf);
		pilares[3] = new Pilar(PILARES_DE_CRITERIOS_DE_SELECCION[3], valorFia);
		pilares[4] = new Pilar(PILARES_DE_CRITERIOS_DE_SELECCION[4], valorSeg);


		//		setPilares(new int[] {valorCos,valorEO,valorEf,valorFia,valorSeg});

	}


	public String getTipoDeServicio() {
		return tipoDeServicio;
	}


	public void setTipoDeServicio(String tipoDeServicio) {
		this.tipoDeServicio = tipoDeServicio;
	}


	public String getNombreDeServicio() {
		return nombreDeServicio;
	}


	public void setNombreDeServicio(String nombreDeServicio) {
		this.nombreDeServicio = nombreDeServicio;
	}


	public Pilar[] getPilares() {
		return pilares;
	}


	public void setPilares(Pilar[] pilares) {
		this.pilares = pilares;
	}

//	public static void main(String[] args) {
//		ServicioCloud s = new ServicioCloud("sisa", "epa", 6, 9, 2, 12, 1);
//
//		Pilar mayor = null;
//
//		//		for (int i = 0; i < 5; i++) {
//		//			mayor = s.getPilares()[i];
//		//			if(i+1 != 5)
//		//			{
//		//				if(  s.getPilares()[i+1].getValorDelPilar() > mayor.getValorDelPilar())
//		//				{
//		//					s.getPilares()[i] = s.getPilares()[i+1];
//		//					s.getPilares()[i+1] = mayor;
//		////				s.getPilares()[i+1]
//		//					
//		//				}
//		//				
//		//			}
//		//		}
//		//		
//
//
//
//
////		Pilar temp;
////		Pilar [] pilares = s.getPilares();
////
////
////
////		for (int i = 0; i < pilares.length; i++)   
////		{  
////			for (int j = i + 1; j <pilares.length; j++)   
////			{  
////				if (pilares[i].getValorDelPilar() < pilares[j].getValorDelPilar())   
////				{  
////					temp = pilares[i];  
////					pilares[i] = pilares[j];  
////					pilares[j] = temp;  
////				}  
////			}  
////		}  
////
////		for (int i = 0; i < 5; i++) {
////
////			System.out.println(pilares[i].getValorDelPilar());
////		}
//		//		List<Pilar> pilares = new ArrayList<>();
//
//		//		pilares
//		//		
//		//		Collections.sort(List<Pilar> pilares);
//
//		//		  public static void main(String... sortingWithList) {
//		//		        List<SimpsonCharacter> simpsons = new ArrayList<>();
//		//		        simpsons.add(new SimpsonCharacter("Homer "));
//		//		        simpsons.add(new SimpsonCharacter("Marge "));
//		//		        simpsons.add(new SimpsonCharacter("Bart "));
//		//		        simpsons.add(new SimpsonCharacter("Lisa "));
//		//
//		//		        Collections.sort(simpsons);
//		//		        simpsons.stream().map(s -> s.name).forEach(System.out::print);
//		//
//		//		        Collections.reverse(simpsons);
//		//		        simpsons.stream().forEach(System.out::print);
//		//		    }
//
//
//	}

}
