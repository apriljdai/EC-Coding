public class ClockAngle{
	/*
	We are given a specific time(like 02:23), 
	we need to get the angle between hour and minute(less than 180)
	*/
	public static double angle(String time){
		String[] arr = time.split(":");
		int hour = Integer.parseInt(arr[0]);
		int min = Integer.parseInt(arr[1]);
		//each hour = 30 degree
		//each min = 6 degree
		//hour moves 0.5 degrees per min
		double angle = Math.abs(hour * 30 + min * 0.5 - min * 6);
		if (angle > 180)
			return 360 - angle;
		return angle;
	}
	public static void main(String[] args){
		String time = "02:23";
		double ang = angle(time);
		System.out.println("The angle at " + time + " is " + ang);
	}
}