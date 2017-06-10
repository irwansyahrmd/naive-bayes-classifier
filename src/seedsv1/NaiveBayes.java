/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seedsv1;

import java.util.ArrayList;

/**
 *
 * @author Irwansyah
 */
public class NaiveBayes {

    private ArrayList<Double> listOfDeviationStandard = new ArrayList<Double>();
    private ArrayList<Double> listOfMean = new ArrayList<Double>();

    public NaiveBayes() {
    }

    public double countProbability(ArrayList<Double> dataEachRows) {
        double result = 1;
        for (int i = 0; i < dataEachRows.size(); i++) {
            //Square of Deviation Standard
            double squareOfDeviationStandard = Math.pow(listOfDeviationStandard.get(i), 2);
            result *= (1 / Math.sqrt(2 * Math.PI * squareOfDeviationStandard))
                    * Math.exp(-Math.pow(dataEachRows.get(i) - listOfMean.get(i), 2) / (2 * squareOfDeviationStandard));
        }
        return result;
    }

    public double getDeviationStandard(ArrayList<String> data) {
        double result = 0;
        double xAverage = 0;

        for (int i = 0; i < data.size(); i++) {
            xAverage += Double.parseDouble(data.get(i));
        }
        xAverage /= data.size();

        for (int i = 0; i < data.size(); i++) {
            result += Math.pow(Double.parseDouble(data.get(i)) - xAverage, 2);
        }
        result = Math.sqrt(((double) 1 / data.size()) * result);
        return result;
    }

    public double getMean(ArrayList<String> data) {
        double average = 0;
        for (int i = 0; i < data.size(); i++) {
            average += Double.parseDouble(data.get(i));
        }
        average /= data.size();
        return average;
    }

    public ArrayList<Double> getListOfDeviationStandard() {
        return listOfDeviationStandard;
    }

    public ArrayList<Double> getListOfMean() {
        return listOfMean;
    }

    public void setListOfDeviationStandard(ArrayList<Double> listOfDeviationStandard) {
        this.listOfDeviationStandard = listOfDeviationStandard;
    }

    public void setListOfMean(ArrayList<Double> listOfMean) {
        this.listOfMean = listOfMean;
    }

    public void addStandardDeviationToList(double std) {
        listOfDeviationStandard.add(std);
    }

    public void addMeanToList(double mean) {
        listOfMean.add(mean);
    }

}
