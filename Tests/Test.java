/**
 * Created by mlv on 26.04.2017.
 */
import java.io.*;
import java.awt.*;
import javax.swing.*;

public class Test
{
    public static void main(final String args[]) throws Exception
    {
        Thread.UncaughtExceptionHandler handler = new StackWindow("Show Exception Stack", 400, 200);
        Thread.setDefaultUncaughtExceptionHandler(handler);
        new Thread()  {
            StackWindow s1 = new StackWindow( "Show Exception Stack", 400, 200 );
            public void run() {
                s1.setVisible( true );
                BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
                    while (true) {
                        System.out.println( "   1  2  3" );
                        System.out.println( " a   |O|  " );
                        System.out.println( "   --|-|--" );
                        System.out.println( " b   |X|   " );
                        System.out.println( "   --|-|--" );
                        System.out.println( " c   | |  " );

                        try {
                            br.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

        }.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //System.out.print("Press Enter for next exception");
        br.readLine();
        new Thread() {
            public void run() {
                //System.out.println(args[0]);
            }
        }.start();
        System.out.print("Press Enter to end");
        br.readLine();
        System.exit(0);
    }

    public static class StackWindow extends JFrame implements Thread.UncaughtExceptionHandler
    {
        private JTextArea textArea;

        public StackWindow(String title, final int width, final int height)
        {
            super(title);
            setSize(width, height);
            textArea = new JTextArea();
            JScrollPane pane = new JScrollPane(textArea);
            textArea.setEditable(false);
            getContentPane().add(pane);
        }

        public void uncaughtException(Thread t, Throwable e)
        {
            addStackInfo(e);
        }

        public void addStackInfo(final Throwable t)
        {
            EventQueue.invokeLater(new Runnable()
            {
                public void run() {
                    // Bring window to foreground
                    setVisible(true);
                    toFront();
                    // Convert stack dump to string
                    StringWriter sw = new StringWriter();
                    PrintWriter out = new PrintWriter(sw);
                    t.printStackTrace(out);
                    // Add string to end of text area
                    textArea.append(sw.toString());
                }
            });
        }
/*                int size = 8;
                int count = 1;
                for (int i = 1; i < 6; i++) {

                            count = count + 5;
                    for (int j = count - 5; j < count; j++) {
                        if (j==1||j==5||j==7||j==9||j==13||j==17||j==19||j==21||j==25) System.out.print("* ");
                        else  System.out.print(j + " ");
                    }

                    System.out.print("\n\r");
                }*/
//        *  2  3  4  *
//        6  *  8  * 10
//        11 12  * 14 15
//        16  * 18  * 20
//        * 22 23 24  *


    }


}