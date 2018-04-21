/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufrn.projeto.test;

import com.ufrn.projeto.dao.implementations.TemperaturaDaoImpl;
import com.ufrn.projeto.dao.interfaces.ITemperaturaDao;
import com.ufrn.projeto.model.Temperatura;
import java.sql.Date;

/**
 *
 * @author berna
 */
public class Main {

    public static void main(String[] args) {
        Temperatura t = null/*new Temperatura(50, new Date(2018, 4, 20))*/;
        ITemperaturaDao temperaturaDAO = new TemperaturaDaoImpl();
        t = temperaturaDAO.findById(1);
        System.out.println(t);
        System.exit(0);
    }
}
