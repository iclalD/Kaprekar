import java.util.Scanner;

public class Main {

    public static int add(int[] numbers) { //parçalanıp sıralanan dizi elemanlarını 4 basamaklı bir sayı haline getirme fonksiyonu

        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum = sum*10 + numbers[i];
        }
        return sum;
    }

    public static int arrayDesc(int num) {

        int[] array = new int[4];

        //dizinin her hanesine bir rakam atanması işlemi
        for (int i = 0; i < array.length; i++) {
            int temp = num - (num / 10) * 10;
            array[i] = temp;
            num /= 10;
        }

        //dizi elemanlarının büyükten küçüğe sıralanması
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }


        int sum = add(array);
        //System.out.println(sum);
        return sum;

    }

    public static int arrayAsc(int num) {

        int[] array = new int[4]; //4 haneli dizi

        //dizinin her hanesine bir rakam atanması işlemi
        for (int i = 0; i < array.length; i++) {
            int temp = num - (num / 10) * 10;
            array[i] = temp;
            num /= 10;
        }

        //dizi elemanlarının küçükten büyüğe sıralanması
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        /*for (int i : array) {
            System.out.println(i);
        }*/

        int sum = add(array);
//        System.out.println(sum);

        return sum;
    }

    public static int subtraction(int a, int b, int sayac) { //büyük sayıdan küçük sayının çıkarıldığı recursive(kendini çağıran) fonksiyon
        sayac++; //işlemin kaç kez yapıldığını kontrol eden sayaç mekanizması
        int sum = a - b;
        if (sum == 6174) {
            System.out.println("6174!" + "\nsayac = " + sayac);
        } else {
            System.out.println(sum + " is not equal to 6174...");
            subtraction(arrayDesc(sum), arrayAsc(sum), sayac);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int num = input.nextInt();

        int a = arrayDesc(num);
        int b = arrayAsc(num);

        int sayac = 0;

        subtraction(a, b, sayac);
    }
}
