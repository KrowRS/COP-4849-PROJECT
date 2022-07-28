/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 * @author justin
 */
@ManagedBean
public class DeptEntry implements Serializable {

    private int deptNo;
    private String deptName;
    private String loc;

    public DeptEntry(int deptNo, String deptName, String loc) {
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.loc = loc;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}