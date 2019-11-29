package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;

    @Before
    public void setUp() throws Exception {
        //given: une instance à choix multiple
        List<Integer> l=  new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        question = new QuestionAChoixMultiple("un énoncé", l);
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
        //when: quand l'étudiant fourni l'indice de des bonnes réponses
        List<Integer> indiceEtudiant = new ArrayList<>();
        indiceEtudiant.add(1);
        indiceEtudiant.add(2);
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        for(Integer i : indiceEtudiant) {
            resScore += question.getScoreForIndice(i);
        }
        //then: le score obtenu fait 100 car toutes les réponses sont justes
        assertEquals(100f, resScore, 0.01);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        //when: quand l'étudiant fourni un indice de réponse sur deux
        List<Integer> indiceEtudiant = new ArrayList<>();
        indiceEtudiant.add(1);
        indiceEtudiant.add(4);
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        for(Integer i : indiceEtudiant) {
            resScore += question.getScoreForIndice(i);
        }
        //then: le score obtenu fait 50 car 1 réponse sur 2 est juste
        assertEquals(50f, resScore, 0.01);
    }

}