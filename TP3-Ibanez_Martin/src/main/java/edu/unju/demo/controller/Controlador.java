package edu.unju.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Controlador {
	
	@RequestMapping("/inicio")
	@ResponseBody
	public String inicio() {
		return "Ejercicio 1";	
	}
	
	
	@RequestMapping("/operaciones/{num1}/{num2}")
	@ResponseBody
	public String operaciones(@PathVariable("num1") int num1, @PathVariable ("num2") int num2) {
		
		int suma = num1 + num2;
		int resta = num1 - num2;
		int mult = num1 * num2;
		int div = num1 / num2;
		
		return "La suma es: " + suma + "<br>"+
				"La resta es: " + resta + "<br>"+
				"La multimiplicacion es: " + mult + "<br>"+
				"La division es: " + div;
	
	}
	
	
	// Ordena los nombres a traves de una comparacion de String 
	
	@RequestMapping("/ordenar/{n1}/{n2}/{n3}")
	@ResponseBody
	public String ordenar(@PathVariable("n1") String nom1, @PathVariable("n2") String nom2, 
						  @PathVariable("n3") String nom3) {
		
		
		if (nom1.compareTo(nom2) < 0 && nom1.compareTo(nom3) < 0 ) {
			// Al usar el compareTo comparo dos cadenas y 
			// devuelve 0 si las cadenas son iguales, -1 si la primera es menor y 1 si es mayor.
			
			if(nom2.compareTo(nom3) < 0 ) {
				return nom1 + "-" + nom2 + "-" + nom3;
			}else {
				return nom1 + "-" + nom3 + "-" + nom2;
			}
			
	    } else {
	    	if (nom2.compareTo(nom3) < 0) {
				if(nom1.compareTo(nom3) < 0 ) {
					return nom2 + "-" + nom1 + "-" + nom3;
				}else {
					return nom2 + "-" + nom3 + "-" + nom1;
				}	
		    }else {
		    	if (nom3.compareTo(nom1) < 0) {
					if(nom1.compareTo(nom2) < 0 ) {
						return nom3 + "-" + nom1 + "-" + nom2;
					}else {
						return nom3 + "-" + nom2 + "-" + nom1;
					}
		    	}
		    }
	    }
		return "Los nombres estan ordenados alfabeticamente";
	}
	
	// Trate de aplicar el metodo burbuja pero me falto usar el RequestMapping para tomar 
	// valores para un array
	/*
	@RequestMapping("/ordenar2/{[nombres]}")
	@ResponseBody	
	public static void ordenar2(@PathVariable ("nombres") String[] nombres) {
        
		int i, j; String aux;
        
        for (i = 0; i < nombres.length; i++) {
            for (j = 0; j < nombres.length - 1; j++) {                                                              
                if (nombres[j + 1].compareTo(nombres[j]) > 0) {
                    aux = nombres[j + 1];
                    nombres[j + 1] = nombres[j];
                    nombres[j] = aux;
                }
            }
        }
        System.out.println("Ordenados: " + Arrays.toString(nombres));
	}
	*/
	
	
	@RequestMapping("/beca/{nom}/{ing}")
	@ResponseBody
	public String beca(@PathVariable("nom") String nom, @PathVariable("ing") int ing) {
			
		if ( ing < 49000 ) {
			return "A " + nom + " SI le corresponde la BECA";
		}
		else { 
			return "A " + nom + " NO le corresponde la BECA";
		}

	}
		
}
