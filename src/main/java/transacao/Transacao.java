package transacao;

import java.math.BigDecimal;

public interface Transacao {
	BigDecimal calcularTaxa(TransferenciaFinanceira transferencia);
}
