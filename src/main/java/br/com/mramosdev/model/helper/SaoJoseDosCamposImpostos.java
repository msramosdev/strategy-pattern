package br.com.mramosdev.model.helper;

public class SaoJoseDosCamposImpostos implements Impostos {

	@Override
	public double calculateISS(double value) {
		return value * 1.02;
	}

}
