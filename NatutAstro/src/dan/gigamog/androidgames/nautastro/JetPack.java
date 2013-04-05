package dan.gigamog.androidgames.nautastro;

public class JetPack implements SpaceObjects {
	
    public float x, y;

    float move = random.nextFloat();
	int choice;
	
	
    public JetPack(){
    	
    	spawnObject();
    	
    }

	@Override
	public void spawnObject() {
		
 		x = random.nextInt(WORLD_WIDTH);
 		y = random.nextInt(WORLD_HEIGHT);
 		
		 while (x < 55|| y <55){
			 
		 		x = random.nextInt(WORLD_WIDTH);
		 		y = random.nextInt(WORLD_HEIGHT);
			 
		 }



		
	}

	@Override
	public void moveObject() {
		
		

		
		
		}
		
		
	
	
	
	

}
