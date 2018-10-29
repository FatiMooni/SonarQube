

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.mysql.fabric.xmlrpc.base.Data;

public class MyJob implements Job {
	private Subject subject;
	private Observer observer;
	
	

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		JobDataMap dataMap = arg0.getMergedJobDataMap(); 
		Subject subject = (Subject) dataMap.get("subject"); 
		subject.setState(new DataBaseService().getStudentFirstName());
		
	}
	


}
