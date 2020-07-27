package jrazek.pong;

import jrazek.pong.Utils.Utils;

public class Rules {
    public static final int individualsPerRound = 1000;//individuals that will be present during one round of play
    public static final float maxAllowedSpeed = 0;//dont set to other value for now
    public static final float mutationRate = 1f;
    public static final int polynomialDegree = 2;
    public static final int maxTicksPerGeneration = 5000;
    public static final Utils.Domain indexesDomain = new Utils.Domain(-0.0001f, 0.0001f);
}
