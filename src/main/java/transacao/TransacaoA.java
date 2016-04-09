package transacao;

import java.math.BigDecimal;

public class TransacaoA implements Transacao {
	private static final double TAXA_PERCENTUAL_TRANSFERENCIA_A = 0.03;
	private static final int TAXA_FIXA_TRANSFERENCIA_A = 2;
	
	public BigDecimal calcularTaxa(TransferenciaFinanceira transacaoFinanceira) {
		
		BigDecimal taxaCalculada = new BigDecimal(TAXA_FIXA_TRANSFERENCIA_A);
		BigDecimal percentualTransferencia = transacaoFinanceira.getValorTransferencia().multiply(new BigDecimal(TAXA_PERCENTUAL_TRANSFERENCIA_A));
		taxaCalculada = taxaCalculada.add(percentualTransferencia);
		return taxaCalculada;
		
	}

}
