import java.util.Scanner;

public class RSA {
    public static int multi(int x, int y, int n) {
        int k=1;
        for(int j=1; j<=y; j++) {
            k=(k*x)%n;
        }
        return k;
    }

    public static int gcd(int m, int n) {
        if(n==0) return m;
        else return gcd(n,m%n);
    }

    public static int isprime(int num) {
        int temp;
        boolean isprime=true;
        for(int k=2; k<=num/2; k++) {
            temp=num%k;
            if(temp==0) {
                isprime=false;
                break;
            }
        }
        if(!isprime) {
            System.out.println(num + "not a prime number.");
            return 0;
        } else {
            System.out.println(num+" is a prime number.");
            return num;
        }
    }

    public static void main(String[] args) {
        int msg, plaintext, ciphertext;
        int n,d=0,e,z,p,q,i;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two values p & q:");
        p = sc.nextInt();
        q = sc.nextInt();

        int a = isprime(p);
        int b = isprime(q);

        if((a==p && b==q) && (a!=0 && b!=0)) {
            System.out.println("Enter message:");
            msg =sc.nextInt();

            n=p*q;
            z=(p-1)*(q-1);

            do {
                System.out.println("Choose the value of e uch that gcd(z,e)=1");
                e=sc.nextInt();
            } while(gcd(z,e)!=1);

            i=2;
            while (((i*e)%z)!=1) {
                i++;
                d=i;
            }

            System.out.println("The public key pair i ("+e+","+n+")");
            System.out.println("The private key pair is ("+d+","+n+")");

            ciphertext = multi(msg, e, n);
            System.out.println("Cipher text = "+ciphertext);

            plaintext = multi(ciphertext, d, n);
            System.out.println("Plain text = "+plaintext);
        }

        sc.close();
    }
}
