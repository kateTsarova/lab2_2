package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.fail;

import edu.iis.mto.searcher.SearchResult;
import edu.iis.mto.searcher.SequenceSearcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SimilarityFinderTest {
    @Test
    void similarityFinder_seq1Empty_seq2Empty(){
        int[] seq1 = {};
        int[] seq2 = {};

        SequenceSearcher seqserch = new SequenceSearcher() {
            @Override
            public SearchResult search(int elem, int[] sequence) {
                for(int i = 0; i<sequence.length; i++){
                    if(sequence[i] == elem){
                        SearchResult sr = SearchResult.Builder.withFound(true).withPosition(i).build();
                        return sr;
                    }
                }
                SearchResult sr = SearchResult.Builder.withFound(false).withPosition(-1).build();
                return sr;
            }
        };

        SimilarityFinder sf = new SimilarityFinder(seqserch);

        Assertions.assertTrue(sf.calculateJackardSimilarity(seq1, seq2)==1);
    }

    @Test
    void similarityFinder_seq1Empty_seq2NotEmpty(){
        int[] seq1 = {};
        int[] seq2 = {1, 2};

        SequenceSearcher seqserch = new SequenceSearcher() {
            @Override
            public SearchResult search(int elem, int[] sequence) {
                for(int i = 0; i<sequence.length; i++){
                    if(sequence[i] == elem){
                        SearchResult sr = SearchResult.Builder.withFound(true).withPosition(i).build();
                        return sr;
                    }
                }
                SearchResult sr = SearchResult.Builder.withFound(false).withPosition(-1).build();
                return sr;
            }
        };

        SimilarityFinder sf = new SimilarityFinder(seqserch);

        Assertions.assertTrue(sf.calculateJackardSimilarity(seq1, seq2)==0);
    }

    @Test
    void similarityFinder_seq1NotEmpty_seq2Empty(){
        int[] seq1 = {1, 2};
        int[] seq2 = {};

        SequenceSearcher seqserch = new SequenceSearcher() {
            @Override
            public SearchResult search(int elem, int[] sequence) {
                for(int i = 0; i<sequence.length; i++){
                    if(sequence[i] == elem){
                        SearchResult sr = SearchResult.Builder.withFound(true).withPosition(i).build();
                        return sr;
                    }
                }
                SearchResult sr = SearchResult.Builder.withFound(false).withPosition(-1).build();
                return sr;
            }
        };

        SimilarityFinder sf = new SimilarityFinder(seqserch);

        Assertions.assertTrue(sf.calculateJackardSimilarity(seq1, seq2)==0);
    }
}
