public class AplikasiTodolist {

    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }


    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("nama");
        System.out.println("Hi " + name);
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    /**
     * test show todo list
     */
    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi TodoList";
        showTodoList();

    }

    /**
     * Menambahkan todo ke list
     *
     * @param todo = "menambahkan contoh todo ke"+ jumlahtodo
     */
    public static void addTodoList(String todo) {
        var isFull = true;

        // cek apakah array model masih penuh
        for (int i = 0; i < model.length; i++) {
            // cek apakah penuh
            if (model[i] == null) {
                isFull = false;
            }
        }

        // jika penuh maka panjang model dikali 2
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambah todo jika model masih kosong
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /**
     * Test untuk menambahkan todo ke list
     */
    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke :" + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari
     *
     * @param number = nomor list todo
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == model.length - 1) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /**
     * test Remove Todo List
     */
    public static void testRemoveTodoList() {
        for (int i = 0; i < 10; i++) {
            addTodoList("index ke : " + i);
        }


        var result = removeTodoList(20);
        System.out.println(result);


        result = removeTodoList(1);
        System.out.println(result);
        showTodoList();
    }

    /**
     * Menampilkan view show todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Perintah tidak dimengerti");
            }
        }
    }


    public static void testViewShowTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");

        viewShowTodoList();
    }

    /**
     * Menampilkan view add todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("Todo (x Jika Batal)");

        if (todo.equals("x")) {

        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        viewAddTodoList();
        showTodoList();
    }

    /**
     * Menampilkan view remove todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Todo (x Jika Batal)");


        if (number.equals("x")) {

        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist dengan index : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
