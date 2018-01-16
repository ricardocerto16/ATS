package refactor;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;

/**
 * A classe de teste Testes.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class Testes
{
    /**
     * Construtor default para a classe de teste Testes
     */
    public Testes()
    {
        
    }

    public void mainTest(){
        testarMotorista();
        testarCarro();
        testarCoordenada();
    }
    
    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp()
    {
    }
    
    @Test
    public void testarMotorista(){

        Set<Viagem> hv = new TreeSet<>();
        Coordenada corcarr = new Coordenada(2,6);
        Veiculo taxi = new Carro(80,5.5,5,"12-XX-ZZ",corcarr,false);
        Coordenada cord = new Coordenada(5,6);
        Coordenada cord1i = new Coordenada(0,0);
        Coordenada cord1f = new Coordenada(5,5);
        Coordenada cord2i = new Coordenada(1,12);
        Coordenada cord2f = new Coordenada(10,6);
        GregorianCalendar d_v1 =new GregorianCalendar(2012,4,22);
        GregorianCalendar d_v2 =new GregorianCalendar(2012,4,23);
        Viagem v1 = new Viagem(cord1i,cord1f,10,"email",d_v1,15,5);
        Viagem v2 = new Viagem(cord2i,cord2f,8,"email",d_v2,10,2);
        hv.add(v1);
        hv.add(v2);
        
        //Ator a1 = new Ator("email_a1","autor1","autor1","porto","12-12-1998",Set<Viagem> histo);
        Motorista mot1 = new Motorista("email_mot1","nome","passwd","porto","12-12-12",hv,1,5,6,22.50,true,taxi);
        
        
        
        //Teste a alterar a disponibilidade
        mot1.setDisponibilidade(false);
        assertEquals(false,mot1.getDisponibilidade());
        //assertEquals(true,mot1.getDisponibilidade());
        
        
        //Teste a atualizar a Classificaçao
        try{
             int classific = 5;
             mot1.atualizaClassificacao(classific);
        } catch(ValueOutOfBoundsException e){
                System.out.println("Por favor, introduza uma classificação válida.");
        
        }
        //assertEquals(5,mot1.getClassificacao());
        //assertEquals(-1,mot1.getClassificacao(),1);
        
        //Teste ao Tempo de Viagem
        double x = mot1.tempoViagem(10);
        assertEquals((10/80),x,1);
        //System.out.println(x);
        
        //Teste ao preço por Viagem
        double precov = mot1.precoViagem(10);
        assertEquals(55,precov,0);
        //System.out.println(precov);
        
        //Teste ao atualizar Dados
        mot1.atualizaDados(cord,25,25,10);
        //assertEquals(25,mot1.getKmsTotais(),1);
        
        //Teste ao total faturado
        double tf = mot1.totalFaturado();
        assertEquals(25,tf,0);
        
        //Teste ao total faturado entre datas
        GregorianCalendar data_inicio=new GregorianCalendar(2012,4,21);
        GregorianCalendar data_fim =new GregorianCalendar(2012,4,24);
        
        double tfdtas = mot1.totalFaturado(data_inicio,data_fim);
        assertEquals(25,tfdtas,0);
    }
    
    @Test
    public void testarCarro() {

        Coordenada c1 = new Coordenada(1,1);
        Carro carro1 = new Carro(90,10.5,5,"22-XX-ZZ",c1,false);
        Carro carro2 = new Carro(50,4.5,8,"22-XX-22",c1,true);    
    }

    @Test
    public void testarCoordenada(){

        Coordenada c1 = new Coordenada(1,1);
        Coordenada c2 = new Coordenada(4,6);

        int x = c1.getX();
        assertEquals(1,x);

        int y = c2.getY();
        assertEquals(6,y); 
    }
    
    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void t1()
    {
    }
}

