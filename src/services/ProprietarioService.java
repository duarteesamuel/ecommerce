package services;

import java.util.Scanner;

import exceptions.LojaException;

import java.util.List;
import java.util.ArrayList;

import models.Proprietario;
import utils.Utils;
import validations.Validator;

public class ProprietarioService {
	
	private static List<Proprietario> proprietarios = new ArrayList<>();
	
	private Proprietario proprietario;
	
	public static Proprietario findByCpf(String cpf) {
		for (Proprietario prop : proprietarios) {
			if(prop.getCpf().equals(cpf)) {
				return prop;
			}
		}
		
		return null;
	}
	
}
