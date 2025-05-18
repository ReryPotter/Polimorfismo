// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO em JAVA
// Ano/S: 2025/1S
// ----------------------------------------
 
// Classe 'EmpregadoComissionadoMaisFixo' que é herança de 'EmpregadoComissionado'
// - contém atributo e define métodos específicos de 'EmpregadoComissionadoMaisFixo'
// - implementa (define) o método que era 'abstract' em 'Empregado'
// ---------------------------------------------------------------------------------

public class EmpregadoComissionadoMaisFixo extends EmpregadoComissionado
{
   // atributo(s) específico(s) deste tipo de 'Empregado'
   private double salarioBase; // salário de base por semana

   // construtor de nove argumentos
   public EmpregadoComissionadoMaisFixo(
      String argNome,
      String argSobrenome,
      String argCPF,
      int    argDay,
      int    argMonth,
      int    argYear,
      double argVendasBrutas,
      double argTaxaComissao,
      double argSalarioBase )
   {
       // passa para o construtor de 'EmpregadoComissionado'
       super( argNome, argSobrenome, argCPF, argDay, argMonth, argYear, argVendasBrutas, argTaxaComissao );
      setSalarioBase( argSalarioBase ); // valida e armazena salário-base
   } // fim do construtor

   // configura o salário-base                                    
   public void setSalarioBase( double argSalarioBase )
   {
      salarioBase = ( argSalarioBase < 0.0 ) ? 0.0 : argSalarioBase; // não-negativo
   } // fim do método setSalarioBase                         

   // retorna o salário-base                                   
   public double getSalarioBase()
   {
      return salarioBase;
   } // fim do método getSalarioBase                            

   // calcula os vencimentos; sobrescreve o método 'vencimentos' em 'EmpregadoComissionado'
   public double vencimentos()                                             
   {                                                                    
      return getSalarioBase() + super.vencimentos();                        
   } // fim do método vencimentos              

   // retorna a representação String do objeto
   public String toString()                                            
   {                                                                   
      return String.format( "%s %s; %s: R$%,.2f",                       
         "(Mais Fixo)", super.toString(),                            
         "Salário Base", getSalarioBase() );                             
   } // fim do método toString
   
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.8: BaseplusCommissionEmployee.java                             *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/