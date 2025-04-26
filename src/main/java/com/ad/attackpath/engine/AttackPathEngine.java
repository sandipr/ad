package com.ad.attackpath.engine;

public class AttackPathEngine {
    public void loadRules(String rulePath) {
        System.out.println("Loading rules from: " + rulePath);
    }
    public void loadGraph(String graphPath) {
        System.out.println("Loading graph from: " + graphPath);
    }
    public void detectAttackPaths() {
        System.out.println("Detecting attack paths...");
    }
}