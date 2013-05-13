package activity_tracker;

public class ScheduleNode {

		private Schedule schedule;
		private ScheduleNode next;
		
		public ScheduleNode()
		{
			schedule = null;
			next = null;
		}
		
		public ScheduleNode(Schedule s)
		{
			setSchedule(s);
			next = null;
		}
		
		public Schedule getSchedule()
		{
			return new Schedule(schedule);
		}
		
		public ScheduleNode getNext()
		{
			return next;
		}
		
		public void setSchedule(Schedule s)
		{
			schedule = new Schedule(s);
		}
		
		public void setNext(ScheduleNode sn)
		{
			next = sn;
		}

}
