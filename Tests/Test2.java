import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

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
    public static void main1(String[] args) {

        String absolutePath1 = new File("").getAbsolutePath()  + File.separator
                + "src"+ File.separator + "main"+ File.separator +"resources"+ File.separator +"picture" + File.separator;
//        Test2 cpp = new Test2();//
//        System.out.println(cpp.getAbsoluteFile());
//        File file = new File(new File("").getAbsolutePath());
        String absolutePath = new File("").getAbsolutePath();
        System.out.println(absolutePath1);

        StringBuffer stringBuffer = new StringBuffer("fdsfs");
        StringBuilder stringBuilder = new StringBuilder("fdf");
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        int v = (int) (Math.random() * 100);

        System.out.println(v);
//        URI uri = new URI("/home/ant/projects/learning/JavaRushTasks/out.log");
//        String path =  Paths.get(uri).toString();
        String[] cmdArray = new String[]{"gedit", "/home/ant/projects/learning/JavaRushTasks/out.log"};
        Process notepad  = Runtime.getRuntime().exec(cmdArray);
        notepad.waitFor();

//        String str = "jsonData.FATCA.COMPANY.OTHER.CONRTOLLINGPERSON1.ORGNAMEENGL";
//        int ind = str.lastIndexOf("1");
//        if( ind>=0 )
//            str = new StringBuilder(str).replace(ind- 10, ind+1,"0").toString();
//        System.out.println(str);



//        getPathToFile();
    }
    public static void getPathToFile() {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File file = new File(classloader.getResource("file555.txt").getFile());
        String path = file.getPath();

        String pathToTemplates = new File("").getAbsolutePath() + "/resources/file555.txt";
    }
}
