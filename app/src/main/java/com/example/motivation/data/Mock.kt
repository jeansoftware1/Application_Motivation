package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

//FRASES
data class Phrase(val description: String, val categoryId: Int)

class Mock {
    private val infinity = MotivationConstants.FILTER.INFINITY
    private val child = MotivationConstants.FILTER.CHILD
    private val sun = MotivationConstants.FILTER.SUN


    private val listPhrase = listOf(
        Phrase(
            "Eu sou a ressurreição e a vida. Quem crê em mim, ainda que morra, viverá; e quem vive e crê em mim nunca morrerá.",
            sun
        ),
        Phrase(
            "Ter fé é assinar uma folha em branco e deixar que Deus nela escreva o que quiser.",
            child
        ),
        Phrase(
            "A fé em Deus nos faz crer no incrível, ver o invisível e realizar o impossível.",
            sun
        ),
        Phrase(
            "Sempre faça tudo com muito amor e com muita fé em Deus, que um dia você chega lá. De alguma maneira você chega lá.",
            child
        ),
        Phrase(
            "A fé em Deus nos dá força para superar qualquer obstáculo!",
            sun
        ),
        Phrase(
            "Com fé em Deus, devagar e sempre e um passo de cada vez, conseguimos atingir nossos objetivos.",
            child
        ),
        Phrase(
            "Com fé em Deus, não há trevas que prevaleçam nem turbulências capazes de nos afastar do caminho certo.",
            sun
        ),
        Phrase(
            "Não diga que a vitória está perdida, tenha fé em Deus, tenha fé na vida.",
            child
        ),
        Phrase(
            "Tenha fé em Deus e em você mesmo. Vá à luta! Se precisar recuar, recue, mas não desista, pegue impulso!",
            sun
        ),
        Phrase(
            "Minha fé em Deus me dá ainda mais certeza de que vai dar tudo certo no final!",
            child
        ),
        Phrase(
            "Com fé em Deus, o impossível é uma mera questão de detalhe.",
            sun
        ),
        Phrase(
            "Com esperança e fé em Deus, sei que nada é capaz de me abalar!",
            child
        ),
        Phrase(
            "Sonhos são caminhos construídos pelo coração.",
            sun
        ),
        Phrase(
            "Um dia bonito começa com um barril de esperança e um café de otimismo.",
            child
        ),
        Phrase(
            "Por trás de um dia difícil, há uma versão forte de você que sempre seguiu em frente.",
            sun
        ),
        Phrase(
            "Mudar pode dar medo, mas é uma aventura que pode te levar muito longe.",
            child
        ),
        Phrase(
            "Se expressarmos gratidão pelo que temos, teremos mais por que expressar gratidão.",
            sun
        ),
        Phrase(
            "A persistência é o caminho do êxito.",
            child
        ),
        Phrase(
            "A maior riqueza da vida é ser feliz com pouco.",
            sun
        ),
        Phrase(
            "Todos estamos matriculados na escola da vida, onde o mestre é o tempo.",
            child
        ),
        Phrase(
            "O que fazemos agora ecoa na eternidade.",
            sun
        ),
        Phrase(
            "O ignorante afirma, o sábio duvida, o sensato reflete.",
            child
        ),
        Phrase(
            "Quem nunca cometeu um erro nunca tentou algo novo.",
            sun
        ),
        Phrase(
            "Aquilo que foi feito para brilhar deve suportar o arder das chamas.",
            child
        ),
        Phrase(
            "O maior inimigo da criatividade é o bom senso.",
            sun
        ),
        Phrase(
            "Não explique sua filosofia, mas sim incorpore-a.",
            child
        ),
        Phrase(
            "Aquele que superou seus medos será verdadeiramente livre.",
            sun
        )

    )


    //PEGAR FRASES EM ORDEM ALEATORIA
    fun getPhrase (value: Int): String{
        val filtered = listPhrase.filter { it.categoryId == value || value == infinity }
        return filtered[Random.nextInt(filtered.size)].description
    }
}