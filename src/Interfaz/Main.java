/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import agenda.Agenda;

/**
 *
 * @author Alberto
 */
public class Main {
    public static void main (String args[]){
        Agenda agenda = new Agenda();
                agenda = agenda.restCopiaSeg();
                new InterfazGrafica(agenda).setVisible(true);
    }
}
