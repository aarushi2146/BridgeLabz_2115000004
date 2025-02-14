
public class LinearSearchSpecificWord {
    public static void main(String[] args) {
        String[] sentences = {
            "The sun sets in the west.",
            "I enjoy reading books on weekends.",
            "Technology is evolving rapidly.",
            "Artificial intelligence is the future."
        };        
        String word = "reading";
        String result = findSentenceContainingWord(sentences, word);
        System.out.println("Sentence containing the word: " + result);
    }
    public static String findSentenceContainingWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }
}


