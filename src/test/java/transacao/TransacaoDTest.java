package transacao;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import transacao.TipoTransacao;
import transacao.TransferenciaFinanceira;
import util.DataUtil;

public class TransacaoDTest {
	
	private String contaOrigem = "12345-6";
	private String contaDestino = "98765-5";
	Calendar hoje = Calendar.getInstance();
	private static final int DELTA_COMPARACAO = 2;
	
	@Test
	public void testValorEDataCasoA(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("25000"), hoje , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(752, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoA2(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("22000"), hoje , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(662, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoB(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("30000"), hoje, TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(10, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoB2(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("25001"), hoje , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(10, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoB3(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("75000"), DataUtil.getDataDaquiXDias(60) , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoB4(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("120000"), DataUtil.getDataDaquiXDias(60) , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoC(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("120001"), hoje , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(9960.08, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoC2(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("150000"), DataUtil.getDataDaquiXDias(20) , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8100, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testValorEDataCasoC3(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("180000"), DataUtil.getDataDaquiXDias(60) , TipoTransacao.D);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(2160, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	
}
