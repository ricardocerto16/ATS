

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashMap;

/**
 * A classe de teste TesteSistema.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class TesteSistema
{
    
    private App app;
    private Motorista mot;
    private Carro carro;
    private Login log;
    private Utilizadores util;
    private HashMap <String,Veiculo> veic;
    private Set<Viagem> viagem;
    private Veiculo v;
    private Registo reg;
    private Ator a;
    
    public void mainTest(){
        
        app = new App();
        log = new Login(); //log.executa(util,veic); 
        try {
            log.loginMotorista(util,veic,"email123mot");
        } catch (Exception e) {
            fail();
        }
    
        
        try {
            mot = new Motorista("emailmot","mot","pass","braga","22-01-1980",viagem,5,4,4,120.3,true,v);
            util.adiciona(mot);
        } catch (Exception e) {
            fail();
        }
        
        String email = "emailmot";
        String pass = "mot";
        
        try {
            log.loginMotorista(util,veic,email);
        } catch(Exception e) {
            fail();
        }
        
        //dar logout do motorista
        // adicionar cliente
        // dar login cliente
        // cliente chamar uma viatura
        
        
        /*
        try {
           adicionar cliente(mot,veic);
        } catch (Exception e) {
            fail();
        }
        */
        
    }
}
