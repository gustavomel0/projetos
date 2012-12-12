package Main.BuscaCep;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class App {  
   
    public static void main(String[] args){  
        Scanner entrada = new Scanner (System.in);
    	String r = "s";
    	while (r.equals("s")){
        System.out.println("\nDigite o CEP:");
    	String cep = entrada.next();
    	
    	//Cria os parâmetros necessários para se communicar com o site dos correios
        Map<String, String> parametros = new HashMap<String, String>();  
        parametros.put("cepEntrada", cep);  
        parametros.put("tipoCep", "");  
        parametros.put("cepTemp", "");  
        parametros.put("metodo", "buscarCep"); 
        
        //Faz a comunicação enviando os parâmetros e retorna o código fonte html do site com os dados de endereço
        Document doc = null;
		try {
			doc = Jsoup.connect("http://m.correios.com.br/movel/buscaCepConfirma.do").data(parametros).post();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        //Faz a consulta css pela classe respostadestaque no código html do site
        Elements elemetos = doc.select(".respostadestaque");  
        
        //Faz uma validação para ver se o cep foi encontrado
        if (elemetos.size() == 4) {  
            //Mostra todos os indices do resultado da consulta
        	System.out.println("Logradouro: " + elemetos.get(0).text());  
            System.out.println("Bairro: " + elemetos.get(1).text());  
            System.out.println("Cidade/Estado: " + elemetos.get(2).text());  
            System.out.println("CEP: " + elemetos.get(3).text());  
        } else {  
            System.out.println("Cep não encontrado...");  
        }
        
        System.out.println("\nBuscar novamente? s/n");
        r = entrada.next();
    }
    	System.out.println("\nBye...");
    }
  
}  
