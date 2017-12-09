

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
    private Cliente cli;
    private Coordenada cord;
    private Coordenada cfim;
    
    public void mainTest(){
        
        //app = new App();
        log = new Login(); //log.executa(util,veic); 
        //try {
        //    log.loginMotorista(util,veic,"email123mot");
        //} catch (Exception e) {
        //    fail();
        //}
        
        try {
            log.executa(util,veic);
        } catch (Exception e) {
            fail();
        }
        
        try {
            mot = new Motorista("emailmot","mot","pass","braga","22-01-1980",viagem,5,4,4,120.3,true,v);
            util.adiciona(mot);
        } catch (Exception e) {
            fail();
        }
        
        try {
            cli = new Cliente("emailcli","cli","clipass","bragança","22-01-1980",viagem,120.2);
            util.adiciona(cli);
        } catch (Exception e) {
            fail();
        }
        
        String email = "emailmot";
        String pass = "mot";
        cord = new Coordenada(1,1);
        cfim = new Coordenada(5,6);
        carro = new Carro(90,17.2,8,"22-XC-10",cord,false);
        veic.put(carro.getMatricula(),carro);
        
        //try {
        //    log.loginMotorista(util,veic,email);
        //} catch(Exception e) {
        //    fail();
        //}
        
        //try {
        //    log.associarViatura(mot,veic);
        //} catch(Exception e) {
        //    fail();
        //}
        
        try {
            log.realizarViagem(cli,mot,12.9,cord,cfim);
        } catch(Exception e) {
            fail();
        }
        
        try {
            log.verMontanteFaturado(mot);
        } catch(Exception e) {
            fail();
        }
        
        
        
    }
}
