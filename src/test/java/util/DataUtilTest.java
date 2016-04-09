package util;
import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Test;

import util.DataUtil;

public class DataUtilTest {

	@Test
	public void testEntreHojeEAmanhaDeveRetornar1Dia() {
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);
		int diferencaDias = DataUtil.calcularDiferencaEntreDatasEmDias(Calendar.getInstance(), amanha);
		Assert.assertEquals(1, diferencaDias);
	}
	
	@Test
	public void testEntreHojeE5DiasDeveRetornar5Dias() {
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 5);
		int diferencaDias = DataUtil.calcularDiferencaEntreDatasEmDias(Calendar.getInstance(), amanha);
		Assert.assertEquals(5, diferencaDias);
	}
	
	@Test
	public void testMontarDataDaqui1Semana() {
		Calendar hoje = Calendar.getInstance();
		Calendar umaSemanaDepois = DataUtil.getDataDaquiXDias(7);
		
		int diferencaDias = DataUtil.calcularDiferencaEntreDatasEmDias(hoje, umaSemanaDepois);
		Assert.assertEquals(7, diferencaDias);
	}
}
