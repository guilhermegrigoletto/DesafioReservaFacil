package transacao;

import java.math.BigDecimal;
import java.util.Calendar;

import util.DataUtil;

public class TransacaoB implements Transacao {

	private static final int TAXA_PEDIDO_COM_MAIS_30_DIAS_CADASTRO = 8;
	private static final int TAXA_PEDIDO_COM_MENOS_30_DIAS_CADASTRO = 10;

	public BigDecimal calcularTaxa(TransferenciaFinanceira transacaoFinanceira) {
		int numeroDiasDiferencaEntreAgendamentoECadastro = DataUtil.calcularDiferencaEntreDatasEmDias(transacaoFinanceira.getDataAgendamento(), Calendar.getInstance());
		if(numeroDiasDiferencaEntreAgendamentoECadastro <= 30){
			return new BigDecimal(TAXA_PEDIDO_COM_MENOS_30_DIAS_CADASTRO);
		} else{
			return new BigDecimal(TAXA_PEDIDO_COM_MAIS_30_DIAS_CADASTRO);
		}
	}

}
