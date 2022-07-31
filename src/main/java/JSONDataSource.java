public class JSONDataSource implements DataSourceI{
    String userName;
    @Override
    public String read() {
        return "{\"user\":{\"name\":\""+userName+"\"}}";
    }

    @Override
    public void write(String nameVal) {
        userName = nameVal;
        System.out.println("Writing user-data in json file to store name = " + userName);
    }
}
