package es.cursojava.service;

import es.cursojava.dto.CalculadoraDTO;

public class CalculadoraService {

	public String calcular(CalculadoraDTO calculadoraDTO) {
		String resultado = "";
		switch (calculadoraDTO.getOperacion()) {
			case "suma":
				resultado = "Resultado suma: " + (calculadoraDTO.getNum1() + calculadoraDTO.getNum2());
				break;
			case "resta":
				resultado = "Resultado resta: " + (calculadoraDTO.getNum1() - calculadoraDTO.getNum2());
				break;
			case "multiplica":
				resultado = "Resultado multiplicacion: " + (calculadoraDTO.getNum1() * calculadoraDTO.getNum2());
				break;
			case "divide":
				if (calculadoraDTO.getNum2() != 0) {
					resultado = "Resultado division: " + (calculadoraDTO.getNum1() / calculadoraDTO.getNum2());
				} else {
					resultado = "Error: Division por cero";
				}
				break;
			default:
				resultado = "Operacion no valida";

		}
		return resultado;
	}

}
