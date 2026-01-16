package es.cursojava.dto;

public class CalculadoraDTO {
	private String	 operacion;
	private int      num1;
	private int      num2;
	public CalculadoraDTO(String operacion, int num1, int num2) {
		super();
		this.operacion = operacion;
		this.num1 = num1;
		this.num2 = num2;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
}
