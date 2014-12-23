public class Calendar{
	/*
	1/1/2000 is Sunday, each month has 30 days, each year has 12 month.
	Get a date (mon/day/year) from user. 
	Print exact the week of dates (Sun to Sat). ex) input: 2/20/2001 if the day is Wednesday 
	*/
	public static void week(String date){
		String[] weekofDate = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		String[] dateArr = date.split("/");
		int year = Integer.parseInt(dateArr[2]);
		int month = Integer.parseInt(dateArr[0]);
		int day = Integer.parseInt(dateArr[1]);
		int weekdate = 0;
		int totalDay = 0;
		if (year > 2000){
			totalDay = (year - 2000) * 12 * 30 + (month - 1) * 30 + (day - 1);
			weekdate = totalDay % 7;
			//System.out.println("week date is " + weekdate);
		}
		else{
			totalDay = (2000 - year) * 12 * 30 - (month - 1) * 30 - (day - 1);
			weekdate = 7 - totalDay % 7;
		}
		//cross the year or cross the month
		if (day - weekdate <= 0){
			if (month - 1 == 0){
				month = 12;
				year--;
			}
			else{
				month--;
			}
			day = 30 + day - weekdate;
		}
		else
			day = day - weekdate;
		int count = 0;
		while (count < 7){
			if (day > 30){
				day -= 30;
				month++;
				if (month > 12){
					month = 1;
					year++;
				}
			}
			System.out.println(month + "/" + day + "/" + year + " is " + weekofDate[count]);
			count++;
			day++;
		}
	}
	public static void main(String[] args){
		String date = "11/7/2014";
		week(date);
	}
}