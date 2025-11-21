import java.util.Scanner;

class LeakyBucket {
    public static void main(String[] args) {

        int bucket_rem = 0;      // current content in bucket
        int bucket_cap = 3;      // bucket capacity
        int rate = 3;            // leak rate (per second)

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of packets: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter the packets:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("clock\tpacket\trecv\tsent\tremaining");

        for (int i = 0; i < n; i++) {
            int recv;
            int sent;

            // RECEIVE STAGE
            if (a[i] != 0) {
                if (bucket_rem + a[i] > bucket_cap) {
                    recv = -1; // dropped
                } else {
                    recv = a[i];
                    bucket_rem += a[i];
                }
            } else {
                recv = 0;
            }

            // SEND STAGE
            if (bucket_rem != 0) {
                if (bucket_rem < rate) {
                    sent = bucket_rem;
                    bucket_rem = 0;
                } else {
                    sent = rate;
                    bucket_rem -= rate;
                }
            } else {
                sent = 0;
            }

            // PRINT
            if (recv == -1) {
                System.out.println((i+1) + "\t" + a[i] + "\tdrop\t" + sent + "\t" + bucket_rem);
            } else {
                System.out.println((i+1) + "\t" + a[i] + "\t" + recv + "\t" + sent + "\t" + bucket_rem);
            }
        }

        sc.close();
    }
}
