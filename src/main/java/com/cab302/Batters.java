package com.cab302;

import java.util.List;

public class Batters {
    private List<Batters> batter; // Field name must match JSON key

    public List<Batters> getBatter() { return batter; }
    public void setBatter(List<Batters> batter) { this.batter = batter; }

    @Override
    public String toString() {
        return "Batters{" +
                "batter=" + batter +
                '}';
    }
}