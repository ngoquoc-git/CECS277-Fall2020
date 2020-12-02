import java.util.Stack;


public class Main {
    public static void main(String[] args){
        Stack <Memento> history = new Stack <Memento>();
        Board b = new Board();
        int gameplay;
		System.out.print("1. Player1 vs Player2.\n2. Player vs Computer.\nChoose an option: ");
        gameplay = CheckInput.getIntRange(1, 2);
        switch(gameplay){
            case 1: playerVplayer(b, history); break;
            case 2: playerVcomp(b, history); break;
        }

    }

    public static void playerVplayer(Board b, Stack<Memento> history) {
        int input, turns = 1;
        b.display();
		System.out.println("1. place token");
		System.out.println("2. revert");
		System.out.println("3. quit");
		input = CheckInput.getIntRange(1,3);
		do {
			if(input == 1) {
				char token;
				int inputR;
				int inputC;
				
				if(turns%2 == 0) {
					token = 'o';
				}else token = 'x';
				
				System.out.println("Place an "+token);
				System.out.print("Row: ");
				inputR = CheckInput.getIntRange(0,2);
				System.out.print("Col: ");
				inputC = CheckInput.getIntRange(0,2);

				if(b.placeToken(token, inputR, inputC)) {
                    turns++;
                    if(token == 'o') history.push(b.save());
                }
                else System.out.println("invalid location");
				
			}
			
			else if(input == 2) {
				if(!history.empty()) {
					b.restore(history.pop());
                }
                else System.out.println("nothing to revert");
            if(turns % 2 == 0) turns--;
			}
			
            else {
                System.out.println("Game Over");
                break;
            }
			
			b.display();
			System.out.println("1. place token");
			System.out.println("2. revert");
			System.out.println("3. quit");
            input = CheckInput.getIntRange(1,3);
            if(input == 3) System.out.println("Game Over");
        } while(b.winner() == ' ' && input != 3);
        
        if(b.winner() == 'x') System.out.println("Player 1 wins.");
        else if(b.winner() == 'o') System.out.println("Player 2 wins.");
        else System.out.println("The board is fully filled and there is no winner.");
    }

    public static void playerVcomp(Board b, Stack<Memento> history){
        int inputs = 0;
        int turns = 1;
        do{    
            if(turns%2 != 0){
                
                b.display();
                System.out.println("1. place token");
                System.out.println("2. revert");
                System.out.println("3. quit");
                inputs = CheckInput.getIntRange(1,3);
              
                    //Place a token
                    if(inputs == 1) {
                        int inputR;
                        int inputC;
                
                        System.out.println("Place an x");
                        System.out.print("Row: ");
                        inputR = CheckInput.getIntRange(0,2);
                        System.out.print("Col: ");
                        inputC = CheckInput.getIntRange(0,2);
                        
                        if(b.placeToken('x', inputR, inputC)) {
                            turns++;
                        }
                        else System.out.println("invalid location");
                        
                    }
                    //Revert
                    else if(inputs == 2) {
                        if(!history.empty()) {
                            b.restore(history.pop());
                        }
                        else System.out.println("nothing to revert");
                    if(turns % 2 == 0) turns--;
                    }
                    //Quit
                    else {
                        System.out.println("Game Over");
                        break;
                    }
                
            }
            else {
                botEasy(b);
                //b.display();
                history.push(b.save());
                turns++;
            }
        } while(b.winner() == ' ' && inputs != 3);

        if(b.winner() == 'x') System.out.println("Player wins.");
        else if(b.winner() == 'o') System.out.println("Computer wins.");
        else System.out.println("The board is fully filled and there is no winner.");
    }

    public static void botEasy(Board b) {
        if(!b.placeToken('o', 1, 1)){
            if(!b.placeToken('o', 2, 0)){
                if(!b.placeToken('o', 2, 2)){
                    if(!b.placeToken('o', 2, 1)){
                        if(!b.placeToken('o', 0, 2)){
                            if(!b.placeToken('o', 1, 2)){
                                if(!b.placeToken('o', 0, 0)){
                                    if(!b.placeToken('o', 1, 0)){
                                        if(!b.placeToken('o', 0, 1)){
                                            System.out.println("No more moves.");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}
