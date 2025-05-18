// ----------------------------------------
// Prof.: CARLOS - FATEC S. J. Rio Preto
// Disc.: IED-001 - ESTRUTURAS DE DADOS
// Lab. : POLIMORFISMO em JAVA
// Ano/S: 2025/1S
// ----------------------------------------
 
// Declaração da classe DiaMesAno.
// Usa este nome para não confundir com a classe 'Date' de java.util,
// embora não haja confusão se não fizer 'import'
// ------------------------------------------------------------------

public class DiaMesAno {

    // atributos
    private int month; // 1-12
    private int day;   // 1-31 conforme o mês
    private int year;  // qualquer ano

    // construtor: chama checkMonth para confirmar o valor adequado para month;
    // chama checkDay para confirmar o valor adequado para day
    DiaMesAno(int argMonth, int argDay, int argYear) {
        
        month = checkMonth(argMonth); // valida month
        year = argYear; // poderia validar year
        day = checkDay(argDay); // valida day

        System.out.printf(
                "Após construtor do objeto 'DiaMesAno', data é: %s\n", this);
    } // fim do construtor

    // 'getter' para mês
    public int getMonth() {
        return month;
    }

    // 'getter' para dia
    public int getDay() {
        return day;
    }

    // 'getter' para ano
    public int getYear() {
        return year;
    }

    // 'setter' para mês
    public void setMonth(int argMonth) {
        month = checkMonth(argMonth); // valida month
    }

    // 'setter' para dia
    public void setDay(int argDay) {
        day = checkDay(argDay); // valida day
    }

    // 'setter' para ano
    public void setYear(int argYear) {
        year = argYear; // poderia validar year se necessário
    }

    // método utilitário para confirmar o valor adequado de month
    private int checkMonth(int argMonth) {
        if (argMonth > 0 && argMonth <= 12) // valida month
        {
            return argMonth;
        } else // month é inválido
        {
            System.out.printf(
                    "Mês inválido (%d) modificado para 1.", argMonth);
            return 1; // mantém objeto em estado consistente
        } // fim de else
    } // fim do método checkMonth

    // método utilitário para confirmar o valor adequado de day com base em month e year
    private int checkDay(int argDay) {
        int daysPerMonth[]
                = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // verifica se day está no intervalo para month
        if (argDay > 0 && argDay <= daysPerMonth[month]) {
            return argDay;
        }

        // verifica ano bissexto
        if (month == 2 && argDay == 29 && (year % 400 == 0
                || (year % 4 == 0 && year % 100 != 0))) {
            return argDay;
        }

        System.out.printf("Dia inválido (%d) modificado para 1.", argDay);
        return 1;  // mantém objeto em estado consistente
    } // fim do método checkDay

    // retorna uma String no formato dia/mês/ano
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    } // fim do método toString
} // fim da classe

/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Fig. 8.7: DiaMesAno.java                                               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *************************************************************************/