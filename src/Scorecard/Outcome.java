package Scorecard;

public enum Outcome {

    ONE,
    TWO,
    THREE,
    FOUR,
    SIX,
    WICKET,
    WIDE,
    NO_BALL,
    DOT_BALL;


    public static Outcome getOutcome(String outcome) {
        if (outcome.equals("1")) {
            return Outcome.ONE;
        } else if (outcome.equals("2")) {
            return Outcome.TWO;
        } else if (outcome.equals("3")) {
            return Outcome.THREE;
        } else if (outcome.equals("4")) {
            return Outcome.FOUR;
        } else if (outcome.equals("6")) {
            return Outcome.SIX;
        } else if (outcome.equalsIgnoreCase("W")) {
            return Outcome.WICKET;
        } else if (outcome.equalsIgnoreCase("Nb")) {
            return Outcome.NO_BALL;
        } else if (outcome.equalsIgnoreCase("Wd")) {
            return Outcome.WIDE;
        } else {
            return Outcome.DOT_BALL;
        }
    }

    public static int getOutcomeValue(Outcome score) {
        if (score == Outcome.ONE) {
            return 1;
        } else if (score == Outcome.TWO) {
            return 2;
        } else if (score == Outcome.THREE) {
            return 3;
        } else if (score == Outcome.FOUR) {
            return 4;
        } else if (score == Outcome.SIX) {
            return 6;
        } else if (score == Outcome.WICKET) {
            return -1;
        } else if (score == Outcome.NO_BALL) {
            return 1;
        } else if (score == Outcome.WIDE) {
            return 1;
        } else
            return 0;
    }
}