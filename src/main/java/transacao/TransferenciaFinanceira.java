package transacao;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TransferenciaFinanceira implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	private BigDecimal taxaCalculada;
	private Calendar dataAgendamento;
	private TipoTransacao tipoTransacao;

	public TransferenciaFinanceira(String contaOrigem, String contaDestino,
			BigDecimal valorTransferencia, Calendar dataAgendamento, TipoTransacao tipo) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.dataAgendamento = dataAgendamento;
		this.tipoTransacao = tipo;
		this.calcularTaxa();
	}
	
	private void calcularTaxa() {
		this.taxaCalculada = TransacaoFactory.getTransacoByTipo(tipoTransacao).calcularTaxa(this);
		this.taxaCalculada = this.taxaCalculada.setScale(2, RoundingMode.CEILING);
	}
	
	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}

	public Calendar getDataAgendamento() {
		return dataAgendamento;
	}
	
	public BigDecimal getTaxaCalculada() {
		return taxaCalculada;
	}

	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return  "[" + formatter.format(dataAgendamento.getTime()) +"] De conta " + contaOrigem + " para " + contaDestino + " R$" + valorTransferencia + " (Taxa " + taxaCalculada + ") transação " + tipoTransacao;
	}
	
	public void salvar() {
		   try{
				FileOutputStream fout = new FileOutputStream("c:\\transferencias.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fout);   
				oos.writeObject(this);
				oos.close();
				System.out.println("Salvo");
				   
			   }catch(Exception ex){
				   ex.printStackTrace();
			   }
	}
	
}
