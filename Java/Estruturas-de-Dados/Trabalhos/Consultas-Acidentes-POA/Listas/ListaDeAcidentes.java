package Listas;

public class ListaDeAcidentes {
    /**
     * Classe interna Nodo. Contém um elemento e uma referência para o próximo.
     */
    private static class Acidente {
        // Referência para o próximo nodo.
        private Acidente next;
        // Dados do acidente.
        private String data;
        private String hora;
        private int idade;
        private String sexo;
        private String sitVitima;
        private String log1;
        private String tipoAcid;
        private int auto;
        private int taxi;
        private int onibusUrb;
        private int onibusMet;
        private int onibusInt;
        private int caminhao;
        private int moto;
        private int carroca;
        private int bicicleta;
        private int outro;
        private int lotacao;
        private String diaSem;
        private String periodoDia;
        private String fxEt;
        private String tipoVeic;

        /**
         * Construtor.
         * @param proximo Nodo seguinte.
         * @param data Data em que ocorreu o acidente.
         * @param hora Hora em que ocorreu o acidente.
         * @param idade Idade da vítima.
         * @param sexo Sexo da vítima.
         * @param sitVitima Informação da condição da vitima.
         * @param log1 Nomo do logradouro onde ocorreu o acidente.
         * @param tipoAcid Informação descritiva do tipo de acidente.
         * @param auto Número de veículos do típo automóvel envolvidos.
         * @param taxi Número de táxis envolvidos no acidente.
         * @param onibusUrb Número de ônibus urbanos envolvidos no acidente.
         * @param onibusMet Número de ônibus metropolitanos envolvidos no acidente.
         * @param onibusInt Número de ônibus interurbanos envolvidos no acidente.
         * @param caminhao Número de veículos do tipo caminhão envolvidos no acidente.
         * @param moto Número de motocicletas envolvidas no acidente.
         * @param carroca Número de carroças envolvidas no acidente.
         * @param bicicleta Número de bicicletas envolvidas no acidente.
         * @param outro Número de outros veículos envolvidos no acidente
         * @param lotacao Número de veículos do tipo lotações envolvidas no acidente.
         * @param diaSem Dia da semana em que ocorreu o acidente.
         * @param periodoDia Período do dia em que ocorreu o acidente.
         * @param fxEt Faixa etária da vítima.
         * @param tipoVeic Informação descritiva do tipo de veículo onde encontrava-se a vítima naquele acidente.
         */
        public Acidente(Acidente proximo, String data, String hora, Integer idade, String sexo,
                        String sitVitima, String log1, String tipoAcid, Integer auto, Integer taxi, Integer onibusUrb,
                        Integer onibusMet, Integer onibusInt, Integer caminhao, Integer moto, Integer carroca,
                        Integer bicicleta, Integer outro, Integer lotacao, String diaSem,
                        String periodoDia, String fxEt, String tipoVeic) {
            this.next = proximo;
            this.data = data;
            this.hora = hora;
            this.idade = idade;
            this.sexo = sexo;
            this.sitVitima = sitVitima;
            this.log1 = log1;
            this.tipoAcid = tipoAcid;
            this.auto = auto;
            this.taxi = taxi;
            this.onibusUrb = onibusUrb;
            this.onibusMet = onibusMet;
            this.onibusInt = onibusInt;
            this.caminhao = caminhao;
            this.moto = moto;
            this.carroca = carroca;
            this.bicicleta = bicicleta;
            this.outro = outro;
            this.lotacao = lotacao;
            this.diaSem = diaSem;
            this.periodoDia = periodoDia;
            this.fxEt = fxEt;
            this.tipoVeic = tipoVeic;
        }

        @Override
        public String toString() {
            return "\nDATA: "+data+"\n"+"HORA: "+hora+"\n"+"IDADE: "+idade+"\n"+"SEXO: "+sexo+"\n"+
                    "SIT_VITIMA: "+sitVitima+"\n"+"RUA: "+log1+"\n"+"TIPO_ACID: "+tipoVeic+"\n"+"AUTO: "+auto+"\n"+
                    "TAXI: "+taxi+"\n"+"ONIBUS_URB: "+onibusUrb+"\n"+"ONIBUS_MET: "+onibusMet+"\n"+
                    "ONIBUS_INT: "+onibusInt+"\n"+"CAMINHAO"+caminhao+"\n"+"MOTO: "+moto+"\n"+"CARROCA: "+carroca+"\n"+
                    "BICICLETA: "+bicicleta+"\n"+"OUTRO: "+outro+"\n"+"LOTACAO: "+lotacao+"\n"+"DIA_SEM: "+diaSem+"\n"+
                    "PERIODO_DIA: " + periodoDia+"\n"+"FX_ET: "+fxEt+"\n"+"TIPO_VEIC: "+tipoVeic;
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Acidente head;
    // Referência para o último elemento da lista encadeada.
    private Acidente tail;
    // Contador de elementos.
    private int count;
    // Nome da rua - usada como identificador das listas de ruas.
    private String rua;

    /**
     * Construtor.
     */
    public ListaDeAcidentes(String rua) {
        this.rua = rua;
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Valor booleano para o estado de tamanho atual da lista - se está vazia ou não.
     * @return true ou false
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Informa o tamanho atual da lista.
     * @return tamanho da lista.
     */
    public int size() {
        return this.count;
    }

    /**
     * Esvazia a lista e retorna aos seus valores padrão.
     */
    public void clear() {
        this.rua = null;
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Adiciona um Acidente na posição passada como parâmetro.
     * @param indice Posição que o nodo Acidente será inserido na lista.
     * @param data Data em que ocorreu o acidente.
     * @param hora Hora em que ocorreu o acidente.
     * @param idade Idade da vítima.
     * @param sexo Sexo da vítima.
     * @param sitVitima Informação da condição da vitima.
     * @param tipoAcid Informação descritiva do tipo de acidente.
     * @param auto Número de veículos do típo automóvel envolvidos.
     * @param taxi Número de táxis envolvidos no acidente.
     * @param onibusUrb Número de ônibus urbanos envolvidos no acidente.
     * @param onibusMet Número de ônibus metropolitanos envolvidos no acidente.
     * @param onibusInt Número de ônibus interurbanos envolvidos no acidente.
     * @param caminhao Número de veículos do tipo caminhão envolvidos no acidente.
     * @param moto Número de motocicletas envolvidas no acidente.
     * @param carroca Número de carroças envolvidas no acidente.
     * @param bicicleta Número de bicicletas envolvidas no acidente.
     * @param outro Número de outros veículos envolvidos no acidente
     * @param lotacao Número de veículos do tipo lotações envolvidas no acidente.
     * @param diaSem Dia da semana em que ocorreu o acidente.
     * @param periodoDia Período do dia em que ocorreu o acidente.
     * @param fxEt Faixa etária da vítima.
     * @param tipoVeic Informação descritiva do tipo de veículo onde encontrava-se a vítima naquele acidente.
     */
    public void addAcidenteIdx(Integer indice, String data, String hora, Integer idade, String sexo,
                               String sitVitima, String tipoAcid, Integer auto, Integer taxi, Integer onibusUrb,
                               Integer onibusMet, Integer onibusInt, Integer caminhao, Integer moto, Integer carroca,
                               Integer bicicleta, Integer outro, Integer lotacao, String diaSem,
                               String periodoDia, String fxEt, String tipoVeic) {
        Acidente inserir = new Acidente(null, data, hora, idade, sexo, sitVitima, this.rua, tipoAcid, auto, taxi, onibusUrb,
                onibusMet, onibusInt, caminhao, moto, carroca, bicicleta, outro, lotacao, diaSem, periodoDia, fxEt, tipoVeic);

        // Lança exceção se o índice for inválido.
        if (indice < 0 || indice > this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Se o índice for a primeira posição...
        if (indice == 0) {
            // ...e a lista estiver vazia:
            if (this.head == null) {
                this.tail = inserir;
            // ...e a lista não estiver vazia:
            } else {
                inserir.next = head;
            }
            this.head = inserir;
        // Se o índice for a última posição:
        } else if (indice == this.count) {
            this.tail.next = inserir;
            this.tail = inserir;
        // Se o índice estiver no meio da lista.
        } else {
            Acidente ant = this.head;
            for (int i = 0; i < indice - 1; i++) {
                ant = ant.next;
            }
            inserir.next = ant.next;
            ant.next = inserir;
        }

        this.count++;
    }

    /**
     * Adiciona um Acidente (nodo) no fim da lista de acidentes.
     * @param data Data em que ocorreu o acidente.
     * @param hora Hora em que ocorreu o acidente.
     * @param idade Idade da vítima.
     * @param sexo Sexo da vítima.
     * @param sitVitima Informação da condição da vitima.
     * @param tipoAcid Informação descritiva do tipo de acidente.
     * @param auto Número de veículos do típo automóvel envolvidos.
     * @param taxi Número de táxis envolvidos no acidente.
     * @param onibusUrb Número de ônibus urbanos envolvidos no acidente.
     * @param onibusMet Número de ônibus metropolitanos envolvidos no acidente.
     * @param onibusInt Número de ônibus interurbanos envolvidos no acidente.
     * @param caminhao Número de veículos do tipo caminhão envolvidos no acidente.
     * @param moto Número de motocicletas envolvidas no acidente.
     * @param carroca Número de carroças envolvidas no acidente.
     * @param bicicleta Número de bicicletas envolvidas no acidente.
     * @param outro Número de outros veículos envolvidos no acidente
     * @param lotacao Número de veículos do tipo lotações envolvidas no acidente.
     * @param diaSem Dia da semana em que ocorreu o acidente.
     * @param periodoDia Período do dia em que ocorreu o acidente.
     * @param fxEt Faixa etária da vítima.
     * @param tipoVeic Informação descritiva do tipo de veículo onde encontrava-se a vítima naquele acidente.
     */
    public void addAcidente(String data, String hora, Integer idade, String sexo,
                            String sitVitima, String rua, String tipoAcid, Integer auto, Integer taxi, Integer onibusUrb,
                            Integer onibusMet, Integer onibusInt, Integer caminhao, Integer moto, Integer carroca,
                            Integer bicicleta, Integer outro, Integer lotacao, String diaSem,
                            String periodoDia, String fxEt, String tipoVeic) {
        Acidente aux = new Acidente(null, data, hora, idade, sexo, sitVitima, this.rua, tipoAcid, auto, taxi, onibusUrb,
                onibusMet, onibusInt, caminhao, moto, carroca, bicicleta, outro, lotacao, diaSem, periodoDia, fxEt, tipoVeic);

        if (this.head == null) {
            this.head = aux;
        } else {
            this.tail.next = aux;
        }
        this.tail = aux;
        this.count++;
    }

    /**
     * Retorna um dado (log,hora,tct...) de um Acidente (nodo) de índice escolhido.
     * @param indice indice do nodo (Acidente).
     * @return elemento a ser retornado.
     */
    public String getInfo(int indice, String coluna) {
        // Lança uma exceção se o indice passado for inválido.
        if (indice < 0 || indice >= this.count)
            throw new IndexOutOfBoundsException("Indice invalido!");

        // Identifica a coluna (tipo de dado).
        String saida;
        if (coluna.equals("data")) {
            if (indice == this.count - 1) {
                return this.tail.data;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.data;
            }
        } else if (coluna.equals("hora")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                return this.tail.hora;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.hora;
            }
        } else if (coluna.equals("idade")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                return Integer.toString(this.tail.idade);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(this.tail.idade);
            }
        } else if (coluna.equals("sexo")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                return this.tail.sexo;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.sexo;
            }
        } else if (coluna.equals("sitVitima")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                return this.tail.sitVitima;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.sitVitima;
            }
        } else if (coluna.equals("log1")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                return this.tail.log1;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.log1;
            }
        } else if (coluna.equals("tipoAcid")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                return this.tail.tipoAcid;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.tipoAcid;
            }
        } else if (coluna.equals("auto")) {
           // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.auto);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.auto);
            }
        } else if (coluna.equals("taxi")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.taxi);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.taxi);
            }
        } else if (coluna.equals("onibusUrb")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.onibusUrb);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.onibusUrb);
            }
        } else if (coluna.equals("onibusMet")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.onibusMet);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.onibusMet);
            }
        } else if (coluna.equals("onibusInt")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.onibusInt);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.onibusInt);
            }
        } else if (coluna.equals("caminhao")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.caminhao);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.caminhao);
            }
        } else if (coluna.equals("moto")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.moto);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.moto);
            }
        } else if (coluna.equals("carroca")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.carroca);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.carroca);
            }
        } else if (coluna.equals("bicicleta")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.bicicleta);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.bicicleta);
            }
        } else if (coluna.equals("outro")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.outro);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.outro);
            }
        } else if (coluna.equals("lotacao")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = Integer.toString(this.tail.lotacao);
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = Integer.toString(aux.lotacao);
            }
        } else if (coluna.equals("diaSem")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = this.tail.diaSem;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.diaSem;
            }
        } else if (coluna.equals("periodoDia")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = this.tail.periodoDia;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.periodoDia;
            }
        } else if (coluna.equals("fxEt")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = this.tail.fxEt;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.fxEt;
            }
        } else if (coluna.equals("tipoVeic")) {
            // Retorna o tail se o indice for o deste.
            if (indice == this.count - 1) {
                saida = this.tail.tipoVeic;
            } else {
                // Procura pelo indice passado.
                Acidente aux = this.head;
                for (int i = 0; i < indice; i++) {
                    aux = aux.next;
                }
                saida = aux.tipoVeic;
            }
        } else {
            throw new NullPointerException("Coluna inválida!");
        }

        return saida;
    }

    /**
     * Retorna Acidente (nodo) de posição indice.
     * @param indice posição do acidente na lista de cidentes.
     * @return Acidente (nodo).
     */
    public Acidente getAcidente(int indice) {
        // Lança um erro caso o parâmetro passado seja negativo ou maior/igual ao número de elementos.
        if ((indice < 0) || (indice >= count))
            throw new IndexOutOfBoundsException();

        // Percorre a lista até o índice passado como parâmentro.
        Acidente aux = this.head;
        for (int i = 0; i < indice; i++) {
            aux = aux.next;
        }

        return aux;
    }

    /**
     * Remove da lista o Acidente (nodo) de posição indice.
     */
    public void remove(int indice) {
        // Se a lista estiver vazia:
        if (this.count == 0)
            throw new ListaVaziaErro("A lista de acidentes está vazia!");

        Acidente aux = this.head.next;
        Acidente ant = this.head;

        // Se o Acidente (nodo) a ser removido for o primeiro da lista (head).
        if (indice == 0) {
            this.head = head.next;
            // Se a lista conter apenas um elemento.
            if (this.count == 1) {
                this.tail = null;
            }
        // Se o Acidente (nodo) for o último da lista (tail).
        } else if (indice == this.count) {
            for (int i = 0; i != this.count; i++) {
                ant = ant.next;
                aux = aux.next;
            }
            this.tail = ant;
            this.tail.next = null;
        // Se estiver no meio da lista.
        } else {
            // Percorre a lista até encontrar a posição do elemento para removê-lo.
            for (int i = 0; i != indice - 1; i++) {
                aux = aux.next;
                assert ant != null;
                ant = ant.next;
            }
        }

        assert ant != null;
        ant.next = aux.next;
        this.count--;
    }

    /**
     * Conta o número de ocorrências do elemento passado como parâmetro.
     * @param dia elemento a ser contabilizado.
     * @return quantidade de vezes que ele aparece na lista.
     */
    public int acidentesPorDia(String dia) {
        Acidente aux = this.head;
        int count = 0;

        for (int i = 0; i < this.count; i++) {
            if (aux.diaSem.equals(dia)) count++;
            aux = aux.next;
        }

        return count;
    }

    /**
     * Calcula a quantidade de veiculos envolvidos no acidente de índice passado como parâmetro.
     * @param indice indice do acidente.
     * @return quantidade total de veiculos envolvidos.
     */
    public int qtdVeiculosEnvolvidos(int indice) {
        Acidente acidente = getAcidente(indice);

        return acidente.auto + acidente.taxi + acidente.onibusUrb + acidente.onibusMet + acidente.onibusInt +
                acidente.caminhao + acidente.moto + acidente.carroca + acidente.bicicleta + acidente.outro + acidente.lotacao;
    }

    /**
     * Calcula a quantidade total de acidentes envolvendo motos.
     * @return quantidade total.
     */
    public int qtdTotalDeMotos() {
        Acidente aux = this.head;
        int count = 0;

        // Contabiliza o head.
        if (aux.moto != 0) {
            count++;
        }

        // Percorre a lista de acidentes fazendo o somatório da quantidade de motos envolvidas.
        while (aux != this.tail) {
            if (aux.moto != 0) {
                count++;
            }
            aux = aux.next;
        }

        return count;
    }

    @Override
    public String toString() {
        return "Lista de acidentes da " + this.rua;
    }
}
