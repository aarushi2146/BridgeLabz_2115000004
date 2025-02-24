
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}
class CacheSystem {
    private static final Map<String, Object> cache = new HashMap<>();
    public static Object getCachedResult(String key) {
        return cache.get(key);
    }
    public static void putCache(String key, Object result) {
        cache.put(key, result);
    }
}
class ExpensiveComputation {
    @CacheResult
    public int computeFactorial(int n) {
        String cacheKey = "factorial_" + n;
        Integer cachedResult = (Integer) CacheSystem.getCachedResult(cacheKey);
        if (cachedResult != null) {
            System.out.println("Returning cached result for " + n);
            return cachedResult;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        CacheSystem.putCache(cacheKey, result);
        return result;
    }
}
public class CacheMain {
    public static void main(String[] args) throws Exception {
        ExpensiveComputation computation = new ExpensiveComputation();
        System.out.println("Factorial of 5: " + computation.computeFactorial(5));
        System.out.println("Factorial of 5 (cached): " + computation.computeFactorial(5));
        System.out.println("Factorial of 6: " + computation.computeFactorial(6));
        System.out.println("Factorial of 6 (cached): " + computation.computeFactorial(6));
    }
}





