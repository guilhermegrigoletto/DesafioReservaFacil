package transacao;

import java.math.BigDecimal;
import java.util.Calendar;

import util.DataUtil;

public class TransacaoC implements Transacao {

	private static final double TAXA_ATE_5_DIAS_CADASTRO = 0.083;
	private static final double TAXA_ATE_10_DIAS_CADASTRO = 0.074;
	private static final double TAXA_ATE_15_DIAS_CADASTRO = 0.067;
	private static final double TAXA_ATE_20_DIAS_CADASTRO = 0.054;
	private static final double TAXA_ATE_25_DIAS_CADASTRO = 0.043;
	private static final double TAXA_ATE_30_DIAS_CADASTRO = 0.021;
	private static final double TAXA_MAIOR_30_DIAS_CADASTRO = 0.012;

	public BigDecimal calcularTaxa(TransferenciaFinanceira transacaoFinanceira) {
			int numeroDiasDiferenca = DataUtil.calcularDiferencaEntreDatasEmDias(Calendar.getInstance(), transacaoFinanceira.getDataAgendamento());
			
			if(numeroDiasDiferenca <= 5) {
				return new BigDecimal(TAXA_ATE_5_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} else if (numeroDiasDiferenca > 5 && numeroDiasDiferenca <= 10) {
				return new BigDecimal(TAXA_ATE_10_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} else if (numeroDiasDiferenca > 10 && numeroDiasDiferenca <= 15) {
				return new BigDecimal(TAXA_ATE_15_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} else if (numeroDiasDiferenca > 15 && numeroDiasDiferenca <= 20) {
				return new BigDecimal(TAXA_ATE_20_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} else if (numeroDiasDiferenca > 20 && numeroDiasDiferenca <= 25) {
				return new BigDecimal(TAXA_ATE_25_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} else if (numeroDiasDiferenca > 25 && numeroDiasDiferenca <= 30) {
				return new BigDecimal(TAXA_ATE_30_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} else {
				return new BigDecimal(TAXA_MAIOR_30_DIAS_CADASTRO).multiply(transacaoFinanceira.getValorTransferencia());
			} 
	}

}
