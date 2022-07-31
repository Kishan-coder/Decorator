public class CompressionDecorator extends DataSourceDecorator{
    public CompressionDecorator(DataSourceI dataSourceI) {
        super(dataSourceI);
    }

    @Override
    public String read() {
        return decompress(super.read());
    }
    private String decompress(String data){
        System.out.println("De-compressing Data <<bowing>>..");
        return data;
    }

    @Override
    public void write(String data) {
        String compressedString = compress(data);
        super.write(compressedString);
    }
    private String compress(String data){
        System.out.println("Compressing Data [[bing]]..");
        return data;
    }
}
