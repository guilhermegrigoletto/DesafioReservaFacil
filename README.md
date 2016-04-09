# DesafioReservaFacil
Projeto desafio
A implementação foi feita em Java 1.5, IDE Eclipse, utilizando Maven 3 como ferramenta de build e gerenciar dependências. 
As dependências utilizadas foram : 
   JUnit 4.4 para testes unitários
   Joda-time 2.9.3 para comparação de datas

Utilizei a interface transacao.Transacao para abstrair o comportamento diferente para cada transação e assim tornar o código desacoplado de quem usa
bastando criar a transação por uma Factory(TransacaoFactory) que encapsula as possíveis transações. A classe TransferenciaFinanceira é usada
para armazenar os dados (POJO), assim como chamar o cálculo da taxa, de maneira encapsulada.
Para cálculo de valores foi utilizado a classe BigDecimal para não ter problema de arredondamento.

Foi criado um método main para poder executar o programa, ele está localizado em src/main/java/rf/App.java

Foram criados testes unitários em JUnit localizados em src/test/java para testar o negócio que cada Transação deve executar.
