package jrazek.pong;

import jrazek.pong.Utils.Utils;

public class Rules {
    public static final Utils.Vector2I mapSize = new Utils.Vector2I(2000,1000);
    public static final Utils.Vector2F paddleSize = new Utils.Vector2F(200, 10);
    public static final float ballSize = 60f;
    public static final int individualsPerRound = 100;//individuals that will be present during one round of play
    public static final int individualsPerRandomRound = 400;//individuals that will be present during one round of play
    public static final float maxAllowedSpeed = 20;
    public static final float mutationRate = 40;
    public static final int polynomialDegree = 2;
    public static final int maxTicksPerGeneration = 10000;
    public static final int destinyGeneration = 1000;

    //===============================
    public static final int minDelta = 5; //minimal percentage average delta from gen to gen that allows continuation (if 0 - its just enough to be greater)
    public static final int checkFrequency = 10; //how frequent the min Delta should be checked (generations)
    //===============================

    public static final Utils.Domain indexesDomain = new Utils.Domain(-0.001f, 0.001f);
}
