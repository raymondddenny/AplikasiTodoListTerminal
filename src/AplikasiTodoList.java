import java.util.Scanner;

public class AplikasiTodoList {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static String[] modelTodo = new String[10];


    public static void main(String[] args) {

//        testShowTodoList();
//        testAddTodo();
//        testShowTodoList();
//        testRemoveTodo();
//        testShowTodoList();

//        var data = input("Masukkan nama");
//        System.out.println("Hi " + data);

        viewShowTodoList();



    }


    /**
     * show current todo list
     */
    public static void showTodoList(){

        boolean isAllNull = true;


        for (String todo : modelTodo
             ) {
            if(todo!=null){
                isAllNull = false;
            }
        }

        if(isAllNull){
            System.out.println("No todo list");
            return;
        }

        for (int i=0;i<modelTodo.length; i++){
            var todo = modelTodo[i];
            var noTodo = i+1;

            if(todo!=null){
                System.out.println( noTodo + ". " + todo);
                
            }
        }

    }

    public static void testShowTodoList(){
//        modelTodo[0]="Belajar java programming basic";
//        modelTodo[1]="Membuat todo java application";
        showTodoList();
    }


    /**
     * to add the new todo
     * @param todoName
     */
    public static void addTodo(String todoName){

        Boolean isFull = true;

        //check if the modelTodo full
        for (int i = 0; i < modelTodo.length; i++) {
            if(modelTodo[i]==null){
                //model still empty
                isFull = false;
                break;
            }
        }

        // if the current array is full, we add the length
        if(isFull){
            System.out.println("Current array for todo is full, adding the new length");
            var tempModel = modelTodo;
            modelTodo = new String[modelTodo.length*2];

            // add the tempdata to the new array with new length
            for (int i = 0; i < tempModel.length; i++) {
                modelTodo[i] = tempModel[i];
            }
        }

        //check with array that data is null
        for (int i = 0; i < modelTodo.length; i++) {
            if(modelTodo[i]==null){
                modelTodo[i] = todoName;
                break;
            }
        }

    }


    public static void testAddTodo(){
        addTodo("Test nambah todo 1");
        addTodo("Test nambah todo 2");
        addTodo("Test nambah todo 3");
        addTodo("Test nambah todo 4");
        addTodo("Test nambah todo 5");
        addTodo("Test nambah todo 6");
        addTodo("Test nambah todo 7");
        addTodo("Test nambah todo 8");
        addTodo("Test nambah todo 9");
        addTodo("Test nambah todo 10");
        addTodo("Test nambah todo 11");

    }

    /**
     * to remove the selected todo
     * @param noTodo
     */
//    public static String removeTodo(Integer noTodo){
//       if((noTodo-1)>= modelTodo.length){
//           return "Data ke "+ noTodo + " Tidak ada";
//       } else if(modelTodo[noTodo-1]==null){
//           return "Data ke "+ noTodo + " Tidak ada/null";
//       } else{
//           System.out.println("notodo index = " + (noTodo-1));
//           for (int i = (noTodo-1); i < modelTodo.length; i++) {
////               System.out.println("i ke - " + i );
////               if(i==(modelTodo.length-1)){
////                   modelTodo[i] = null;
////               } else{
////                   modelTodo[i] = modelTodo[noTodo+1];
////               }
//               modelTodo[i] = modelTodo[noTodo+1];
//           }
//           modelTodo[modelTodo.length-1] = null;
//           return "Data ke " + noTodo + " berhasil di hapus";
//       }
//    }

    public static String removeTodo(Integer noTodo) {
        if (noTodo <= 0 || noTodo > modelTodo.length || modelTodo[noTodo - 1] == null) {
            return "Data ke " + noTodo + " Tidak ada";
        } else {
            System.out.println("notodo index = " + (noTodo - 1));
            for (int i = noTodo - 1; i < modelTodo.length - 1; i++) {
                modelTodo[i] = modelTodo[i + 1];
            }
            modelTodo[modelTodo.length - 1] = null;

            return "Data ke " + noTodo + " berhasil dihapus";
        }
    }


    public static void testRemoveTodo(){
        addTodo("Data 1");
        addTodo("Data 2");
        addTodo("Data 3");
       var result =  removeTodo(5);
        System.out.println(result);
        showTodoList();
    }


    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;

    }


    /**
     * View todo list
     */
    public static void viewShowTodoList(){
        showTodoList();

        System.out.println("Menu:");
        System.out.println("1. tambah");
        System.out.println("2. hapus");
        System.out.println("3. Exit app");
        var input = input("Pilih perintah");

        switch (input){
            case "1":
                var newTodo = input("Masukan todo baru");
                addTodo(newTodo);
                viewShowTodoList();
                break;
            case "2":
                var todoToRemove = input("Masukan angka todo yang mau dihapus");
                removeTodo(Integer.parseInt(todoToRemove));
                viewShowTodoList();
                break;

            case "3":
                System.out.println("Exit the program....");
                System.exit(0);
            default:
                System.out.println("Perintah tidak ada silahkan ulangi kembali");
                viewShowTodoList();

        }

//        if(input.equals("1")){
//            var newTodo = input("Masukan todo baru");
//            addTodo(newTodo);
//            viewShowTodoList();
//        } else if (input.equals("2")){
//            var todoToRemove = input("Masukan angka todo yang mau dihapus");
//            removeTodo(Integer.parseInt(todoToRemove));
//            viewShowTodoList();
//        } else {
//            System.out.println("Perintah tidak ada silahkan ulangi kembali");
//            viewShowTodoList();
//        }
    }

    /**
     * View add todo
     */
    public static void viewAddTodo(){}

    /**
     * View remove todo
     */
    public static void viewRemoveTodo(){}
}
