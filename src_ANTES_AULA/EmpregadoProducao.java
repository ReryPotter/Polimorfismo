// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO em JAVA
// Ano/S: 2025/1S
// ----------------------------------------
 
// Classe 'EmpregadoProducao' que é herança de 'Empregado'
// - contém atributos e define métodos específicos de 'EmpregadoProducao'
// - implementa (define) o método que era 'abstract' em 'Empregado'
// ------------------------------------------------------------------------
public class EmpregadoProducao extends Empregado 
{
   // atributo(s) específico(s) deste tipo de 'Empregado'
   private double valorPecaProduzida; // salário por hora
   private double qtdPecaProduzida; // horas trabalhadas durante a semana

   // construtor de oito argumentos
   public EmpregadoProducao(
      String argNome,
      String argSobrenome,
      String argCPF,
      int    argDay,
      int    argMonth,
      int    argYear,
      double argValorPecaProduzida,
      double argQtdPecaProduzida )
   {
      super( argNome, argSobrenome, argCPF, argDay, argMonth, argYear ); // passa para o construtor de 'Empregado'
      setValorPecaProduzida( argValorPecaProduzida ); // valida a remuneração por hora
      setQtdPecaProduzida( argQtdPecaProduzida ); // valida as horas trabalhadas
   } // fim do construtor

   // configura a remuneração
   public void setValorPecaProduzida( double argValorPecaProduzida )
   {
      valorPecaProduzida = ( argValorPecaProduzida < 0.0 ) ? 0.0 : argValorPecaProduzida;
   } // fim do método setSalarioPorHora

   // retorna a remuneração
   public double getValorPecaProduzida()
   {
      return valorPecaProduzida;
   } // fim do método setSalarioPorHora

   // configura as horas trabalhadas
   public void setQtdPecaProduzida( double argQtdPecaProduzida )
   {
      qtdPecaProduzida = ( ( argQtdPecaProduzida >= 0.0 ) && ( argQtdPecaProduzida <= 168.0 ) ) ?
         argQtdPecaProduzida : 0.0;
   } // fim do método setQtdHorasSemanais

   // retorna as horas trabalhadas
   public double getQtdPecaProduzida()
   {
      return qtdPecaProduzida;
   } // fim do método getQtdHorasSemanais

   // calcula os rendimentos; sobrescreve o método 'vencimentos' em 'Empregado'
   public double vencimentos()                                            
   {                                                                   
      if ( getQtdPecaProduzida() <= 40 ) // nenhuma hora extra                           
         return getValorPecaProduzida() * getQtdPecaProduzida();                                
      else                                                            
         // paga horas normais e 50% a mais por hora extra
         return 40 * getValorPecaProduzida()  * getQtdPecaProduzida();
   } // fim do método vencimentos              

   // retorna a representação de String do objeto
   public String toString()                                              
   {                                                                     
      return String.format( "Empregado producao: %s\n%s: R$%,.2f; %s: %,.2f",
         super.toString(), "Valor da Peça Produzida", getValorPecaProduzida(),                     
         "Qtd Peças produzidas", getQtdPecaProduzida() );                                   
   } // fim do método toString
   
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.6: HourlyEmployee.java                                         *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/