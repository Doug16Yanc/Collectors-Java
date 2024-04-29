package list.OperacoesBasicas.Tarefas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaTarefas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Tarefa> tarefas = new ArrayList<>();
        String descricao = "";

        System.out.println("Seja bem-vindo(a) ao nosso sistema de tarefas.\n");
        do {
            System.out.println("Escolha sua opção.\n");
            System.out.println("0 - Encerrar operações\n" +
                    "1 - Adicionar tarefa\n" +
                    "2 - Remover tarefa\n" +
                    "3 - Obter número total de tarefas\n" +
                    "4 - Obter descrição de tarefas\n");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 0:
                    System.out.println("Sua despedida é sempre tão dolorosa.\n");
                    System.exit(0);
                case 1:
                    System.out.println("Dê a descrição da tarefa, por favor");
                    descricao = sc.nextLine();
                    new ListaTarefas().adicionarTarefa(tarefas, descricao);
                    break;
                case 2:
                    System.out.println("Dê a descrição da tarefa, por favor");
                    descricao = sc.nextLine();
                    new ListaTarefas().removerTarefa(tarefas, descricao);
                    break;
                case 3:
                    new ListaTarefas().obterNumeroTotalTarefas(tarefas);
                    break;
                case 4:
                    new ListaTarefas().obterDescricoesTarefas(tarefas);
                    break;

            }
        } while (true);
    }
    private void adicionarTarefa(List<Tarefa> tarefas, String descricao){
         Tarefa tarefa = new Tarefa(descricao);
         tarefas.add(tarefa);
        System.out.println("Tarefa adicionada com sucesso.\n");
    }
    private boolean removerTarefa(List<Tarefa> tarefas, String descricao){
        List<Tarefa> tarefaRemovida = new ArrayList<>();
        if (!tarefas.isEmpty()) {
            for (Tarefa tarefa : tarefas) {
                if (tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefaRemovida.add(tarefa);
                    System.out.println("Tarefa removida com sucesso.\n");
                }
            }
        }
        else{
            System.out.println("Lista de tarefas vazia.\n");
        }
        tarefas.removeAll(tarefaRemovida);
        return true;
    }
    private int obterNumeroTotalTarefas(List<Tarefa> tarefas){
        int numero = 0;
        if (!tarefas.isEmpty()){
            numero = tarefas.size();
            System.out.println("" + numero);
        }
        else{
            System.out.println("Lista de tarefas vazia.\n");
        }
        return numero;
    }
    private void obterDescricoesTarefas(List<Tarefa> tarefas){
        if (!tarefas.isEmpty()){
            for (Tarefa tarefa : tarefas){
                System.out.println("" + tarefa.getDescricao());
            }
        }
        else{
            System.out.println("Lista de tarefas vazia.\n");
        }
    }
}
