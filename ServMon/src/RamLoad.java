import com.jezhumble.javasysmon.CpuTimes;
import com.jezhumble.javasysmon.JavaSysMon;
import com.jezhumble.javasysmon.MemoryStats;


public class RamLoad {
	JavaSysMon monitor =   new JavaSysMon();
	long freemem;
	long totmem;

	
	public RamLoad() {
		
		MemoryStats mem = monitor.physical();
		
		freemem = mem.getFreeBytes() / 1000;
		totmem = mem.getTotalBytes() / 1000;
		
	}


	public long getFreemem() {
		return freemem;
	}



	public long getTotmem() {
		return totmem;
	}

	
}
