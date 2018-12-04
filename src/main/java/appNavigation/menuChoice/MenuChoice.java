package appNavigation.menuChoice;

public class MenuChoice {
    public static void menuChoice(char selector){
        switch (selector) {
            case '1':
                System.out.println("Opcja pierwsza.");
                break;
            case '2':
                System.out.println("Opcja druga.");
                break;
            case '3':
                System.out.println("Opcja trzecia.");
                break;
            case 'q':
                System.out.println("Zakończenie programu lub coś innego.");
                break;
        }

    }
}
