import java.io.File;
class file
{
	public static void main(String arg[])
	{
	String x="D:\\Tamil \\";
	File f=new File(x);
	File tmp[]=null;
	if(f.isDirectory())
	tmp=f.listFiles();
	for(File xy:tmp)
	System.out.printf(xy.getAbsolutePath());
	}
}