package com.gawekar.service;

public class ScientificCalculator implements Calculator {

    public double sqrt(double num) {
        return Math.sqrt(num);
    }

    @Override
    public boolean isSimpleCaltulator() {
        return false;
    }
}
