
public class fpscounter {
    public static void main(String[] args) {
        long frameCounter = 0;
        long elapsedMilliseconds = 0;
        //long elapsedTime = 0;


        while(true) {
            long diffInTime = 0;
            while(diffInTime <= 500) {
                long startTime = System.currentTimeMillis();
                long finishTime = System.currentTimeMillis();
                diffInTime += finishTime - startTime;
                frameCounter += 1;
            }
            long totalMilliSeconds = System.currentTimeMillis();
            long totalSeconds = totalMilliSeconds / 1000;
            long totalMinutes = totalSeconds / 60;
            long totalHours = totalMinutes / 60;
            long currentHour = totalHours % 24;
            long currentMinute = totalMinutes % 60;
            long currentSecond = totalSeconds % 60;
            System.out.println("The time: " + currentHour + " " + currentMinute + " " + currentSecond);
            float fps = frameCounter / 60;
            System.out.println("fps: " + fps);
            frameCounter = 0;

        }


    }
}