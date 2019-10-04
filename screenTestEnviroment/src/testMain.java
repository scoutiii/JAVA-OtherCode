public class testMain {
    public static void main(String[] args) {

        /**
        To make an new screen, you have to follow this order of things.
        creates the new instance of the screen
        add the 3 screens
        call setwidthandheight
        call makeboarders
        then you can print the map (so far)
        Screen test = new Screen();
        test.addWindow(1,1,12, 12);
        test.addWindow(14,1,12,12);
        test.addWindow(1,14,25,12);
        test.setWidthAndHeight();
        test.makeBoarders();
        test.printArray();
         */


        Screen test = new Screen();
        test.addWindow(1,1,12, 12);
        test.addWindow(14,1,12,12);
        test.addWindow(1,14,25,12);
        test.setWidthAndHeight();
        test.makeBoarders();





    }
}