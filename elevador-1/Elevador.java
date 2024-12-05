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
        System.out.println("A porta está abrindo");
    }
    
    public void fecharPorta()
    {
        //tem q testar um if aqui, provavelmente vai dar algum erro aqui alguma hora so que eu nao sei direito quando e são 1:30 da manha e tenho q dormir, a  pesar de não ter sono
        porta = false;
        System.out.println("A porta está fechando");
    }
    
    public boolean isPorta()
    {
        return porta;
    }
    
    public void setDireção()
    {
        if(direção)
        {
            direção = false;
        }
        else
        {
            direção = true;
        }
    }
    
    public boolean getDireção()
    {
        if(direção && pisoAtual.getPróximoPiso() == null)
        {
            setDireção();
        }
        if(!direção && pisoAtual.getPisoAnterior() == null)
        {
            setDireção();
        }
        return direção;
    }
    
    public void setPisoAtual(Piso pisoAtual)
    {
        this.pisoAtual = pisoAtual;
    }
    
    public Piso getPisoAtual() 
    {
        return pisoAtual;
    }
    
    public void pararNoPiso(Piso parada) 
    { 
        parada.setParada();    
    }
    
    public void mostrarPainel()
    {
        Piso pisoPrint = pisoTerreo;
        System.out.println("(------------Painel Elevador------------)");
        do
        {
            String Andar = "";
            Andar = Andar + pisoPrint.getAndar();
            if(pisoPrint == pisoAtual)
            {
                Andar = Andar + "^";  
            }
            if(pisoPrint.isParadaSolicitada())
            {
                Andar = "*" + Andar + "*";
            }
            System.out.print(Andar + " ");
            pisoPrint = pisoPrint.getPróximoPiso();
        } while (pisoPrint != null);
        System.out.println();
        System.out.println("(---------------------------------------)");
    }
    
    public void mover()
    {
        if(!isPorta())
        {
             if(getDireção())
            {
                pisoAtual = pisoAtual.getPróximoPiso();
                pisoAtual.receberElevador(this);
                mostrarPainel();
            }
            else
            {
                pisoAtual = pisoAtual.getPisoAnterior();
                pisoAtual.receberElevador(this);
                mostrarPainel();
            }   
        }
        else
        {
            System.out.println("Favor fechar a porta");    
        }
    }
}
