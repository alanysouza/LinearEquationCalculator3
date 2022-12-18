
package model;

/**
 *
 * @author Alany Souza 2021345 and Thaynna Vieira 2021288
 */

public class ThreeVariableEquation {
    private int id;
    private String xMatrices;
    private String yMatrices;
    private String zMatrices;
    private String equalsMatrices;
    private double xValue;
    private double yValue;
    private double zValue;
    private int createdBy;

    public ThreeVariableEquation() {

    }

    public ThreeVariableEquation(int id, String xMatrices, String yMatrices, String zMatrices, String equalsMatrices, double xValue, double yValue, double zValue, int createdBy) {
        this.id = id;
        this.xMatrices = xMatrices;
        this.yMatrices = yMatrices;
        this.zMatrices = zMatrices;
        this.equalsMatrices = equalsMatrices;
        this.xValue = xValue;
        this.yValue = yValue;
        this.zValue = zValue;
        this.createdBy = createdBy;
    }

    public ThreeVariableEquation(String xMatrices, String yMatrices, String zMatrices, String equalsMatrices, double xValue, double yValue, double zValue, int createdBy) {
        this.xMatrices = xMatrices;
        this.yMatrices = yMatrices;
        this.zMatrices = zMatrices;
        this.equalsMatrices = equalsMatrices;
        this.xValue = xValue;
        this.yValue = yValue;
        this.zValue = zValue;
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

    public String getzMatrices() {
        return zMatrices;
    }

    public void setzMatrices(String zMatrices) {
        this.zMatrices = zMatrices;
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

    public double getzValue() {
        return zValue;
    }

    public void setzValue(double zValue) {
        this.zValue = zValue;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "ThreeVariableEquation{" +
                "id=" + id +
                ", xMatrices='" + xMatrices + '\'' +
                ", yMatrices='" + yMatrices + '\'' +
                ", zMatrices='" + zMatrices + '\'' +
                ", equalsMatrices='" + equalsMatrices + '\'' +
                ", xValue=" + xValue +
                ", yValue=" + yValue +
                ", zValue=" + zValue +
                ", createdBy=" + createdBy +
                '}';
    }
}
