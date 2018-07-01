public class Test {
    public static void main(String[] args) throws ArithmeticException {
//        int a[] = {1, 2, 2, 4, -5, 8, -4, 0};
        int a[] = {1, 2, -1, -2, 4, 5, -9, 0, 10, 40};
        int key = 4;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                try {
                    if (a[i] + a[j] == key || a[i] - a[j] == key || a[i] * a[j] == key || a[i] / a[j] == key) {
                        System.out.println(a[i] + " " + a[j]);
                    }
                } catch (Exception ignored) {
                }
            }
        }
    }
}
