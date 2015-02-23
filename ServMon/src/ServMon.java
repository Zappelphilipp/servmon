import java.util.Scanner;
public class ServMon {

	public static void main(String[] args) {
		
		String path;
		
		System.out.println("--- Welcome to ServMon ---");
		System.out.println("To start, please enter absolute path to Monyt-file:");
		Scanner input = new Scanner(System.in);
		path = input.next();
		input.close();
		
		CpuLoad cl = new CpuLoad(path);
		
		while(1 == 1) {
			
			ClearConsole(); // Does not work on every Window-Machine
			
			System.out.println("Average 1sec:  " + (int)cl.CalcAvg1sec() + " %");
			System.out.println("Average 1min:  " + (int)cl.getAvg1min() + " %");
			System.out.println("Average 5min:  " + (int)cl.getAvg5min() + " %");
			System.out.println("Average 10min: " + (int)cl.getAvg10min() + " %");
			System.out.println("-------------------- " + cl.seccounter + " ---");

		}
		
	}
	
	public static void ClearConsole() {
		
		try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	

}


