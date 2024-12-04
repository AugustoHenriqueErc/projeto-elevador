
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
    private Piso próximoPiso = null;
    private Piso pisoAnterior = null;
    private boolean parada = false;
    private boolean pisoAtual = false;
    /**
     * Construtor para objetos da classe Piso
     */
    public Piso(int andar)
    {
        andarDoPiso = andar;
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
    
    public void queroSubir() 
    {
        solicitarSubida = true;
    }
    
    public void queroDescer()
    {
        solicitarDescida = true;
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
            System.out.printf("%d▲ ▼ \n", getAndar());  
        }
        if(solicitarSubida && !solicitarDescida)
        {
            System.out.printf("%d▲ ▽\n", getAndar());
        }
        if(!solicitarSubida && !solicitarDescida)
        {
            System.out.printf("%d△ ▽\n", getAndar());
        }
        if(!solicitarSubida && solicitarDescida)
        {
            System.out.printf("%d△ ▼\n", getAndar());
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
    
    public void solicitarParada() 
    {
        parada = true;
    }
    
    public boolean isParadaSolicitada()
    {
        return parada;
    }
    
    public boolean isPisoAtual()
    {
        return pisoAtual;
    }
    
    public void setPisoAtual()
    {
        pisoAtual = true;
    }
    
    public String getStringPainel()
    {
        String stringPainel = ""+ getAndar();
        if(pisoAtual)
        {
            stringPainel = stringPainel + "^";
        }
        if(parada)
        {
            stringPainel = "*" + stringPainel + "*";      
        }
        return stringPainel;
    }
}
