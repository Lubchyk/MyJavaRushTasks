import java.io.File;

public final class Test2 extends java.io.File
{
    private static String pathname = ".";//
    Test2()
    {
        super(pathname);//
    }
    String getResult()
    {
        return pathname;//
    }
    public static void main(String[] args) {

        String absolutePath1 = new File("").getAbsolutePath() + "/src/main/resources/picture/";
//        Test2 cpp = new Test2();//
//        System.out.println(cpp.getAbsoluteFile());
//        File file = new File(new File("").getAbsolutePath());
        String absolutePath = new File("").getAbsolutePath();
        System.out.println(absolutePath);

    }

}
