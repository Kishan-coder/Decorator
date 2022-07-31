public class DataSourceDecorator implements  DataSourceI{
    DataSourceI dataSource;
    public DataSourceDecorator(DataSourceI dataSourceI){
        dataSource = dataSourceI;
    }

    @Override
    public String read() {
        return dataSource.read();
    }

    @Override
    public void write(String data) {
        dataSource.write(data);
    }
}
