package com.ad.attackpath;

import com.ad.attackpath.engine.AttackPathEngine;
import com.ad.attackpath.parser.RuleLoader;

public class Main {
    public static void main(String[] args) {
        AttackPathEngine engine = new AttackPathEngine();
        engine.loadRules("src/main/resources/rules/sample_rule.json");
        engine.loadGraph("src/main/resources/graphs/sample_graph.json");
        engine.detectAttackPaths();
    }
}