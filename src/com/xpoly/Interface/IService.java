/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.Interface;

/**
 *
 * @author Dell
 */
public interface IService <EntityType> {  
    void init();
    void loadTable();
    void insert();
    void update();
    void delete();
    void clear();
    StringBuilder validateForm();
    EntityType getModel();
    void setModel(EntityType model);
}
