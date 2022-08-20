import java.util.Scanner;

class BeeCrowd1052 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] meses = {"January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"};

        int entrada = in.nextInt();
        in.close();

        System.out.println(meses[entrada - 1]);
    }
}