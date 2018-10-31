package sonarpack;


import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



public class MyJob implements Job {
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		JobDataMap dataMap = arg0.getMergedJobDataMap(); 
		Subject subject = (Subject) dataMap.get("subject"); 
		subject.setState(new DataBaseService().getStudentFirstName());
		
	}
	


}
