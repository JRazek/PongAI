package jrazek.pong;

import jrazek.pong.Utils.Utils;

public class Rules {
    public static final int individualsPerRound = 200;//individuals that will be present during one round of play
    public static final float maxAllowedSpeed = 0;
    public static final float mutationRate = 1;
    public static final int polynomialDegree = 2;
    public static final int maxTicksPerGeneration = 5000;
    public static final int destinyGeneration = 1000;
    public static final int minProgressDelta = 0; //minimal percentage average delta from gen to gen that allows continuation
    public static final boolean mustBeGreater = true;//if minProgressDelta is 0 it is checked if current gen is just better than previous
    public static final Utils.Domain indexesDomain = new Utils.Domain(-0.0001f, 0.0001f);
}
