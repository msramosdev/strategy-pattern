import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import br.com.mramosdev.exceptions.InfiniteValueException;
import br.com.mramosdev.model.helper.Impostos;
import br.com.mramosdev.model.helper.JacareiImpostos;
import br.com.mramosdev.model.helper.SaoJoseDosCamposImpostos;


@RunWith(Theories.class)
public class ImpostoTest {
	
	@DataPoints("calculateISSJacarei")
	public static double [][] jacareiISS_DataPoint = new double[][] { { 100, 105 }, { 200, 210 } };
	
	@DataPoints("calculateISSSaoJoseDosCampos")
	public static double [][] saoJoseDosCamposISS_DataPoint = new double[][] { { 100, 102 }, { 200, 204 } };

	@Theory()
	public void calculateISS_CalledWithJacareiImplReturnsISS_Jacarei(@FromDataPoints("calculateISSJacarei") double [] a) {
		Impostos impostos = new JacareiImpostos();
		double vi = impostos.calculateISS(a[0]);
		double er = a[1];
		
		assertEquals(er, vi, 0.001);
	}
	
	@Theory()
	public void calculateISS_CalledWithSaoJoseDosCamposImplReturnsISS_SaoJoseDosCampos(@FromDataPoints("calculateISSSaoJoseDosCampos") double [] a) {
		Impostos impostos = new SaoJoseDosCamposImpostos();
		double vi = impostos.calculateISS(a[0]);
		double er = a[1];
		
		assertEquals(er, vi, 0.001);
	}
	
	@Test
	public void calculatedISS_CalledWithJacareiImplAndMaximumValues_throws() {
		InfiniteValueException ive = null;
		
		try {
			Impostos impostos = new JacareiImpostos();
			impostos.calculateISS(Double.MAX_VALUE);
		} catch (InfiniteValueException e) {
			ive = e;
		}
		
		assertNotNull(ive);
		assertEquals(InfiniteValueException.class, ive.getClass());
		assertEquals("An overflow has ocurred.", ive.getMessage());
	}
	
}
