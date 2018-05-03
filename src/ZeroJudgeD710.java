
import java.util.Scanner;

/**
 *
 * @author Ethan
 */
public class ZeroJudgeD710 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while( scanner.hasNext() ) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            ParkingLot p = new ParkingLot(n, scanner);

            p.query(m, scanner);
        }
    }

    private static class ParkingLot {
        Car[] cars;

        ParkingLot(int n, Scanner scanner) {
            cars = new Car[n];
            for(int i=0; i<n; i++){
                cars[i] = new Car(scanner.next(), scanner.next());
            }
        }
        
        void query(int m, Scanner scanner){
            for(int i=0; i<m; i++){
                String type = scanner.next();
                String value = scanner.next();
                
                if(type.equals("brand")){
                    for(int j=0; j<cars.length; j++)
                        if(value.equals(cars[j].brand))
                            System.out.println(cars[j].brand + " " + cars[j].color);
                }else{
                    for(int j=0; j<cars.length; j++)
                        if(value.equals(cars[j].color))
                            System.out.println(cars[j].brand + " " + cars[j].color);
                }
            }
            System.out.println();
        }
    }
    
    private static class Car {
        String brand, color;
        Car(String brand, String color){
            this.brand = brand;
            this.color = color;
        }
    }
}
