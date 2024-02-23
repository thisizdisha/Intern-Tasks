package Ss_Zone_Tech;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class Task{
    private String name,description;
    private LocalDate dueDate;

    public Task(String name, String description, LocalDate dueDate){
        this.name = name;
        this.description = description;         
        this.dueDate = dueDate;
    }

    public String getName(){
        return name;
    }

    public String  getDescription(){
        return description;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    @Override
    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return  "Task { " + "Name = " + name + "\n" + "Description = " + description +  "\n" + "Due Date = " + dueDate.format(formatter) + "}";
    }
}

public class TaskManagementSystem {
    /**
     * @param args
     */
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println();
            System.out.println("Type 1 to add a new task to your To-Do-List");
            System.out.println("Type 2 to view the tasks in your To-Do-List");
            System.out.println("Type 3 to remove a task from the To-Do-List");
            System.out.println("Type 4 to exit the program.");
            System.out.println("Select an option : ");
            int opt = sc.nextInt();

            if(opt == 1){
                sc.nextLine();
                System.out.println("Enter the name of the task : ");
                String  name = sc.nextLine();
                System.out.println("Enter the description of the task: ");
                String description = sc.nextLine();
                System.out.println("Enter the due date of the task (yyyy-mm-dd):");
                String dueDateInput = sc.nextLine();
                LocalDate dueDate = LocalDate.parse(dueDateInput,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                tasks.add(new Task(name, description, dueDate));
            } else if (opt == 2){
                for (Task task : tasks){
                    System.out.println(task);
                }
            } else if (opt == 3){
                System.out.println("Enter the name of the task to remove : ");
                String name1 = sc.nextLine();
                String name = sc.nextLine();
                Task taskToRemove = null;
                for(Task task : tasks){
                    if(task.getName().equals(name)){
                        taskToRemove = task;
                        break;
                    }
                }
                if(taskToRemove!=null){
                    tasks.remove(taskToRemove);
                    System.out.println("The task has been removed successfully!");
                }
            } else if(opt == 4){
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid input. Please type again. ");
            }
        }
    }
}
    
