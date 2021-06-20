package Reference_Code;

import java.util.Arrays;

public class Eratos {
    public void function(int N) {
        boolean[] prime = new boolean[N+1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            for (int j = i * i; j <= N; j += i)
                prime[j] = false;
        }
    }
}
