package bms.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        while (n > 1) {
            if (n % 2 == 1)
                return false;
            else
                n /= 2;
        }
        return true;
    }

    @Test
    public void checkAns() {
        int n1 = 0;
        assert !isPowerOfTwo(n1);
        int n2 = 1;
        assert isPowerOfTwo(n2);
        int n3 = 16;
        assert isPowerOfTwo(n3);

    }
}