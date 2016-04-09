package transacao;

public enum TipoTransacao {
	A("A"),B("B"),C("C"),D("D");
	
	private String value;
	
	private TipoTransacao(String valor) {
		this.value = valor;
	}
	

	public String getValue() {
		return value;
	}

	public static TipoTransacao byValue(String valor) {
		if(valor.equals(A.getValue())) { 
			return TipoTransacao.A;
		} else if (valor.equals(B.getValue())) {
			return TipoTransacao.B;
		} else if (valor.equals(C.getValue())) {
			return TipoTransacao.C;
		} else if (valor.equals(D.getValue())) {
			return TipoTransacao.D;
		} else {
			throw new RuntimeException(valor + " nao é um valor valido (A,B,C ou D somente)");
		}
	}
}
