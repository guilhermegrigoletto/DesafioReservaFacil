package transacao;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import transacao.TipoTransacao;
import transacao.TransferenciaFinanceira;
import util.DataUtil;

public class TransacaoCTest {
	
	private String contaOrigem = "12345-6";
	private String contaDestino = "98765-5";
	private BigDecimal valorTransferencia = new BigDecimal("100");
	private static final int DELTA_COMPARACAO = 2;
	
	@Test
	public void testDaqui31Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(31) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(1.2, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui28Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(28) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(2.1, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}	
	
	@Test
	public void testDaqui30Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(30) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(2.1, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui25Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(25) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(4.3, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui22Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(22) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(4.3, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui20Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(20) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(5.4, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	
	@Test
	public void testDaqui18Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(18) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(5.4, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui15Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(15) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(6.7, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui13Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(13) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(6.7, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui10Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(10) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(7.4, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui8Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(8) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(7.4, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui5Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(5) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8.3, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
	
	@Test
	public void testDaqui2Dias(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, DataUtil.getDataDaquiXDias(2) , TipoTransacao.C);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(8.3, taxaCalculada.doubleValue(), DELTA_COMPARACAO);
	}
}
