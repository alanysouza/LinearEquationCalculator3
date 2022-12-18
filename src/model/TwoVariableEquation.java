
package model;

/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

public class TwoVariableEquation {
    private int id;
    private String xMatrices;
    private String yMatrices;
    private String equalsMatrices;
    private double xValue;
    private double yValue;
    private int createdBy;

    public TwoVariableEquation() {
    }

    public TwoVariableEquation(int id, String xMatrices, String yMatrices, String equalsMatrices, double xValue, double yVale, int createdBy) {
        this.id = id;
        this.xMatrices = xMatrices;
        this.yMatrices = yMatrices;
        this.equalsMatrices = equalsMatrices;
        this.xValue = xValue;
        this.yValue = yVale;
        this.createdBy = createdBy;
    }

    public TwoVariableEquation(String xMatrices, String yMatrices,  String equalsMatrices, double xValue, double yValue, int createdBy) {
        this.xMatrices = xMatrices;
        this.yMatrices = yMatrices;
        this.equalsMatrices = equalsMatrices;
        this.xValue = xValue;
        this.yValue = yValue;
        this.createdBy = createdBy;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getxMatrices() {
        return xMatrices;
    }

    public void setxMatrices(String xMatrices) {
        this.xMatrices = xMatrices;
    }

    public String getyMatrices() {
        return yMatrices;
    }

    public void setyMatrices(String yMatrices) {
        this.yMatrices = yMatrices;
    }

    public String getEqualsMatrices() {
        return equalsMatrices;
    }

    public void setEqualsMatrices(String equalsMatrices) {
        this.equalsMatrices = equalsMatrices;
    }

    public double getxValue() {
        return xValue;
    }

    public void setxValue(double xValue) {
        this.xValue = xValue;
    }

    public double getyValue() {
        return yValue;
    }

    public void setyValue(double yValue) {
        this.yValue = yValue;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "TwoVariableEquation{" +
                "id=" + id +
                ", xMatrices='" + xMatrices + '\'' +
                ", yMatrices='" + yMatrices + '\'' +
                ", equalsMatrices='" + equalsMatrices + '\'' +
                ", xValue=" + xValue +
                ", yValue=" + yValue +
                ", createdBy=" + createdBy +
                '}';
    }
}
