package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur scoreC;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        //given: une instance de score calculateur et une instance de question à choix multiple
        scoreC = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)), 5);
    }

    @Test
    public void calculeScoreTestChoixMultipleMauvaisesReponses() {
        //when: quand l'étudiant fourni l'indice de 2 mauvaises réponses
        List<Integer> indiceEtudiant = new ArrayList<>(Arrays.asList(1,4));
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        resScore += scoreC.calculeScore(indiceEtudiant,questionAChoixMultiple);
        //then: le score obtenu fait 0 car toutes les réponses sont mauvaises
        assertEquals(0f, resScore, 0.01);
    }

    @Test
    public void calculeScoreTestChoixMultipleBonnesReponsesPartielles() {
        //when: quand l'étudiant fourni l'indice de 2 bonnes réponses
        List<Integer> indiceEtudiant = new ArrayList<>(Arrays.asList(2,3));
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        resScore += scoreC.calculeScore(indiceEtudiant,questionAChoixMultiple);
        //then: le score obtenu fait 2*100/3 car il y a 2 bonnes réponses sur 3 qui ont été données
        assertEquals(2*100/3f, resScore, 0.01);
    }

    @Test
    public void calculeScoreTestChoixMultipleBonnesReponses() {
        //when: quand l'étudiant fourni l'indice de 3 bonnes réponses
        List<Integer> indiceEtudiant = new ArrayList<>(Arrays.asList(2,3,5));
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        resScore += scoreC.calculeScore(indiceEtudiant,questionAChoixMultiple);
        //then: le score obtenu fait 100 car il y a 3 bonnes réponses sur 3 qui ont été données
        assertEquals(100f, resScore, 0.01);
    }

    @Test
    public void calculeScoreTestChoixMultipleTouteReponsesPossibles() {
        //when: quand l'étudiant fourni l'indice de toutes les réponses possibles
        List<Integer> indiceEtudiant = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        resScore += scoreC.calculeScore(indiceEtudiant,questionAChoixMultiple);
        //then: le score obtenu fait 0 car toute les réponses ont été cochées
        assertEquals(0f, resScore, 0.01);
    }

    @Test
    public void calculeScoreTestChoixMultiplePartiel() {
        //when: quand l'étudiant fourni l'indice de 2 réponses justes et 1 réponse fausse
        List<Integer> indiceEtudiant = new ArrayList<>(Arrays.asList(1,2,3));
        //and: on demande le score de l'indice à la question
        float resScore=0f;
        resScore += scoreC.calculeScore(indiceEtudiant,questionAChoixMultiple);
        //then: le score obtenu fait 16.66 car 2 réponses justes et 1 réposne fausse ont été cochées
        assertEquals(16.66f, resScore, 0.01);
    }

}