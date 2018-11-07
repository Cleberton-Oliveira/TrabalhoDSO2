/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Entidade.Animal;
import java.util.ArrayList;

/**
 *
 * @author cleberton
 */
public interface IUsuario {
    
	public String getNome();

	public String getCpf();

	public String getSenha();

	public String getLogin();

	public ArrayList<Animal> getAdocao();

	public ArrayList<Animal> getDoacao();

}
