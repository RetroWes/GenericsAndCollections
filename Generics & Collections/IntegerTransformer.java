public class IntegerTransformer implements Transformer<Integer> {
    @Override
    public Integer transform(Integer num){
        return -num;
    }
}
