/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.Serializable;

/**
 *
 * @author Phil
 */
public class SalgradeEntry implements Serializable {

    private int grade;
    private int loSal;
    private int hiSal;

    public SalgradeEntry() {
    }

    public SalgradeEntry(int grade, int loSal, int hiSal) {
        this.grade = grade;
        this.loSal = loSal;
        this.hiSal = hiSal;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getLoSal() {
        return loSal;
    }

    public void setLoSal(int loSal) {
        this.loSal = loSal;
    }

    public int getHiSal() {
        return hiSal;
    }

    public void setHiSal(int hiSal) {
        this.hiSal = hiSal;
    }

}
