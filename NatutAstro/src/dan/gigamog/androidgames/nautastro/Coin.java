package dan.gigamog.androidgames.nautastro;



public class Coin implements SpaceObjects {
	
    public int x, y;
    public int type;
    Coin coins;
    int count;
    
    public Coin() {
        spawnObject();
        
    }
    
    
 
 	public void spawnObject() {
 		

 		for (int x = 0; x < WORLD_WIDTH; x++) {
 			for (int y = 0; y < WORLD_HEIGHT; y++) {
 				fields[x][y] = false;
 			}
 		}
 		fields[x][y] = true;

 		x = random.nextInt(WORLD_WIDTH);
 		y = random.nextInt(WORLD_HEIGHT);
 		
		 while (x < 55|| y <55){
			 
		 		x = random.nextInt(WORLD_WIDTH);
		 		y = random.nextInt(WORLD_HEIGHT);
			 
		 }

 		while (true) {
 			if (fields[x][y] == false)
 				break;
 			if (x >= WORLD_WIDTH) {
 				x = 0;

 				if (y >= WORLD_HEIGHT) {
 					y = 0;
 				}
 			}
 		}
 		
 		
 		 

 		
 	}



	@Override
	public void moveObject() {
		// TODO Auto-generated method stub
		
	}



}

