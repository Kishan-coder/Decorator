import java.util.Random;

//step 2: Implement Decorators
//step 3: Used for [[[AddOns]]]] the Pizza Example and this datasource example
public class EncryptionDecorator extends DataSourceDecorator{

    public EncryptionDecorator(DataSourceI dataSourceI) {
        super(dataSourceI);
    }

    @Override
    public String read() {
        return decryption(super.read());
    }

    private String decryption(String encryptedString){
        System.out.println("Starting the decryption procedure ((beep))...");
        String decryptedOne = encryptedString.substring(0, encryptedString.lastIndexOf(":")+2)+
                encryptedString.substring(encryptedString.lastIndexOf(":")+6);
        return decryptedOne;
    }

    @Override
    public void write(String data) {
        String encryptedString = encryption(data);
        super.write(encryptedString);
    }

    private String encryption(String toEncrypt){
        System.out.println("Starting Encryption <<blup>>//");
        return (new Random().nextInt(10)*1002)+toEncrypt;
    }

}
