public class BoxSwapper <T> {
    // Swaps the values in a PairBox (only applicable if both values are of the same type).
    public static <T> PairBox<T, T> swap(PairBox<T, T> pair){
        PairBox<T,T> newPairBox = new PairBox<>(pair.getU(), pair.getT());
        return newPairBox;
    }
}
 