package com.tuto.taffmediator.main;

import androidx.annotation.NonNull;

import java.util.Objects;

public class MainViewState {

    private final String sentence;
    private final boolean isMinusButtonEnabled;

    public MainViewState(String sentence, boolean isMinusButtonEnabled) {
        this.sentence = sentence;
        this.isMinusButtonEnabled = isMinusButtonEnabled;
    }

    public String getSentence() {
        return sentence;
    }

    public boolean isMinusButtonEnabled() {
        return isMinusButtonEnabled;
    } // on met dans le viewstate le button parce que on met tout ce qui est dynamique sur la vue et comme le bouton change et se desactive on l'ajoute au viewstate pour le gerer

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainViewState that = (MainViewState) o;
        return isMinusButtonEnabled == that.isMinusButtonEnabled && Objects.equals(sentence, that.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence, isMinusButtonEnabled);
    }

    @NonNull
    @Override
    public String toString() {
        return "MainViewState{" +
                "sentence='" + sentence + '\'' +
                ", isMinusButtonEnabled=" + isMinusButtonEnabled +
                '}';
    }
}
