package fp;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class Calculator {


	/*
     * este metodo devuelve el Class del object que le pasamos
     */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}


	/*
     * devuelve una lista con los n números de la serie de fibonacci.
     */
	public static List<Integer> fibonacci(int n) {
		ArrayList<Integer> array;
		array = new ArrayList<Integer>();
		Integer integer = new Integer(n);
		Integer e = null;
		array.add(e);
		return array;
	}

	
	public static int[] saltitos(int n, int s){
		if(s==0)
			return new int[0];
		int length=(n-1)/s;
		int saltos[]=new int[length];
		int i=0;
		while(n>s){
			n-=s;
			saltos[i]=n;
			i++;
		}
		return saltos;
	}
	
	public static int[] divisores(int n){
		int length=0;
		if(n>0){
			for(int i=1; i<=n; i++)
				if(n%i==0)
					length++;
		}else return null;
		int div[] = new int[length];
		try{	
			for (int i = n, j = 0; i > 0; i--) {
				if(n % i == 0){
					div[j] = i;
					j++;
				}
			}
			return div;
		}catch(IndexOutOfBoundsException e){
			return null;
		}
		
	}

	
	public static boolean palindromo(String frase){
		
		if(frase==null)
			return false;
		String cadena="";
		String tildes = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		String ascii = "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		String reverseFrase="";
		frase=frase.toLowerCase();
		
		for(int i=0;i<frase.length();i++)
			if(Character.isLetter(frase.charAt(i)))
				if(tildes.indexOf(frase.charAt(i))!=-1)
					cadena+=ascii.charAt(tildes.indexOf(frase.charAt(i)));
				else
					cadena+=frase.charAt(i);
		for(int i=cadena.length()-1;i>=0;i--)
			reverseFrase+=cadena.charAt(i);
		if(cadena.equals(reverseFrase))
			return true;
		else return false;
	}

	  public static String hablame(int numero){
		  
	  String[] decenas = {"Cero","Diez","Veinte","Treinta","Cuarenta","Cincuenta",
			  "Sesenta","Setenta","Ochenta","Noventa"};

	  String[] unidades = {"","uno","dos","tres","cuatro","cinco","seis","siete",
			  "ocho","nueve","Diez","Once","Doce","Trece","Catorce","Quince","Dieciseis",
			  "Diecisiete","Dieciocho","Diecinueve"};
  
	  String numescrito="";
	  
	  if(numero==0){
		  numescrito="";
		  numescrito=decenas[0];
		  return numescrito;
	  }
	  else if(numero<20){
		  numescrito="";
		  numescrito=unidades[numero];
		  return numescrito;
	  }
	  else if((numero%10)==0){
		  numescrito="";
		  numescrito=decenas[numero/10];
		  return numescrito;
	  }
	  else{
		  numescrito="";
		  numescrito=decenas[numero/10]+" y "+unidades[numero%10];
		  return numescrito;
	  }
	 }
	
	public static boolean bisiesto(String fecha){
		int anyo;
		try {
			anyo = Integer.parseInt(fecha.substring(6));
		}catch (NumberFormatException e) {
			return false;
		}catch(IndexOutOfBoundsException i){
			return false;
		}
		if((anyo%100)==0 && (anyo%400)!=0)
			return false;
		if((anyo%4)==0)
			return true;
		else
			return false;
	}


	public static boolean fechaValida(String fecha){
		int dia, mes, anyo;
		
		try{
			//01-01-2001
			dia=Integer.parseInt(fecha.substring(0, 2));
			mes=Integer.parseInt(fecha.substring(3,5));
			anyo=Integer.parseInt(fecha.substring(6));
		}catch (NumberFormatException e) {
			return false;
		}catch(IndexOutOfBoundsException i){
			return false;
		}
		if(anyo>0){
			switch(mes){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:				
				if(dia<=31 && dia>0)
					return true;
					break;
			case 4:
			case 6:
			case 9:
			case 11:
				if(dia<=30 && dia>0)
					return true;
					break;
			case 2:
				if(dia<=28 && dia>0)
					return true;
					break;
			}
		}		
		return false;
	}
}

