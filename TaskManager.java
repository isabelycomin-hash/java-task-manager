import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return (completed ? "[X] " : "[ ] ") + description;
    }
}

public class TaskManager {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Marcar tarefa como concluída");
            System.out.println("4 - Remover tarefa");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    listTasks();
                    break;
                case 3:
                    completeTask();
                    break;
                case 4:
                    removeTask();
                    break;
                case 0:
                    System.out.println("Saindo... Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (option != 0);
    }

    private static void addTask() {
        System.out.print("Digite a descrição da tarefa: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Tarefa adicionada!");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            System.out.println("\n--- Lista de Tarefas ---");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private static void completeTask() {
        listTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Digite o número da tarefa concluída: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.get(index).markCompleted();
                System.out.println("Tarefa marcada como concluída!");
            } else {
                System.out.println("Número inválido!");
            }
        }
    }

    private static void removeTask() {
        listTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Digite o número da tarefa para remover: ");
            int index = scanner.nextInt() - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Tarefa removida!");
            } else {
                System.out.println("Número inválido!");
            }
        }
    }
}
