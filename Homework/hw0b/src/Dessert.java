public class Dessert {
    static int num = 0;

    int flavor;
    int price;

    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        num++;
    }

    public static int numDesserts() {
        return num;
    }

    public void printDessert() {
        System.out.printf("%d %d %d\n", flavor, price, num);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
