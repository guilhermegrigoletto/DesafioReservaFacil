package transacao;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

import transacao.TipoTransacao;
import transacao.TransferenciaFinanceira;

public class TransacaoATest {

	private static final int DELTA_COMPARACAO = 2;
	private String contaOrigem = "12345-6";
	private String contaDestino = "98765-5";
	private BigDecimal valorTransferencia = new BigDecimal("100");
	Calendar hoje = Calendar.getInstance();

	@Test
	public void testTaxaDe3PorcentoMais2ReaisFixo(){ 
		
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, hoje , TipoTransacao.A);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(5.00, taxaCalculada.doubleValue(),DELTA_COMPARACAO);
	}
	
	@Test
	public void testTaxaDe3PorcentoMais2ReaisFixoValorQuebrado(){ 
		TransferenciaFinanceira transferencia = new TransferenciaFinanceira(contaOrigem, contaDestino, new BigDecimal("133"), hoje , TipoTransacao.A);
		BigDecimal taxaCalculada = transferencia.getTaxaCalculada();
		Assert.assertEquals(5.99, taxaCalculada.doubleValue(),DELTA_COMPARACAO);
	}
}
