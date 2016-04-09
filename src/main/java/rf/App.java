package rf;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import transacao.TipoTransacao;
import transacao.TransferenciaFinanceira;

/**
 * Classe principal para executar o cadastro de transferencias financeiras.
 * @author Guilherme
 *
 */
public class App 
{
	private static final int CODIGO_SAIR = 0;
	private static final int LISTAR_TRANSFERENCIAS_CADASTRADAS = 2;
	private static final int CADASTRAR_TRANSFERENCIA = 1;
	private static final String REGEX_PADRAO_CONTA = "\\d{5}\\-\\d";
	
	private static String contaOrigem = null;
	private static String contaDestino = null;
	private static BigDecimal valorTransferencia = null;
	private static Calendar dataAgendamento = Calendar.getInstance();
	private static TipoTransacao tipoTransacao = null;
	private static Scanner reader = new Scanner(System.in);
	private static boolean isValido = false;
	
	
    public static void main( String[] args )
    {
    	List<TransferenciaFinanceira> transferenciasFeitas = new ArrayList<TransferenciaFinanceira>();
    	
    	imprimirMenu();
    	int opcaoEscolhida = reader.nextInt();
    	while(opcaoEscolhida != CODIGO_SAIR) {
    		
    		if(opcaoEscolhida == CADASTRAR_TRANSFERENCIA) {
	    		lerContaOrigem();
	    		lerContaDestino();
		        lerValorTransferencia();
		        lerDataAgendamento();
		        lerTipoAgendamento();
		        cadastrarTransferencia(transferenciasFeitas);
	        
    		} else if(opcaoEscolhida == LISTAR_TRANSFERENCIAS_CADASTRADAS) {
    			listarTransferenciasCadastradas(transferenciasFeitas);
    		}
    		
    		imprimirMenu();
        	opcaoEscolhida = reader.nextInt();
    	}
    	System.out.println("Obrigado! Volte sempre!");
    	reader.close();
    }

	private static void cadastrarTransferencia(List<TransferenciaFinanceira> transferenciasFeitas) {
		TransferenciaFinanceira transacao = new TransferenciaFinanceira(contaOrigem, contaDestino, valorTransferencia, dataAgendamento, tipoTransacao);
		System.out.println("Taxa calculada = " + transacao.getTaxaCalculada());
		transferenciasFeitas.add(transacao);
		System.out.println("Transferencia efetuada com sucesso.");
	}

	private static void listarTransferenciasCadastradas(
			List<TransferenciaFinanceira> transferenciasFeitas) {
		System.out.println("***TRANSFERENCIAS CADASTRADAS***");
		for(TransferenciaFinanceira transferencia : transferenciasFeitas) {
			System.out.println(transferencia);
		}
	}

	private static void lerTipoAgendamento() {
		isValido = false; 
		while(!isValido) {
		    
		    System.out.println( "Informe o tipo do agendamento (A/B/C/D)" );
		    String tipoTransacaoInformado = reader.next().toUpperCase();
		    try {
		    	tipoTransacao = TipoTransacao.byValue(tipoTransacaoInformado);
		    	isValido = true;
		    } catch (RuntimeException e) {
		    	System.out.println("Transacao inexistente. Escolha A, B, C ou D");
		    }
		}
	}

	private static void lerDataAgendamento() {
		isValido = false;
		while(!isValido) {
		    System.out.println( "Informe a data do agendamento (dd/mm/aaaa)" );
		    String dataAgendamentoInformado = reader.next();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    try {
		    	dataAgendamento.setTime(formatter.parse(dataAgendamentoInformado));
		    	isValido = true;
		    } catch (ParseException e) {
		    	System.out.println("Data invalida. Padrao (dd/mm/aaaa)");
		    }
		}
	}

	private static void lerValorTransferencia() {
		isValido = false;
		while(!isValido) {
			System.out.println( "Informe o valor da transferência" );
			try {
				String valorTransferenciaInformado = reader.next();
				valorTransferencia = new BigDecimal(valorTransferenciaInformado);
				isValido = true;
			} catch (Exception e) {
				System.out.println("Valor invalido");
			}
		}
		
	}

	private static void lerContaDestino() {
		isValido = false;
		while(!isValido) {
		    System.out.println( "Informe a conta destino (padrão XXXXX­X)" );
		    contaDestino = reader.next();
		    if(!contaDestino.matches(REGEX_PADRAO_CONTA)) {
		    	System.out.println("Formato de conta inválido (padrão XXXXX­X) ");
		    } else if(contaDestino.equals(contaOrigem)) {
		    	System.out.println("Conta destino nao pode ser a mesma que a conta origem ");
		    } else {
		    	isValido = true;
		    }
		}
	}

	private static void lerContaOrigem() {
		while(!isValido) {
		    System.out.println( "Informe a conta origem (padrão XXXXX­X)" );
		    contaOrigem = reader.next();
		    if(!contaOrigem.matches(REGEX_PADRAO_CONTA)) {
		    	System.out.println("Formato de conta inválido (padrão XXXXX­X) ");
		    } else {
		    	isValido = true;
		    }
		}
	}

	private static void imprimirMenu() {
		System.out.println("\n 1 - Cadastrar nova transacao");
    	System.out.println(" 2 - Listar todas transacoes cadastradas");
    	System.out.println(" 0 - Sair");
	}
}
