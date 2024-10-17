public class PairBox<T, U>{
    private T item1;
    private U item2;

    public PairBox(T i1, U i2){
        item1 = i1;
        item2 = i2;
    }

    //-------------------//
    // Getters & Setters //
    //-------------------//
    public T getT() {return this.item1;}    // Get the value of T.
    public U getU() {return this.item2;}    // Get the value of U.
    public void setT(T t1) {item1 = t1;}    // Set the value of T.
    public void setU(U t2) {item2 = t2;}    // Set the value of U.

    // These getters return the names of each generic type as a String.
    public static <T, U> String getGenericTypeT(PairBox<T, U> pairBox) {return pairBox.getT().getClass().getName().replaceFirst("java.lang.", "");}
    public static <T, U> String getGenericTypeU(PairBox<T, U> pairBox) {return pairBox.getU().getClass().getName().replaceFirst("java.lang.", "");}

    //-------------------//
    // Utility Functions //
    //-------------------//
    // Prints the passed in PairBox's values and their types.
    public static <T, U> void printPairBox(PairBox<T, U> pairBox){
        System.out.printf("[%s: %s, %s: %s]\n", getGenericTypeT(pairBox), pairBox.getT(), getGenericTypeU(pairBox), pairBox.getU());
    }

    //------//
    // Main //
    //------//
    public static void main(String[] args){
        Integer num1 = 8;
        Integer num2 = 19;
        Integer num3 = 100;
        String string = "dog";

        PairBox<Integer, Integer> pair1 = new PairBox<>(num1, num2);  // A new PairBox containing two Integers.
        PairBox<Integer, String> pair2 = new PairBox<>(num3, string); // A new PairBox containing an Integer and a String.

        Transformer<Integer> numInverter = new IntegerTransformer();  // A transformer for changing an integer's sign.

        pair1.setT(numInverter.transform(pair1.getT()));    // Change the sign of the first integer in pair1.
        pair1.setU(numInverter.transform(pair1.getU()));    // Change the sign of the second integer in pair1.

        printPairBox(pair1);            // Print out this PairBox.
        pair1 = BoxSwapper.swap(pair1); // Swap this PairBox's values.
        printPairBox(pair1);            // Print out this PairBox again.

        printPairBox(pair2);            // Print out this PairBox.
    }
}