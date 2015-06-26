package com.davidkopala.ozoneconversion;

/**
 * Created by david_000 on 6/22/2015.
 */
public class Conversion {

    public String flowRateAndPPMWater(String GPM, String PPM) {
        double result = (3.78 * 60 * Integer.parseInt(GPM) * Integer.parseInt(PPM)) / 1000;
        return String.valueOf(result);
    }

    public String OutputOzoneGeneratorFeedgas(String SLMP, String percent) {
        double result = Integer.parseInt(SLMP) * 0.001 * 60 * 14.3 * Integer.parseInt(percent);
        return String.valueOf(result);
    }

    public String OutputOzoneGeneratorDry(String SLMP, String percent) {
        double result = Integer.parseInt(SLMP) * 0.001 * 60 * 12.8 * Integer.parseInt(percent);
        return String.valueOf(result);
    }

    public String OutputOzoneGenerator(String SLMP, String density) {
        double result = Integer.parseInt(SLMP) * 60 * 0.001 * Integer.parseInt(density);
        return String.valueOf(result);
    }

    public String OutputOzoneGeneratorPPM(String CFM, String PPM) {
        double result = Integer.parseInt(CFM) / 35.33569 * 60 * Integer.parseInt(PPM) * 2.14;
        return String.valueOf(result);
    }

    public String AdjustedFlow(String PSI, String Measured) {
        double result = Integer.parseInt(Measured) * Math.sqrt((Integer.parseInt(PSI) + 14.7) / 14.7);
        return String.valueOf(result);
    }
}
