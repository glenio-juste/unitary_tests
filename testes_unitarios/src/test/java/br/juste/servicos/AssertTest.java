package br.juste.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.juste.entidades.Usuario;

/**
 * @author Glenio Juste 
 * 
 * Explica��o Assertivas
 */

public class AssertTest {
	
	@Test
	public void teste() {
		
		
		//Assert.assertTrue(condition);
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		
		
		//Assert.assertEquals(expected, actual);
		Assert.assertEquals(1, 1);
		Assert.assertEquals(0.51, 0.51, 0.01); // compara��o de double, acrescentar 3� par�metro (percentual de erro)
		Assert.assertEquals(0.51234, 0.512, 0.001);  // percentual de erro em 0.001
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		
		// int, double, float
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		// sempre prestar aten��o na ordem dos valores nos teste
		Assert.assertEquals("bola", "bola");
		Assert.assertNotEquals("bola", "casa");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		//Assert.assertTrue("bola".startsWith(prefix));
		Assert.assertTrue("bola".startsWith("bola"));
		
		
		// precisa do equals no objeto
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = null;
		
		Assert.assertEquals(u1, u2);
		
		Assert.assertSame(u2, u2); // compara as inst�ncias
		Assert.assertNotSame(u1, u2); // compara as inst�ncias
		
		Assert.assertNull(u3);
		Assert.assertNotNull(u1);
		
	}

}
