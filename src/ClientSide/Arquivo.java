package ClientSide;

import java.io.Serializable;
import java.util.Date;
 

// Classe “carrega” o arquivo que foi escolhido no Client e mais algumas informações importantes //
public class Arquivo implements Serializable {
    
    private static final long serialVersionUID = 1L;
              
    private String nome;
    private byte[] conteudo;
    
    // "Transiente" não é serializado, este é útil apenas no lado do cliente, pois é o cliente que precisa saber para quem ele irá enviar o arquivo, não faz sentido o servidor possuir o campo “ipDestino” na classe Arquivo, enviar este campo seria desperdício de banda e processamento. //
    private transient long tamanhoKB;
    private transient Date dataHoraUpload;
    private transient String ipDestino;
    private transient String portaDestino;
    private String diretorioDestino;
    public String getNome() {
              return nome;
    }
    public void setNome(String nome) {
              this.nome = nome;
    }
    
    public byte[] getConteudo() {
              return conteudo;
    }
    
    public void setConteudo(byte[] conteudo) {
              this.conteudo = conteudo;
    }
    
    public long getTamanhoKB() {
              return tamanhoKB;
    }
    
    public void setTamanhoKB(long tamanhoKB) {
              this.tamanhoKB = tamanhoKB;
    }
    
    public Date getDataHoraUpload() {
              return dataHoraUpload;
    }
    
    public void setDataHoraUpload(Date dataHoraUpload) {
              this.dataHoraUpload = dataHoraUpload;
    }
    
    public String getIpDestino() {
              return ipDestino;
    }
    
    public void setIpDestino(String ipDestino) {
              this.ipDestino = ipDestino;
    }
    
    public String getPortaDestino() {
              return portaDestino;
    }
    
    public void setPortaDestino(String portaDestino) {
              this.portaDestino = portaDestino;
    }
    
    public String getDiretorioDestino() {
              return diretorioDestino;
    }
    
    public void setDiretorioDestino(String diretorioDestino) {
              this.diretorioDestino = diretorioDestino;
    }
}