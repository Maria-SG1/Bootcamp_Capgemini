package com.example.util;

public class Factura {
	Calculadora calc;

	public Factura(Calculadora calc) {
		super();
		this.calc = calc;
	}
	
	public double calcTotal(int cantidad, double precio) {
		return calc.suma(cantidad, precio);
	}
}
