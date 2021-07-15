/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.model;

/**
 *
 * @author Admin
 */
public class SachUaThich {
    private String mand;
    private int maTuaSach;

    public SachUaThich() {
    }

    public SachUaThich(String mand, int maTuaSach) {
        this.mand = mand;
        this.maTuaSach = maTuaSach;
    }

    public String getMand() {
        return mand;
    }

    public void setMand(String mand) {
        this.mand = mand;
    }

    public int getMaTuaSach() {
        return maTuaSach;
    }

    public void setMaTuaSach(int maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SachUaThich{mand=").append(mand);
        sb.append(", maTuaSach=").append(maTuaSach);
        sb.append('}');
        return sb.toString();
    }
    
    
}
