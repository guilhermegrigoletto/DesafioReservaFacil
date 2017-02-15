package transacao;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import transacao.TipoTransacao;
import transacao.TransferenciaFinanceira;
import util.DataUtil;

public class TransacaoBTest {
	
	private static final int DELTA_COMPARACAO = 1;
	
	@Test
	public void testDataHojeDeveRetornarTaxa10(){ 
		Calendar hoje = Calendar.getInstance();
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira("12345-6", "98765-5", new BigDecimal("100"), hoje , TipoTransacao.B);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(10, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDataDaqui20DiasDeveRetornarTaxa10(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira("12345-6", "98765-5", new BigDecimal("100"), DataUtil.getDataDaquiXDias(20) , TipoTransacao.B);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(10, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDataDaqui31DiasDeveRetornarTaxa8(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira("12345-6", "98765-5", new BigDecimal("100"), DataUtil.getDataDaquiXDias(31) , TipoTransacao.B);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDataDaqui60DiasDeveRetornarTaxa8(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira("12345-6", "98765-5", new BigDecimal("100"), DataUtil.getDataDaquiXDias(60) , TipoTransacao.B);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}

	
}
