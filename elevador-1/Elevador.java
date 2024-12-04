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
    private Piso pisoParada;
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
        pisoParada = parada; 
        pisoParada.solicitarParada();    
    }
    
    public void mostrarPainel()
    {
        String painelPisos = "";
        Piso pisoPrint = pisoAtual;
        do
        {
            if(pisoPrint == pisoAtual)
            {
                pisoPrint.isPisoAtual();        
            }
            painelPisos = painelPisos + " " + pisoPrint.getStringPainel();
            pisoPrint = pisoPrint.getPróximoPiso();
        } while (pisoPrint != null);
        System.out.println("------------Painel Elevador------------");
        System.out.printf(" %s \n" ,painelPisos);
    }
    
    public void mover()
    {
        if(isPortaAberta())
        {
             if(direção)
            {
                pisoAtual = pisoAtual.getPróximoPiso();
                pisoAtual.mostrarPainel();
                if(pisoAtual.isParadaSolicitada())
                {
                    abrirPorta();
                }
            }
            else
            {
                pisoAtual = pisoAtual.getPróximoPiso();
                pisoAtual.mostrarPainel();
                if(pisoAtual.isParadaSolicitada())
                {
                    abrirPorta();
                }
            }   
        }
    }

}
