// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO em JAVA
// Ano/S: 2025/1S
// ----------------------------------------
 
// Classe 'EmpregadoAssalariado' que é herança de 'Empregado'
// - contém atributo e define métodos específicos de 'EmpregadoAssalariado'
// - implementa (define) o método que era 'abstract' em 'Empregado'
// ------------------------------------------------------------------------
public class EmpregadoAssalariado extends Empregado
{
   // atributo(s) específico(s) deste tipo de 'Empregado'
   private double salarioSemanal;

   // construtor com sete argumentos
   public EmpregadoAssalariado(
      String argNome,
      String argSobrenome,
      String argCPF,
      int    argDay,
      int    argMonth,
      int    argYear,
      double argSalarioSemanal )
   {
      super( argNome, argSobrenome, argCPF, argDay, argMonth, argYear ); // passa para o construtor de 'Empregado'
      setSalarioSemanal( argSalarioSemanal ); // valida e armazena o salário
   } // fim do construtor

   // configura o salário
   public void setSalarioSemanal( double argSalarioSemanal )
   {
      salarioSemanal = argSalarioSemanal < 0.0 ? 0.0 : argSalarioSemanal;
   } // fim do método setSalarioSemanal

   // retorna o salário
   public double getSalarioSemanal()
   {
      return salarioSemanal;
   } // fim do método getSalarioSemanal

   // calcula os rendimentos;
   // implementa o método abstrato 'vencimentos' anunciado em 'Empregado'
   public double vencimentos()                                            
   {                                                                   
      return getSalarioSemanal();                                        
   } // fim do método vencimentos              

   // retorna a representação String do objeto
   public String toString()                                     
   {                                                            
      return String.format( "Empregado assalariado: %s\n%s: R$%,.2f",
         super.toString(), "Salário semanal", getSalarioSemanal() );
   } // fim do método toString
   
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 10.5: SalariedEmployee.java                                       *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/