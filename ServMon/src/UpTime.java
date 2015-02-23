import com.jezhumble.javasysmon.JavaSysMon;


public class UpTime {

	public long getUpTime() {
		
		JavaSysMon monitor =   new JavaSysMon();
		
		long uptime = monitor.uptimeInSeconds();
		return uptime;
		
	}
}
