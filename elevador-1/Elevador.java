/**
 * Escreva uma descrição da classe Elevador aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Elevador
{
    private boolean porta;
    private Piso pisoTerreo;
    private Piso pisoAtual;
    //true subindo - false descendo
    private boolean direção;
    /**
     * Construtor para objetos da classe Elevador
     */
    public Elevador(Piso terreo)
    {
        pisoTerreo = terreo;
        pisoAtual = pisoTerreo;
        porta = false;
        direção = true;
    }

    public void abrirPorta()
    {
        porta = true;        
    }
    
    public void fecharPorta()
    {
        porta = false;
    }
    
    public boolean isPortaAberta()
    {
        return porta;
    }
    
    public boolean isSubindo ()
    {
        return direção;
    }
    
    public boolean isDescendo ()
    {
        return !direção;
    }
    
    public Piso getPisoAtual() 
    {
        return pisoAtual;
    }
    
    public void pararNoPiso(Piso parada) 
    {
         parada.solicitarParada();    
    }
}
