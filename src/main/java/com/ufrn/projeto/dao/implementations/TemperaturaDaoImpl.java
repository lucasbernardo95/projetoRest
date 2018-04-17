/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.projeto.dao.implementations;

import com.ufrn.projeto.dao.interfaces.ITemperaturaDao;
import com.ufrn.projeto.model.Temperatura;

/**
 *
 * @author Aluno
 */
public class TemperaturaDaoImpl extends GenericDaoImpl<Temperatura, Integer> implements ITemperaturaDao{
    public TemperaturaDaoImpl(){
        super(Temperatura.class);
    }
}
