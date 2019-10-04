public class Screen {
    private Window[] windows = new Window[3];
    private MyShipWindow myShipWindow;
    private EnemyShipWindow enemyShipWindow;
    private DialogWindow dialogWindow;
    private int[] posX = new int[this.windows.length];
    private int[] posY = new int[this.windows.length];
    private int totalHeight;
    private int totalWidth;
    private char[][] screenArray;


    public Screen() {
        for(int i=0; i<this.windows.length; ++i) {
            posX[i] = -1;
            posY[i] = -1;
        }
    }

    public Window addWindow(int x, int y, int width, int height) {
        Window newWindow = new Window(width, height);
        boolean addedXY = false;
        for(int i=0; i<this.windows.length; ++i) {
            if (this.posY[i] == -1 && addedXY == false) {
                this.posY[i] = y;
                this.posX[i] = x;
                this.windows[i] = newWindow;
                addedXY = true;
            }
        }
        return newWindow;
    }

    public void setWidthAndHeight() {
        this.totalHeight = this.windows[1].getHeight() + this.windows[2].getHeight() + 3;
        this.totalWidth  = this.windows[2].getWidth() + 2;
        this.screenArray = new char[this.totalHeight][this.totalWidth];
    }

    public void makeBoarders() {
        for(int y=0; y<this.totalHeight; ++y) {
            for(int x=0; x<this.totalWidth; ++x) {
                if(y == 0) {
                    this.screenArray[y][x] = '-';
                }
                else if(y == this.totalHeight - 1) {
                    this.screenArray[y][x] = '-';
                }
                else if(y == this.totalHeight / 2) {
                    this.screenArray[y][x] = '-';
                }
                else if(x == 0) {
                    this.screenArray[y][x] = '-';
                }
                else if(x == this.totalWidth - 1) {
                    this.screenArray[y][x] = '-';
                }
                else if(x == this.totalWidth / 2 && y < this.totalHeight/2) {
                    this.screenArray[y][x] = '-';
                }
                else {
                    this.screenArray[y][x] = 'x';
                }
            }
        }
    }

    public void setWindowsType() {
        this.windows[0] = new MyShipWindow(this.windows[0].getWidth(),this.windows[0].getHeight());
        this.windows[1] = new EnemyShipWindow(this.windows[1].getWidth(), this.windows[1].getHeight());
        this.windows[2] = new DialogWindow(this.windows[2].getWidth(), this.windows[2].getHeight());

        myShipWindow = new MyShipWindow(this.windows[0].getWidth(),this.windows[0].getHeight());
        enemyShipWindow = new EnemyShipWindow(this.windows[1].getWidth(), this.windows[1].getHeight());
        dialogWindow = new DialogWindow(this.windows[2].getWidth(), this.windows[2].getHeight());
    }

    public void draw() {
        myShipWindow.drawMyShipWindow(posX[0], posY[0], screenArray);
        enemyShipWindow.drawEnemyShipWindow(posX[1],posY[1], screenArray);
        dialogWindow.drawDialogWindow(posX[2], posY[2], screenArray);
    }

    public void getXAndY() {
        for(int i=0; i<this.windows.length; ++i) {
            System.out.println(i + ": X: " + this.posX[i] + " Y: " + this.posY[i]);
        }
    }

    public void getWidthAndHeight() {
        for(int i=0; i<this.windows.length; ++i) {
            System.out.println(i + " Height: " + windows[i].getHeight() + " Width: " + windows[i].getWidth());
        }
    }

    public void displayScreen() {
        for(int y=0; y<this.totalHeight; ++y) {
            for(int x=0; x<this.totalWidth; ++x) {
                System.out.print(screenArray[y][x]);
            }
            System.out.println();
        }
    }
}

class Window {
    private int width;
    private int height;

    public Window(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

}

class MyShipWindow extends Window {
    private PlayersShip playersShip = new PlayersShip();

    public MyShipWindow(int width, int height) {
        super(width, height);
    }

    public void drawMyShipWindow(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX + x] = playersShip.playerShip[y][x];
            }
        }
    }
}

class EnemyShipWindow extends Window {
    private EnemyShips enemyShips = new EnemyShips();

    public EnemyShipWindow(int width, int height) {
        super(width, height);
    }

    public void drawEnemyShipWindow(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX + x] = enemyShips.enemyShip[y][x];
            }
        }
    }
}

class DialogWindow extends Window {
    DialogWindowPrompt prompt = new DialogWindowPrompt(129, 4);
    DialogWindowOption1 option1 = new DialogWindowOption1(129, 2);
    DialogWindowOption2 option2 = new DialogWindowOption2(129, 2);
    DialogWindowOption3 option3 = new DialogWindowOption3(129, 2);
    DialogWindowUserInput userInput = new DialogWindowUserInput(129, 2);

    public DialogWindow(int width, int height) {
        super(width, height);
    }

    public void drawDialogWindow(int startX, int startY, char[][] mapArray) {
        this.prompt.drawDialogWindowPrompt(startX, startY, mapArray);
        this.option1.drawDialogWindowOption1(startX, startY + 4, mapArray);
        this.option2.drawDialogWindowOption2(startX, startY + 6, mapArray);
        this.option3.drawDialogWindowOption3(startX, startY + 8, mapArray);
        this.userInput.drawDialogWindowUserInput(startX, startY + 10, mapArray);
    }
}

class DialogWindowPrompt extends Window {
    public DialogWindowPrompt(int width, int height) {
        super(width, height);
    }

    public void drawDialogWindowPrompt(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX +x] = 'P';
            }
        }
    }
}

class DialogWindowOption1 extends Window {
    public DialogWindowOption1(int width, int height) {
        super(width, height);
    }

    public void drawDialogWindowOption1(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX +x] = '1';
            }
        }
    }

}

class DialogWindowOption2 extends Window {
    public DialogWindowOption2(int width, int height) {
        super(width, height);
    }

    public void drawDialogWindowOption2(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX +x] = '2';
            }
        }
    }
}

class DialogWindowOption3 extends Window {
    public DialogWindowOption3(int width, int height) {
        super(width, height);
    }

    public void drawDialogWindowOption3(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX +x] = '3';
            }
        }
    }
}

class DialogWindowUserInput extends Window {
    public DialogWindowUserInput(int width, int height) {
        super(width, height);
    }

    public void drawDialogWindowUserInput(int startX, int startY, char[][] mapArray) {
        for(int y=0; y<this.getHeight(); ++y) {
            for(int x=0; x<this.getWidth(); ++x) {
                mapArray[startY + y][startX +x] = 'I';
            }
        }
    }

}
