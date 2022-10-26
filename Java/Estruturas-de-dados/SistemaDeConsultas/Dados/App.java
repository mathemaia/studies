import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    
    static LinkedListOfString Cabecalhos;
    static LinkedListOfString Acidentes;

    public static int LeCabecalho (String S)
    {
        String palavras[];
        palavras = S.split(";");
        for(int i=0;i<palavras.length;i++)
        {
            Cabecalhos.add(palavras[i]);
        }
        //System.out.println("Nro de campos:" + aux.length);
        return palavras.length;
    }
    public static int DivideLinha(String S)
    {
        // Busca o indice da coluna que tem os campos de interesse
        // na lista de Cabecalhos
        int indLogradouro = Cabecalhos.indexOf("log1");
        //System.out.println("Indice da coluna Logradouro:" + indLogradouro);
        int indHora = Cabecalhos.indexOf("hora");
        //System.out.println("Indice da coluna Hora:" + indHora);
        String palavras[];
        palavras = S.split(";");
        
        // Passa em cada uma das palavras separadas do ';'
        // A cada passo deste laco, a variavel 'palavra[i]' tem uma das
        // palavras da linha
        // Qdo a coluna da palavra eh igual a uma das colunas de
        // interesse, coloca a palavra na frase de saida
        StringBuilder frase = new StringBuilder();
        for(int i=0;i<palavras.length;i++)
        {
            if (i == indHora) // se for a 'hora' adiciona na lista
            {
                 frase.append(palavras[i]);
            }   
            if (i == indLogradouro) // se for a 'hora' adiciona na lista
            {
                 frase.append(" - " + palavras[i]);
            } 
        }
        Acidentes.add(frase.toString());

        return palavras.length;
    }
    public static void LeArquivo(String nome)
    {
        Path path1 = Paths.get(nome);

        try (BufferedReader reader = Files.newBufferedReader(path1, Charset.defaultCharset())) {
            String aux[];
    
            String line = null;
            line = reader.readLine();
            int nroDeCampos = LeCabecalho(line);
            System.out.println("Lista de Cabecalhos:");
            System.out.println(Cabecalhos.toString());

            int cont = 0;
            while ((line = reader.readLine()) != null) {
                //System.out.println(cont + " - " + line);
                int n = DivideLinha(line);
                if (n!=nroDeCampos)
                {
                    System.out.println("Linha com nro invalido de campos");
                    System.out.println("Nro de campos lidos: " + n);
                    System.out.println("Linha lida:" + line);
                    return;
                }
                cont++;
            }
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }  
    }
    public static void main(String[] args) {
       
        Cabecalhos = new LinkedListOfString();
        Acidentes = new LinkedListOfString();

        LeArquivo("DezLinhas.csv");
        //LeArquivo("cat_vitimas.csv");

        System.out.println("Lista de Acidentes:");
        System.out.println(Acidentes.toString());
       
    }
     
}
