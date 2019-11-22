package miagem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuestionAChoixExclusifTest {

    private QuestionAChoixExclusif question;

    @Before
    public void setUp() throws Exception {
        //given: une instance à choix exclusif
        question = new QuestionAChoixExclusif("un énoncé", 2);
    }

    @Test
    public void testGetEnonce() {
        //when: on demande son énoncé à la question
        String resEnonce = question.getEnonce();
        //then: l'énoncé retourné est l'enoncé fourni à la construction de la question
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        //when: quand l'étudiant fourni l'indice de la bonne réponse
        int indiceEtudiant = 2;
        //and: on demande le score de l'indice à la question
        float  resScore = question.getScoreForIndice(indiceEtudiant);
        //then: le score obtenu fait 100
        assertEquals(100f, resScore, 0.01);
    }
    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        //when: quand l'étudiant fourni l'indice d'une mauvaise réponse
        int indiceEtudiant = 1;
        //and: on demande le score de l'indice à la question
        float  resScore = question.getScoreForIndice(indiceEtudiant);
        //then: le score obtenu fait 100
        assertEquals(0f, resScore, 0.01);
    }
}