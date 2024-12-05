
/**
 * Escreva uma descrição da classe Piso aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Piso
{
    private int andarDoPiso;
    private boolean solicitarSubida;
    private boolean solicitarDescida;
    private Piso próximoPiso;
    private Piso pisoAnterior;
    private boolean parada;
    private Elevador elevador;
    /**
     * Construtor para objetos da classe Piso
     */
    public Piso(int andar)
    {
        andarDoPiso = andar;
        próximoPiso = null;
        pisoAnterior = null;
        parada = false;
        elevador = null;
    }

    /**
     * Um exemplo de um método - substitua este comentário pelo seu próprio
     * 
     * @param  y   um exemplo de um parâmetro de método
     * @return     a soma de x e y 
     */
    public int getAndar()
    {
        // escreva seu código aqui
        return andarDoPiso;
    }
    
    public void setSubir() 
    {
        if(solicitarSubida)
        {
            solicitarSubida = false;
        }
        else
        {
            solicitarSubida = true;
        }
        mostrarPainel();
    }
    
    public void setDescer()
    {
        if(solicitarDescida)
        {
            solicitarDescida = false;
        }
        else
        {
            solicitarDescida = true;
        }
        mostrarPainel();
    }
    
    public boolean isQueroSubir() 
    {
        return solicitarSubida;
    }

        public boolean isQueroDescer() 
    {
        return solicitarDescida;
    }
    
    public void mostrarPainel()
    {
        if(solicitarSubida && solicitarDescida)
        {
            System.out.printf("( %d ) ▲ ▼ \n", getAndar());  
        }
        if(solicitarSubida && !solicitarDescida)
        {
            System.out.printf("( %d ) ▲ ▽\n", getAndar());
        }
        if(!solicitarSubida && !solicitarDescida)
        {
            System.out.printf("( %d ) △ ▽\n", getAndar());
        }
        if(!solicitarSubida && solicitarDescida)
        {
            System.out.printf("( %d ) △ ▼\n", getAndar());
        }
    }
    
    public void setPróximoPiso(Piso nextPiso)
    {
        próximoPiso = nextPiso;   
    }
    
    public Piso getPróximoPiso() 
    {
        return próximoPiso; 
    }
    
    public void setPisoAnterior(Piso priorPiso)
    {
        pisoAnterior = priorPiso;
    }
    
    public Piso getPisoAnterior() 
    {
        return pisoAnterior; 
    }
    
    public void setParada() 
    {
        if(parada)
        {
            parada = false;
        }
        else
        {
            parada = true;  
        }
    }
    
    public boolean isParadaSolicitada()
    {
        return parada;
    }
        
    public void receberElevador(Elevador elevador)
    {
        this.elevador = elevador;
        elevador.setPisoAtual(this);
        if(parada)
        {
            elevador.abrirPorta();
        }
        if(isQueroSubir() && elevador.getDireção())
        {
            elevador.abrirPorta();
            setSubir();
            mostrarPainel();
        }
        if(isQueroDescer() && !elevador.getDireção())
        {
            elevador.abrirPorta();
            setDescer();
            mostrarPainel();
        }        
    }
}
