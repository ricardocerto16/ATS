import java.lang.reflect.Field;

public class EnergyCheckUtils {
	public native static int scale(int freq);
	public native static int[] freqAvailable();

	public native static double[] GetPackagePowerSpec();
	public native static double[] GetDramPowerSpec();
	public native static void SetPackagePowerLimit(int socketId, int level, double costomPower);
	public native static void SetPackageTimeWindowLimit(int socketId, int level, double costomTimeWin);
	public native static void SetDramTimeWindowLimit(int socketId, int level, double costomTimeWin);
	public native static void SetDramPowerLimit(int socketId, int level, double costomPower);
	public native static int ProfileInit();
	public native static int GetSocketNum();
	public native static String EnergyStatCheck();
	public native static void ProfileDealloc();
	public native static void SetPowerLimit(int ENABLE);
	public static int wraparoundValue;

	public static int socketNum;
	static {
		System.setProperty("java.library.path", System.getProperty("user.dir"));
		try {
			Field fieldSysPath = ClassLoader.class.getDeclaredField("sys_paths");
			fieldSysPath.setAccessible(true);
			fieldSysPath.set(null, null);
		} catch (Exception e) { }

		System.loadLibrary("CPUScaler");
		wraparoundValue = ProfileInit();
		socketNum = GetSocketNum();
	}

	/**
	 * @return an array of current energy information.
	 * The first entry is: Dram/uncore gpu energy(depends on the cpu architecture.
	 * The second entry is: CPU energy
	 * The third entry is: Package energy
	 */

	public static double[] getEnergyStats() {
		socketNum = GetSocketNum();
		String EnergyInfo = EnergyStatCheck();
		//System.out.println(EnergyInfo);
		/*One Socket*/
		if(socketNum == 1) {
			double[] stats = new double[3];
			String[] energy = EnergyInfo.split("#");

			stats[0] = Double.parseDouble(energy[0].replaceFirst(",","."));
			stats[1] = Double.parseDouble(energy[1].replaceFirst(",","."));
			stats[2] = Double.parseDouble(energy[2].replaceFirst(",","."));

			return stats;

		} else {
		/*Multiple sockets*/
			String[] perSockEner = EnergyInfo.split("@");
			double[] stats = new double[3*socketNum];
			int count = 0;


			for(int i = 0; i < perSockEner.length; i++) {
				String[] energy = perSockEner[i].split("#");
				for(int j = 0; j < energy.length; j++) {
					count = i * 3 + j;	//accumulative count
					stats[count] = Double.parseDouble(energy[j].replaceFirst(",","."));
				}
			}
			return stats;
		}

	}

	public static void main(String args[]){
		double[] media1 = new double[3];
		double[] media2 = new double[3];
		double[] before = new double[3];
		double[] after = new double[3];
		int i;

		refactor.Testes test1 = new refactor.Testes();
		normal.Testes test2 = new normal.Testes();	
		
		for(i=0;i<10;i++){
			before = getEnergyStats();
			test2.mainTest();
			after = getEnergyStats();
			media2[0] = media2[0] + (after[0] - before[0]);
			media2[1] = media2[1] + (after[1] - before[1]);
			media2[2] = media2[2] + (after[2] - before[2]);			
		}
		System.out.println("normal: " + (media2[0]/10)+ "joules of DRAM energy");

	   	System.out.println("normal: " + (media2[1]/10)+ "joules of CPU energy");

	  	System.out.println("normal: " + (media2[2]/10)+ "joules of Package energy");
		
	  	/*
		for(i=0;i<10;i++){
			before = getEnergyStats();
			test1.mainTest();
			after = getEnergyStats();
			media1[0] = media1[0] + (after[0] - before[0]);
			media1[1] = media1[1] + (after[1] - before[1]);
			media1[2] = media1[2] + (after[2] - before[2]);			
		}
		System.out.println("refactor: " + (media1[0]/10)+ "joules of DRAM energy");

	   	System.out.println("refactor: " + (media1[1]/10)+ "joules of CPU energy");

	  	System.out.println("refactor: " + (media1[2]/10)+ "joules of Package energy");
	  	*/
		ProfileDealloc();
	}
}

/*
	public static void main(String[] args) {

		double[] before = getEnergyStats();
		try {
			Thread.sleep(10000);
		} catch(Exception e) {
		}
		double[] after = getEnergyStats();
		for(int i = 0; i < socketNum; i++) {
			System.out.println("Power consumption of dram: " + (after[0] - before[0]) / 10.0 + " power consumption of cpu: " + (after[1] - before[1]) / 10.0 + " power consumption of package: " + (after[2] - before[2]) / 10.0);
		}
		ProfileDealloc();
	}
*/


