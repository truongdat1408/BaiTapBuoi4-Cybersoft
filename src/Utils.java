public class Utils {
    public static void pressEnterToContinue()
    {
        System.out.println();
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
