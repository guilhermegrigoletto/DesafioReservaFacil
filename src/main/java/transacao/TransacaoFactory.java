package transacao;

public class TransacaoFactory {
	public static Transacao getTransacoByTipo(TipoTransacao tipoTransacao) {
		
		if(TipoTransacao.A.equals(tipoTransacao)) {
			return new TransacaoA();
		} else if (TipoTransacao.B.equals(tipoTransacao)) {
			return new TransacaoB();
		}else if (TipoTransacao.C.equals(tipoTransacao)) {
			return new TransacaoC();
		}else if (TipoTransacao.D.equals(tipoTransacao)) {
			return new TransacaoD();
		} else {
			throw new RuntimeException("Tipo de transacao informada nao e valida");
		}
		
	}
}
