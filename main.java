import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.LegacyPilot;

//0 es rojo
	//7 es negro
	//6 es blanco




public class main {
	
	public static void main (String[] args) throws InterruptedException {
		
		
	    ColorSensor cs = new ColorSensor(SensorPort.S3);
	    ColorSensor piso = new ColorSensor(SensorPort.S1);
       
	    /***********************************************/
	    int colorCompetencia = 6;
	    int macacos = 0;
	    /***********************************************/
                     
       UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
        
        int distancia = sonar.getDistance();
        int distancia2; 
        distancia = sonar.getDistance();
		 LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
		navigator.reset();	 
		
		
		
    	
  
    	
    	boolean soltarMacaco=false; // no lo tiene agarrado
	
		
    	
	soltarMacaco=true;
	
	
	navigator.travel(60);
	Motor.C.rotate(-40);
	
		
		while (true)	{
        	
			int colorEncontrado = cs.getColorID();
			int colorPiso = piso.getColorID();
			int dejo=0;
        	acciones ac = new acciones();  
        	
        	//ACA VAMOS A BUSCAR EL MACACO CORRECTO
        	while( cs.getColorID() != colorCompetencia){
        	
		        	if(piso.getColorID()!=7){	
		        		
		        	if(sonar.getDistance()>15){
		        		while(sonar.getDistance()>15){
		        			ac.buscarMacaco();
		        			if(sonar.getDistance()>15){
		        				navigator.travel(10);
		        				navigator.stop();}
		        		}
		        		
		            	
		        	}
		        	
		        	
		        	if(sonar.getDistance()<15){
		        		ac.buscarMacacoEntreMedidas();
		        		System.out.println("Estoy frente a una pared o macaco");
		        		navigator.rotate(20);
		        	//navigator.rotate(7);
		        		navigator.stop();
		        		sonar.getDistance();//NUEVO
		        		if(!ac.tocarBotoneraDelantera() && sonar.getDistance()>10){
		        			navigator.rotate(-35);
		        			navigator.travel(15);
		        			
		        			Motor.C.rotate(60);
		            		Motor.A.stop();
		            		Motor.B.stop();
		            		
		            		ac.agarrarColorCompetencia();
		            		
		        		}
		        		else {
		        			
		        				System.out.println("Estoy frente a una pared IF");
			        			navigator.travel(-15);
			        			navigator.rotate(150);
			        			navigator.travel(80);	      			
		        			
		        			
		        			
		        		}
		        			
		        		
		        	}
		        	
		        	if(ac.tocarBotoneraLateral()){
		        		
		        		System.out.println("Estoy de costado a una pared y giro");
		        		navigator.travel(-15);
		    			navigator.stop();
		    			navigator.rotate(-150);
		    			navigator.travel(40);
		        		
		        	}
		        
		        	}
		        	/*else {
		        		navigator.travel(-35);		
		        	}*/

		        	//nuevo por si es una esquina
	    			
	    			//
		        	
		        	
        	}// FIN DE BUSCAR EL MACACO CORRECTO
        	
        	
        	//AGARRE EL MACACO CORRECTO Y VOY A DEJARLO EN LA BASE
        	dejo=0;
        		
        	while((dejo==0)&&(cs.getColorID()==colorCompetencia)){
        	
     
        	
    			while((!ac.tocarBotoneraDelantera())&&(piso.getColorID()==6) && (sonar.getDistance()>15)){
    			
    			Motor.A.setSpeed(380);
    			Motor.B.setSpeed(380);
    			Motor.A.forward();
    			Motor.B.forward();
    			colorPiso = piso.getColorID();
    			
    			}
        
    			Motor.B.stop();
    			Motor.A.stop();
        	   
    			if (ac.tocarBotoneraDelantera() || sonar.getDistance()<15){
    				navigator.travel(-20);
    				navigator.rotate(135);
    			}
    			else{
    				navigator.travel(15);
    				piso.getColorID();
    				
    				if(piso.getColorID()== 2){
    					Motor.C.rotate(-40);
    					navigator.travel(-50);
    					navigator.rotate(100);
    					dejo=1;
    					
    					
    				}
    				else{
    					navigator.travel(-50);
    					navigator.rotate(160);
    				}
    			}
    			
    			if(ac.tocarBotoneraLateral()){
	        		
	        		navigator.travel(-15);
	    			navigator.stop();
	    			navigator.rotate(-150);
	    			navigator.travel(40);
	        		
	        	}
    			
    			//nuevo por si es una esquina

    			if (ac.tocarBotoneraDelantera() && ac.tocarBotoneraLateral()){
    				navigator.travel(-20);
    				navigator.rotate(120);
    			}//
    			
        	}
        		
    			
    			
    			
    		
        	
        	//voy a acomodarme a prepo bien parelo a la pared
        	//navigator.rotate(-10);
    		//navigator.travel(4);
    		//navigator.rotate(20);
        	//Motor.A.stop();
        	//Motor.B.stop();
        	//navigator.rotate(60);

        /*	distancia = sonar.getDistance();
        	
        	while((distancia>40) && (!ac.tocarBotoneraDelantera())){
        	
	        	if(distancia>40){
	        		Motor.A.backward();
	        		Motor.A.setSpeed(100);
	        		Motor.B.backward();
	        		Motor.B.setSpeed(100);
	        		//navigator.rotate(15);
        	
		        	/*while((distancia<40) && (!ac.tocarBotoneraDelantera())){
	           	    
	        		Motor.A.forward();
	        		Motor.A.setSpeed(100);
	        		Motor.B.forward();
	        		Motor.B.setSpeed(108);
		        	}	*/
	        	}	
        /*	Motor.A.stop();
        	Motor.B.stop();
        	
        	if(distancia>40){
        		while(ac.tocarBotoneraLateral()){
            		
                	
                  	 
            		Motor.A.forward();
            		Motor.A.setSpeed(100);
            		Motor.B.forward();
            		Motor.B.setSpeed(102);
            		
            	}
        		navigator.rotate(80);
        		navigator.travel(10);
        	}
        	
        	
        	//va hacia adelante hasta tocar el boton de adelante o deja de tocar el lateral
        	//while(!ac.tocarBotoneraDelantera() || (ac.tocarBotoneraLateral())){
        		
        		//Motor.A.forward();
        		//Motor.A.setSpeed(105);
        		//Motor.B.forward();
        		//Motor.B.setSpeed(90);
        	//}
        	//navigator.rotate(90);
        	    	
        	//ac.encontrarPuerta();
        	//ac.detectarDistanciaPared();
        	
        	//soltarMacaco=false;
        	
        	//ac.buscarDistanciaPuertaRapida();
        	
      	
        	//Motor.C.rotateTo(-30);
        	//ac.buscarMacaco();
        	
        	//ac.avanzar();
        	//agregado 3/9	
        	//ac.encontrarPuerta();
        	
        
/*
        	colorEncontrado = cs.getColorID();
			System.out.println(colorEncontrado);
        	
			
			
				if (colorEncontrado==colorCompetencia){
					
					Motor.C.rotateTo(50);
					Motor.C.stop();
					Motor.A.stop();
					Motor.B.stop();
					Motor.A.rotate(180);
					
				}
				
				else {
					
					
					
					ac.buscarMacaco();
		        	
		        				
				}
			
				
			
			ac.salvarMacaco();
			
			ac.abrirPinza();
			
			//System.out.println("estoy retrocediendo");
			//ac.retrocede(2000);
			//ac.parar(5);
      */  	
        }//while (true)
		
}
