package com.example.educacao.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlunoTest {
    @Test
    void testCalculaMedia() {

        var aluno = new Aluno(1, "Henry de Oliveira Campos", 7.0, 6.9, 1.0);
        double valorEsperado = 4.96;
        double valorObtido = aluno.calculaMedia();
        assertEquals(valorEsperado, valorObtido, 0.01);

    }
}
