public class StringConcatenationComparison {
    public static void testStringConcatenation(int count) {
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < count; i++) {
            result += "a";
        }
        long timeTaken = System.nanoTime() - start;
        System.out.println("String Concatenation Time: " + (timeTaken / 1_000_000.0) + " ms");
    }
    public static void testStringBuilderConcatenation(int count) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        long timeTaken = System.nanoTime() - start;
        System.out.println("StringBuilder Concatenation Time: " + (timeTaken / 1_000_000.0) + " ms");
    }
    public static void testStringBufferConcatenation(int count) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < count; i++) {
            sb.append("a");
        }
        long timeTaken = System.nanoTime() - start;
        System.out.println("StringBuffer Concatenation Time: " + (timeTaken / 1_000_000.0) + " ms");
    }
    public static void main(String[] args) {
        int[] count = {1_000, 10_000, 1_000_000};
		for(int i=0;i<count.length;i++){
			System.out.println("Testing with " + count[i] + " concatenations:");
			testStringConcatenation(count[i]);
			testStringBuilderConcatenation(count[i]);
			testStringBufferConcatenation(count[i]);
		}
    }
}
