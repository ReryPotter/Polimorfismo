// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO em JAVA
// Ano/S: 2025/1S
// ----------------------------------------
 
// Classe 'EmpregadoHorista' que é herança de 'Empregado'
// - contém atributos e define métodos específicos de 'EmpregadoHorista'
// - implementa (define) o método que era 'abstract' em 'Empregado'
// ------------------------------------------------------------------------
public class EmpregadoHorista extends Empregado
{
   // atributo(s) específico(s) deste tipo de 'Empregado'
   private double salarioPorHora; // salário por hora
   private double qtdHorasSemanais; // horas trabalhadas durante a semana

   // construtor de oito argumentos
   public EmpregadoHorista(
      String argNome,
      String argSobrenome,
      String argCPF,
      int    argDay,
      int    argMonth,
      int    argYear,
      double argSalarioPorHora,
      double argQtdHorasSemanais )
   {
      super( argNome, argSobrenome, argCPF, argDay, argMonth, argYear ); // passa para o construtor de 'Empregado'
      setSalarioPorHora( argSalarioPorHora ); // valida a remuneração por hora
      setQtdHorasSemanais( argQtdHorasSemanais ); // valida as horas trabalhadas
   } // fim do construtor

   // configura a remuneração
   public void setSalarioPorHora( double argSalarioPorHora )
   {
      salarioPorHora = ( argSalarioPorHora < 0.0 ) ? 0.0 : argSalarioPorHora;
   } // fim do método setSalarioPorHora

   // retorna a remuneração
   public double getSalarioPorHora()
   {
      return salarioPorHora;
   } // fim do método setSalarioPorHora

   // configura as horas trabalhadas
   public void setQtdHorasSemanais( double argQtdHorasSemanais )
   {
      qtdHorasSemanais = ( ( argQtdHorasSemanais >= 0.0 ) && ( argQtdHorasSemanais <= 168.0 ) ) ?
         argQtdHorasSemanais : 0.0;
   } // fim do método setQtdHorasSemanais

   // retorna as horas trabalhadas
   public double getQtdHorasSemanais()
   {
      return qtdHorasSemanais;
   } // fim do método getQtdHorasSemanais

   // calcula os rendimentos; sobrescreve o método 'vencimentos' em 'Empregado'
   public double vencimentos()                                            
   {                                                                   
      if ( getQtdHorasSemanais() <= 40 ) // nenhuma hora extra                           
         return getSalarioPorHora() * getQtdHorasSemanais();                                
      else                                                            
         // paga horas normais e 50% a mais por hora extra
         return 40 * getSalarioPorHora() + ( getQtdHorasSemanais() - 40 ) * getSalarioPorHora() * 1.5;
   } // fim do método vencimentos              

   // retorna a representação de String do objeto
   public String toString()                                              
   {                                                                     
      return String.format( "Empregado horista: %s\n%s: R$%,.2f; %s: %,.2f",
         super.toString(), "Salário por hora", getSalarioPorHora(),                     
         "Qtd horas trabalhadas na semana", getQtdHorasSemanais() );                                   
   } // fim do método toString
   
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.6: HourlyEmployee.java                                         *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/