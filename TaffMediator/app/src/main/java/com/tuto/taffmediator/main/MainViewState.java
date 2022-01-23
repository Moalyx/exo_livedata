package com.tuto.taffmediator.main;

import java.util.Objects;

public class MainViewState {

    private final String sentence;

    public MainViewState(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return "MainViewState{" +
                "sentence='" + sentence + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainViewState that = (MainViewState) o;
        return sentence.equals(that.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }
}
