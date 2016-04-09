package transacao;

import java.math.BigDecimal;

public class TransacaoD implements Transacao{

	public BigDecimal calcularTaxa(TransferenciaFinanceira transacaoFinanceira) {
		BigDecimal valorTransferencia = transacaoFinanceira.getValorTransferencia();
		
		if ( valorTransferencia.doubleValue() <= 25000 ) {
			return TransacaoFactory.getTransacoByTipo(TipoTransacao.A).calcularTaxa(transacaoFinanceira);
		} else if ( valorTransferencia.doubleValue() > 25000 && valorTransferencia.doubleValue() <= 120000 ) {
			return TransacaoFactory.getTransacoByTipo(TipoTransacao.B).calcularTaxa(transacaoFinanceira);
		} else {
			return TransacaoFactory.getTransacoByTipo(TipoTransacao.C).calcularTaxa(transacaoFinanceira);
		} 
	}

}
