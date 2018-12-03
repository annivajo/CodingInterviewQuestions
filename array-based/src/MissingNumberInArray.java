import java.util.BitSet;

/* https://javarevisited.blogspot.com/2014/11/how-to-find-missing-number-on-integer-array-java.html */
public class MissingNumberInArray {
    public static void main(String[] args) {
       findMissingNumbers(new int[]{1,2,3,4,6,7,9},9);
    }

    private static void findMissingNumbers(int[] numbers, int count){
        int missingCount = count-numbers.length;
        BitSet bitSet = new BitSet(count); // 0,1,2,3,4,5,6,7,8

        // поставит true только для 0,1,2,3,5,6,8
        for(int number: numbers){
            bitSet.set(number-1);
        }

        int lastMissingIndex = 0;
        // вовзращает первый false встречающийся начиная с i
        for (int i=0; i<missingCount; i++){
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }
    }
}
