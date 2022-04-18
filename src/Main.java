import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1. Leap year or not. Version 2 with method

        int year = 2077; // Cyberpunk forever!
        if(leapYearOrNot(year))
            System.out.println(year + " - високосный год");
        else
            System.out.println(year + " - не високосный год");

        // Task 2. Client mobile device OS & year of manufacturing

        String[] userMessages = {"Установите облегченную версию приложения для Android по ссылке.",
                "Установите версию приложения для Android по ссылке",
                "Установите облегченную версию приложения для iOS по ссылке",
                "Установите версию приложения для iOS по ссылке"};
        boolean clientOS = false;
        int clientDeviceYear = LocalDate.now().getYear();
        System.out.println(userMessages[checkAppsVersion(clientOS, clientDeviceYear)]);

        // clientOS = true;
        // clientDeviceYear = 2077;
        // System.out.println(userMessages[checkAppsVersion(clientOS, clientDeviceYear)]);

        // clientOS = false;
        // clientDeviceYear = 2010;
        // System.out.println(userMessages[checkAppsVersion(clientOS, clientDeviceYear)]);

        // clientOS = true;
        // clientDeviceYear = 2010;
        // System.out.println(userMessages[checkAppsVersion(clientOS, clientDeviceYear)]);

        // Task 3. Banking card delivery calculation

        float distance = 61.5f;
        int deliveryDays = calculateDeliveryDays(distance);
        if(deliveryDays > 0){
            System.out.println("На доставку вашей карты потребуется дней: " + deliveryDays);
        } else {
            System.out.println("Приносим извинения за неудобства, мы не доставляем карты клиентам, " +
                    "живущим на таком расстоянии офиса банка");
        }

        // Task 4. Are there any duplicated in the string
        // String string = "aabccddefgghiijjkk";
        String string = "abcdefghijk";

        checkDuplicates(string);

        // Task 5. Reverse array
        int[] array = {3, 2, 1, 6, 5};
        System.out.println("Было: " + Arrays.toString(array));
        reverseArray(array);
        System.out.println("Стало: " + Arrays.toString(array));

    }

    public static boolean leapYearOrNot(int year){

        boolean isFourHundredth = (year % 400) == 0, isHundredth = (year % 100) == 0,
                isFourth = (year % 4) == 0;

        if(isFourHundredth) {
            return true;
        } else if(isHundredth) {
            return false;
        } else if(isFourth) {
            return true;
        } else {
            return false;
        }
    }

    public static int checkAppsVersion(boolean clientOS, int clientDeviceYear) {

        boolean before2015OrNot = clientDeviceYear < 2015;

        if(clientOS && before2015OrNot){
            return 0;
        } else if (clientOS && !before2015OrNot) {
            return 1;
        } else if (!clientOS && before2015OrNot) {
            return 2;
        } else {
            return 3;
        }
    }

    public static int calculateDeliveryDays(float distance){

        int deliveryDays = 1;

        if(distance < 0f){
            throw new RuntimeException("Ошибка! Расстояние до клиента не может быть отрицательным!");
        } else if(distance > 20.0f && distance <= 60.0f) {
            deliveryDays++;
        } else if(distance > 60.0f && distance <= 100.0f) {
            deliveryDays += 2;
        } else {
            return -1;
        }
        return deliveryDays;
    }

    public static void checkDuplicates(String s){

        System.out.println("String argument = " + s);

        int currentPosition = 0;
        char currentChar = 'a';

        for(int i = 0; i < s.length()-1; i++)
            if(s.charAt(i) == s.charAt(i+1)){
                System.out.println("Duplicate found! Duplicated character: " + currentChar +
                        " at position " + i);
                return;
            }
        System.out.println("String argument doesn't contain any duplicates");

    }

    public static void reverseArray(int[] array){
        for(int i = 0; i < array.length / 2; i++){
            array[i] =array[i] + array[array.length - 1 - i];
            array[array.length - 1 - i] = array[i] - array[array.length - 1 - i];
            array[i] = array[i] -    array[array.length - 1 - i];
        }
    }

}