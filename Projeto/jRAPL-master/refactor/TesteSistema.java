

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;
import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.GregorianCalendar;


public class TesteSistema
{
    public TesteSistema(){
    
    }
    
   
    private App app;
    private Motorista mot;
    private Login log;
    private Utilizadores util;
    private HashMap <String,Veiculo> veic;
    private Set<Viagem> viagem;
    private Veiculo v;
    private Registo reg;
    private Ator a;
    private Cliente cli;
    private Coordenada cord;
    private Coordenada cfim;
    private Viagem vi;
    private Mota mota1;
    private Mota mota2;
    private Mota mota3;
    private Mota mota4;
    private Mota mota5;
    private Carro carro1;
    private Carro carro2;
    private Carro carro3;
    private Carro carro4;
    private Carro carro5;
    
    
    @Before
    public void setUp()
    {
    }
    
    public void mainTest(){
        testSis();
    }
    
    String nome = "Appdadosbin";
    
    public void carregaEstado(String nome) throws FileNotFoundException,
                                            IOException,
                                            ClassNotFoundException {
        FileInputStream f = new FileInputStream(nome);
        ObjectInputStream o = new ObjectInputStream(f);
        this.util = (Utilizadores) o.readObject();
        this.veic = (HashMap<String,Veiculo>) o.readObject();
        o.close();
    }
    
    public void load(){
         try{
           carregaEstado(nome);
        } 
        catch (IOException e){
            System.out.println("Erro no ficheiro.");
        } 
        catch (ClassNotFoundException e){
            System.out.println("Erro nas classes.");
        } 
    }
    
    @Test
    public void testSis(){
        
        
        app = new App();
        load();
        
        try {
            mot = new Motorista("emailmot","mot","pass","braga","22-01-1980",viagem,5,4,4,120.3,true,v);
            util.adiciona(mot);
        } catch (Exception e) {
            //fail();
            //e.printStackTrace();
            System.out.println("ERRO");
        }
        
        try {
            cli = new Cliente("emailcli","cli","clipass","bragança","22-01-1980",viagem,120.2);
            util.adiciona(cli);
        } catch (Exception e) {
            System.out.println("ERRO");
        }
        
        String email = "emailmot";
        String pass = "mot";
        cord = new Coordenada(1,1);
        cfim = new Coordenada(5,6);
        
        
        GregorianCalendar data = new GregorianCalendar(2013,1,12);
        
        try {
           vi = new Viagem(cord,cfim,20.5,"emailcli",data,17.5,5);
           System.out.println(vi);
           viagem.add(vi);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERRO");
        }
        
        
        try{
            carro1 = new Carro(90,17.2,8,"22-XC-10",cord,false);
            veic.put("22-XC-10",carro1);
            carro2 = new Carro(90,17.2,8,"22-AA-10",cord,true);
            veic.put("22-AA-10",carro2);
            carro3 = new Carro(125,7.2,8,"AA-22-10",cord,false);
            veic.put("AA-22-10",carro3);
            carro4 = new Carro(130,10.2,8,"22-XC-55",cord,false);
            veic.put("22-XC-55",carro4);
            carro5 = new Carro(120,15.2,8,"22-OO-10",cord,true);
            veic.put("22-XC-10",carro5);
        }catch (Exception e) {
            System.out.println("ERRO");
        }
      
        
        
        
        
        try{
           mota1 = new Mota(150,75.3,2,"22-10-ZZ",cord,true);
           mota2 = new Mota(70,75.3,2,"21-10-XA",cord,true);
           mota3 = new Mota(50,55.3,2,"22-10-AA",cord,true);
           mota4 = new Mota(90,75.3,2,"22-44-ZA",cord,true);
           mota5 = new Mota(60,65.3,2,"22-10-AQ",cord,true);
           veic.put("22-10-ZZ",mota1);
           veic.put("21-10-XA",mota2);
           veic.put("22-10-AA",mota3);
           veic.put("22-44-ZA",mota4);
           veic.put("22-10-AQ",mota5);
        }
        catch (Exception e) {
            System.out.println("ERRO");
        }
        
        
        
    }
    
    
    @After
    public void tearDown()
    {
    }

}
