
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


public class Writer {

	public Writer(String path, Integer Avg1min, Integer Avg5min, Integer Avg15min, long uptime, long freemem, long totmem) {
		
		BufferedWriter writer = null;
		try {
            
            File file = new File(path);

            // This will output the full path where the file will be written to...
            System.out.println(file.getCanonicalPath());

            writer = new BufferedWriter(new FileWriter(file));
                                   
            
            writer.write("<?php");
            writer.newLine();
            writer.write("define(\"MONYT_SCRIPT_VERSION\", \"1.0.1\");");
            writer.newLine();
            writer.write("if( isset($_GET['version'] ) )");
            writer.newLine();
            writer.write("{");
            writer.newLine();
            writer.write("die( MONYT_SCRIPT_VERSION );");
            writer.newLine();
            writer.write("} else if( isset($_GET['check']) )");
            writer.newLine();
            writer.write("{");
            writer.newLine();
            writer.write("$aCheck = array");
            writer.newLine();
            writer.write("( 'monyt' => MONYT_SCRIPT_VERSION," +
            				"'distro' => 'not available yet'," +
            				"'kernel' => 'not available yet'," +
            				"'cpu' => 'not available yet'," +
            				"'cores' => 1 );");
            writer.newLine();
            writer.write("$sDistroName = '';");
            writer.newLine();
            writer.write("$sDistroVer  = '';");
            writer.newLine();
            writer.write("die( json_encode($aCheck) );");
            writer.newLine();
            writer.write("}");
            writer.newLine();
            writer.write("die (\"{\\\"monyt\\\":\\\"1.0.1\\\",\\\"uptime\\\":\\\"" + uptime + " 00.00\\\",\\\"load\\\":\\\"" + Avg1min + ","+ Avg5min + "," + Avg15min + "\\\",\\\"total_memory\\\":\\\"" + totmem + "\\\",\\\"free_memory\\\":\\\"" + freemem + "\\\",\\\"hd\\\":[],\\\"net_tx\\\":0,\\\"net_rx\\\":0}\");");
            writer.newLine();
            writer.write("?>");
		
		
		} catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                writer.close();
            } catch (Exception e) {
            }
        }
		
		
	}
}