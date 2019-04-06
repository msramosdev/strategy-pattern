package br.com.mramosdev.model.helper;

import br.com.mramosdev.exceptions.InfiniteValueException;

public class JacareiImpostos implements Impostos {

	@Override
	public double calculateISS(double value) {
		double r = value * 1.05;
		
		if (!Double.isFinite(r)) {
			throw new InfiniteValueException("An overflow has ocurred.");
		}
		
		return r;
	}

}