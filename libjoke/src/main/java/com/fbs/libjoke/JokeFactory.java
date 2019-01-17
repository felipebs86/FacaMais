package com.fbs.libjoke;

import java.util.Random;

public class JokeFactory {

    private static final String[] JOKES = {
            "Ja ouviram o pagode de Darwin? “Deixa acontecer, naturalmente!”",
            "O que o próton disse para o elétron? Hoje você está muito negativo.",
            "Sabe qual a música favorita do estatístico?: ANOVA loira do tchan é linda…",
            "O que é uma molécula? É uma menina muito sapécula.",
            "O Nêutron queria entrar para o ramo dos transportes, mas não conseguia carga.",
            "O oxigênio conta uma piada e o potássio KKKKK",
            "15 bilhões de neutrinos entram em um bar, um deles diz ai",
            "Qual o som que o Pato atômico faz? Quark, Quark!",
            "Por que Stálin não atende o telefone? Porque ele tem medo de que seja Trótski.",
            "Por que a célula foi ao psiquiatra? Porque estava com Complexo de Golgi.",
            "O que 6 carbonos e 6 hidrogenios estão fazendo de mãos dadas na igreja? – benzeno",
            "Como as enzimas se reproduzem? R: uma enzima da outra!",
    };

    private static final Random PRNG = new Random();

    public static String getRandomJoke() {
        return JOKES[PRNG.nextInt(JOKES.length)];
    }

}
