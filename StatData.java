package pulse;

public class StatData {

    public static int getPulse(int sex, int condition, int period) {
        int[] oneConditionM = {130, 100, 85, 51, 52, 53, 54, 53, 53};
        int[] twoConditionM = {130, 100, 85, 59, 58, 59, 60, 59, 60};
        int[] threeConditionM = {130, 100, 85, 63, 64, 65, 66, 64, 64};
        int[] fourCondtitionM = {130, 100, 85, 67, 68, 69, 70, 71, 68};
        int[] fiveConditionM = {130, 100, 85, 71, 72, 73, 74, 73, 72};
        int[] sixConditionM = {130, 100, 85, 78, 79, 80, 81, 78, 76};
        int[] sevenCondtionM = {130, 100, 85, 82, 82, 83, 84, 82, 80};

        int[] oneConditionW = {130, 100, 85, 56, 56, 57, 58, 57, 57};
        int[] twoConditionW = {130, 100, 85, 63, 62, 62, 63, 62, 62};
        int[] threeConditionW = {130, 100, 85, 68, 67, 68, 68, 67, 67};
        int[] fourCondtitionW = {130, 100, 85, 71, 72, 71, 72, 72, 70};
        int[] fiveConditionW = {130, 100, 85, 76, 75, 76, 75, 75, 74};
        int[] sixConditionW = {130, 100, 85, 82, 80, 82, 81, 82, 81};
        int[] sevenCondtionW = {130, 100, 85, 85, 83, 85, 84, 84, 84};

        int[][][] data = {
                {oneConditionM, twoConditionM, threeConditionM, fourCondtitionM,
                        fiveConditionM, sixConditionM, sevenCondtionM},
                {oneConditionW, twoConditionW, threeConditionW, fourCondtitionW,
                        fiveConditionW, sixConditionW, sevenCondtionW}
        };

        return data[sex][condition][period];
    }


}
