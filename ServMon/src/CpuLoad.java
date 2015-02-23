import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;


public class CpuLoad {
	JavaSysMon monitor =   new JavaSysMon();
	Integer seccounter;
	String path;
	CpuTimes Cpu1sec;
	CpuTimes Cpu1min;
	CpuTimes Cpu5min;
	CpuTimes Cpu10min;
	
	float Avg1min;
	float Avg5min;
	float Avg10min;
	
	public CpuLoad(String path) {
		this.path = path;
		seccounter = 0;
		Avg1min = -1;
		Avg5min = -1;
		Avg10min = -1;
	}
	
	public float CalcAvg1sec() {

	    CpuTimes Avg1sec = monitor.cpuTimes();
	    
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    if(seccounter == 0) {
	    	Cpu1min = monitor.cpuTimes();
	    	Cpu5min = monitor.cpuTimes();
	    	Cpu10min = monitor.cpuTimes();
	    	seccounter++;
		    return (monitor.cpuTimes().getCpuUsage(Avg1sec) * 100);
	    }
	    
	    if((seccounter % 60) == 0) {
	    	Avg1min = monitor.cpuTimes().getCpuUsage(Cpu1min) * 100;
	    	Cpu1min = monitor.cpuTimes();
	    	
	    	// calculate Uptime
	    	UpTime ut = new UpTime();
	    	
	    	// calculate Ramload
	    	RamLoad rm = new RamLoad();
	    	
	    	// Write new data to file
			Writer mywriter = new Writer(path, (int)Avg1min, (int)Avg5min, (int)Avg10min, ut.getUpTime(), rm.getFreemem(), rm.getTotmem());
	    }
	    
	    if((seccounter % (60 * 5)) == 0) {
	    	Avg5min = monitor.cpuTimes().getCpuUsage(Cpu5min) * 100;
	    	Cpu5min = monitor.cpuTimes();
	    }
	    
	    if(seccounter == 60 * 10) {
	    	Avg10min = monitor.cpuTimes().getCpuUsage(Cpu10min) * 100;
	    	Cpu10min = monitor.cpuTimes();
	    	seccounter = 0;
	    	return (monitor.cpuTimes().getCpuUsage(Avg1sec) * 100);
	    }
	    
	    seccounter++;
	    return (monitor.cpuTimes().getCpuUsage(Avg1sec) * 100);

	}
	
	
	public float getAvg1min() {
		return Avg1min;
	}
	
	public float getAvg5min() {
		return Avg5min;
	}
	
	public float getAvg10min() {
		return Avg10min;
	}
	
	
	
}
