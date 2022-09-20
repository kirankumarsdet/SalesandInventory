package org.ar.genericUtility;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class JavaUtility {
	public int getRandomNumber(int limit)
	{
		return new Random().nextInt(limit);
	}
	
	public String currentTime()
	{
		Date dat = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_sss");
		String actDate = sf.format(dat);
		return actDate;
		
	}
	/*public Object convertinStringToAnyDatatype(String data,DataTypes strategy)
	{
		Object obj=null;
		if(strategy.toString().equalsIgnoreCase("int"))
		{
			obj= Integer.parseInt(data);
		}
		else if(strategy.toString().equalIgnoreCase("long"))
		{
			obj=Long.parseLong(data);
		}
		else
		{
			obj=Double.parseDouble(data);
		}
		return obj;
	}*/
}



