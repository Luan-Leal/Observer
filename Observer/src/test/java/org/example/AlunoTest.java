package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContaTest {

    @Test
    void deveNotificarUmaConta() {
        Plataforma plataforma = new Plataforma("PSN", "3 horas");
        Conta conta = new Conta("Luan");
        conta.cadastrar(plataforma);
        plataforma.lancarNotas();
        assertEquals("Luan, entrou na plataforma { O usuário foi visto pela ultima vez na: 'PSN', O usuário logou no sistema à '3 horas'}", conta.getUltimaApariçãoOnline());
    }

    @Test
    void deveNotificarAsSeguintesContas() {
        Plataforma plataforma = new Plataforma("Steam", "2 dias");
        Conta conta1 = new Conta("José");
        Conta conta2 = new Conta("Matheus");
        conta1.cadastrar(plataforma);
        conta2.cadastrar(plataforma);
        plataforma.lancarNotas();
        assertEquals("José, entrou na plataforma { O usuário foi visto pela ultima vez na: 'Steam', O usuário logou no sistema à '2 dias'}", conta1.getUltimaApariçãoOnline());
        assertEquals("Matheus, entrou na plataforma { O usuário foi visto pela ultima vez na: 'Steam', O usuário logou no sistema à '2 dias'}", conta2.getUltimaApariçãoOnline());
    }

    @Test
    void naoDeveNotificarConta() {
        Plataforma plataforma = new Plataforma("Live", "1 semana");
        Conta conta = new Conta("Luan");
        plataforma.lancarNotas();
        assertEquals(null, conta.getUltimaApariçãoOnline());
    }

    @Test
    void deveNotificarAlunoAPlataformaDosSeguintesInativos() {
        Plataforma plataformaA = new Plataforma("Facebook", "1 ano");
        Plataforma plataformaB = new Plataforma("Instagram", "1 ano");
        Conta conta1 = new Conta("Luan");
        Conta conta2 = new Conta("Luan2");
        conta1.cadastrar(plataformaA);
        conta2.cadastrar(plataformaB);
        plataformaA.lancarNotas();
        assertEquals("Luan, entrou na plataforma { O usuário foi visto pela ultima vez na: 'Facebook', O usuário logou no sistema à '1 ano'}", conta1.getUltimaApariçãoOnline());
        assertEquals(null, conta2.getUltimaApariçãoOnline());
    }
}