package jrazek.pong;

import jrazek.pong.Utils.Utils;

public class Rules {
    public static final int individualsPerRound = 100;//individuals that will be present during one round of play
    public static final int individualsPerRandomRound = 600;//individuals that will be present during one round of play
    public static final float maxAllowedSpeed = 0;
    public static final float mutationRate = 40;
    public static final int polynomialDegree = 2;
    public static final int maxTicksPerGeneration = 15000;
    public static final int destinyGeneration = 1000;

    //===============================
    ///the problem is here ! FIIIX
    public static final int minDelta = 2; //minimal percentage average delta from gen to gen that allows continuation(if 0 - its just enough to be greater)
    public static final int checkFrequency = 15; //how frequent the min Delta should be checked
    //dont use now!=================

    public static final Utils.Domain indexesDomain = new Utils.Domain(-0.0001f, 0.0001f);
}
