package com.example.util;

public class Factura {
	Calculadora calc;

		CalculadoraInt calculadora;
	
	
	public Factura(Calculadora calc, CalculadoraInt c) {
		super();
		this.calc = calc;
		this.calculadora=c;
	}
	
	public double calcTotal(int cantidad, double precio) {
		return calc.suma(cantidad, precio);
	}
	
	public void emitir() {
		calculadora.guardar();
	}
}
