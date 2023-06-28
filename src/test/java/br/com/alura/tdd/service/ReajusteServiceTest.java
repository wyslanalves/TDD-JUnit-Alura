package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private  Funcionario funcionario;

    @BeforeEach // antes de iniciar os testes, e nicia esse metódo
    public void inicializar(){
        this.service  = new ReajusteService();
        this.funcionario  = new Funcionario("Wyslan", LocalDate.now(), new BigDecimal("1000"));
    }


    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejat() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        //assertEquals(new BigDecimal("0.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
