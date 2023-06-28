package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalatioMuitoAlto(){
        BonusService service = new BonusService();

        assertThrows(IllegalAccessException.class, () -> service.calcularBonus(new Funcionario("Wyslan",
                LocalDate.now(),
                new BigDecimal("25000"))));


    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus =  service.calcularBonus(new Funcionario("Wyslan", LocalDate.now(),
                new BigDecimal("2500")));
        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000(){
        BonusService service = new BonusService();
        BigDecimal bonus =  service.calcularBonus(new Funcionario("Wyslan", LocalDate.now(),
                new BigDecimal("10000")));
        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
