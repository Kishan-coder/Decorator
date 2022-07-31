import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecoratorTest {
    DataSourceI dataSource;
    @BeforeEach
    public void setUp(){
        dataSource = new JSONDataSource();
    }

    @Test
    public void BaseDecoratorTest(){
        DataSourceDecorator dataSourceDecorator = new DataSourceDecorator(dataSource);
        dataSourceDecorator.write("Kishan");
        String readData = dataSourceDecorator.read();
        Assertions.assertTrue(readData.startsWith("{") && readData.endsWith("}")
                && readData.contains("Kishan"), "something went wrong!!");
    }

    @Test
    public void EncryptionDecoratorTest(){
        DataSourceDecorator eDataSourceDecorator = new EncryptionDecorator(dataSource);
        eDataSourceDecorator.write("Kishan");
        String readData = eDataSourceDecorator.read();
        System.out.println(readData);
        Assertions.assertTrue(readData.startsWith("{") && readData.endsWith("}")
                && readData.contains("Kishan"), "something went wrong!!");
    }
    @Test
    public void CompressionDecoratorTest(){
        DataSourceDecorator cDataSourceDecorator = new CompressionDecorator(dataSource);
        cDataSourceDecorator.write("Kishan");
        String readData = cDataSourceDecorator.read();
        System.out.println(readData);
        Assertions.assertTrue(readData.startsWith("{") && readData.endsWith("}")
                && readData.contains("Kishan"), "something went wrong!!");
    }
}
