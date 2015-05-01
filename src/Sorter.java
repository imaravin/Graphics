import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.Semaphore;

public class Sorter implements Runnable
{
	private ArrayComponent component;
	private Double[] values;
	protected volatile boolean run;
	protected Semaphore gate;
	private static final int VALUES_LENTH=30;
	protected static final long DELAY = 10;
	public Sorter(ArrayComponent comp)
	{
		values =new Double[VALUES_LENTH];
		for(int i=0;i<values.length;i++)
			values[i]=new Double(Math.random());
				this.component=comp;
				this.gate=new Semaphore(1);
				this.run=false;
	}
	public void setRun()
	{
		run=true;
		gate.release();
		
	}
	public void setStep()
	{
		run=false;
		gate.release();
	}
	public void run()
	{
		Comparator<Double> comp=new Comparator<Double>()
		{
			public int compare(Double i1,Double i2)
			{
				component.setValues(values,i1,i2);
				try
				{
				if(run)
					Thread.sleep(DELAY);
				else
					gate.acquire();
				}
				catch(InterruptedException e)
				{
					Thread.currentThread().interrupt();
				}
				return i1.compareTo(i2);
				
			}
		};
		Arrays.sort(values,comp);
		component.setValues(values,null,null);
	}
	
}
