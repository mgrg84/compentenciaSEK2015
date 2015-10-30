import lejos.nxt.ColorSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.LegacyPilot;


public class acciones {
	
	//0 es rojo
	//7 es negro
	//6 es blanco
	int colorCompetencia=6;
	

// MÉTODOS DE LA CLASE	
public void agarrarColorCompetencia(){
	
	  ColorSensor cs = new ColorSensor(SensorPort.S3);
	  UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	  int colorEncontrado = cs.getColorID();
	  
	  LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
	  navigator.reset();
	  
	 
	  //Motor.C.stop();
	  
	  
			
			colorEncontrado = cs.getColorID();
			
				if (colorEncontrado == this.colorCompetencia  ) {
					
				
						//Motor.C.rotateTo(60);
						//Motor.C.stop();
						//navigator.travel(10);
					System.out.println("Color encontrado bien: "+ colorEncontrado);
						
						Motor.A.stop();
						Motor.B.stop();
						
						Motor.A.rotate(180);
						
											
				}
				
				else {
					
										
						System.out.println("Color encontrado MAL: "+ colorEncontrado);
					/*	Motor.B.stop();
						Motor.A.stop();
					
						int distancia = sonar.getDistance();
						if ((distancia > 200) || (distancia < 23)){
							Motor.A.forward();
							Motor.B.forward();*/
					Motor.C.rotateTo(-50);
					navigator.travel(-20);
					navigator.rotate(150);
					navigator.travel(30);
					navigator.stop();
			
					
						}
							
				
							
				}
					
						

	 // Motor.A.forward();
	 // Motor.A.setSpeed(90);
	 // Motor.B.forward();
	//  Motor.B.setSpeed(90);
					
				
		
		
						
		

public void buscarMacaco(){
	
	LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
		navigator.reset();	
		
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	int distancia = sonar.getDistance();
    distancia = sonar.getDistance();
    if (distancia > 10){
		
		int seg = 1000;
		long tiempoTranscurrido4 = 0;

		while ((distancia > 50) && (tiempoTranscurrido4 < 50000)) {
			
			
			long tiempoTranscurrido = 0, tiempoTranscurrido2 = 0;
			long primerTiempo=0, segundoTiempo=0, primerTiempo2=0, segundoTiempo2=0;
			primerTiempo =  System.currentTimeMillis();
			//para buscar la puerta
			while (distancia > 50  && seg > tiempoTranscurrido ){
				
				
				//System.out.println("distancia > 7  && seg > tiempoTranscurrido");
				
				Motor.A.forward();
				Motor.A.setSpeed(135);
				Motor.B.backward();
				Motor.B.setSpeed(135);
				segundoTiempo =  System.currentTimeMillis();
				
				 
				tiempoTranscurrido = segundoTiempo - primerTiempo;
				
				
				distancia = sonar.getDistance();
				
			}
			tiempoTranscurrido = tiempoTranscurrido * 0;
			
			seg = seg * 2;
			primerTiempo2 =  System.currentTimeMillis();
			
			while (distancia > 50  && seg > tiempoTranscurrido2  ){
				
				if (distancia < 25) {
					
					Motor.A.stop();
					Motor.B.stop();
					
				
					
				}
				else {
				
				
					//	System.out.println("distancia: "+ distancia);
					//	System.out.println("segundo tiempo");
						
						Motor.B.forward();
						Motor.B.setSpeed(135);
						Motor.A.backward();
						Motor.A.setSpeed(135);
						segundoTiempo2 =  System.currentTimeMillis();
						tiempoTranscurrido2 = segundoTiempo2 - primerTiempo2;
						distancia = sonar.getDistance(); }
	
			}
			
			seg = seg * 2;
			tiempoTranscurrido = tiempoTranscurrido * 0;
			tiempoTranscurrido4 = System.currentTimeMillis();
		}
		
		
		Motor.B.stop();
		Motor.A.stop();
		
 
}
    
}



//IR PARA ATRAS CUANDO SE EQUIVOCA DE COLOR
	public void retrocede(int ms) throws InterruptedException {
		Motor.A.backward();
		Motor.B.backward();
		Thread.sleep(ms);
	
}
	
	public void parar(int ms) throws InterruptedException {
		Motor.A.stop();
		Motor.B.stop();
		Thread.sleep(ms);
	
}

	
	
public void buscarMacacoEntreMedidas(){
	
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	int distancia = sonar.getDistance();
    distancia = sonar.getDistance();
    if (distancia > 7){
		
		int seg = 200;
		

		
			
			
			long tiempoTranscurrido = 0, tiempoTranscurrido2 = 0;
			long primerTiempo=0, segundoTiempo=0, primerTiempo2=0, segundoTiempo2=0;
			primerTiempo =  System.currentTimeMillis();
			//para buscar la puerta
			while (distancia > 7  && seg > tiempoTranscurrido ){
				
				Motor.A.forward();
				Motor.A.setSpeed(110);
				Motor.B.backward();
				Motor.B.setSpeed(110);
				segundoTiempo =  System.currentTimeMillis();
				
				 
				tiempoTranscurrido = segundoTiempo - primerTiempo;
				
				
				distancia = sonar.getDistance();
				
			}
			tiempoTranscurrido = tiempoTranscurrido * 0;
			
			seg = seg * 2;
			primerTiempo2 =  System.currentTimeMillis();
			
			while (distancia > 7  && seg > tiempoTranscurrido2  ){
				
				if (distancia < 7) {
					
					Motor.A.stop();
					Motor.B.stop();
					
				
					
				}
				else {
				
				
						
						
						Motor.B.forward();
						Motor.B.setSpeed(90);
						Motor.A.backward();
						Motor.A.setSpeed(90);
						segundoTiempo2 =  System.currentTimeMillis();
						tiempoTranscurrido2 = segundoTiempo2 - primerTiempo2;
						distancia = sonar.getDistance(); }
	
			}
			
			seg = seg * 2;
			tiempoTranscurrido = tiempoTranscurrido * 0;
		
		
		
		Motor.B.stop();
		Motor.A.stop();
		
 
}
    
	
}


	public void avanzar ()
	{	
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
		int distancia = sonar.getDistance();
		int distancia2 = sonar.getDistance();
		
		while(distancia > 6){
			distancia = sonar.getDistance();
			
			while(distancia2 <= distancia && distancia2 < 6);{
				
		
				Motor.A.forward();
				Motor.A.setSpeed(40);
				Motor.A.setSpeed(40);
				Motor.B.forward();
		
		distancia2 = sonar.getDistance();
		
		
	}
		
		if (distancia2 > distancia){
		buscarMacacoEntreMedidas();}

		}
		Motor.B.stop();
		Motor.A.stop();
		//Motor.B.rotateTo(-8);
		//Motor.A.rotateTo(8);
		
		//lo  nuevo 1/9/15
		
		
	}
	
	
	

public void encontrarPuerta(){   
	
	LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
	navigator.reset();
	
	LightSensor sensorLuz = new LightSensor(SensorPort.S1);
	int luz = sensorLuz.getLightValue();
	
	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	int distancia = sonar.getDistance();
	TouchSensor sensorContacto = new TouchSensor(SensorPort.S2);
	int tocar=0; 
	int entro=0;
	
	int puerta1 = 0;
	int puerta2 = 0;
	int puerta3 = 0;
	
	while (entro==0){
	
	
	//VAMOS PARA ADELANTE HASTA ENCONTRAR LA PARED hasta que sea menor a 15
		navigator.travel(30);
		navigator.rotate(100);
		
		while (!tocarBotoneraLateral()){
			Motor.A.forward();
			Motor.A.setSpeed(90);
			Motor.B.backward();
			Motor.B.setSpeed(90);
		
		}
		
		
	while(tocarBotoneraLateral()){
		
		Motor.A.forward();
		Motor.A.setSpeed(100);
		Motor.B.forward();
		Motor.B.setSpeed(100);
	
	}	
			//while (distancia > 9)
		if (!tocarBotoneraDelantera()|| (luz<35))
			{
				
				Motor.A.forward();
				Motor.A.setSpeed(250);
				Motor.B.forward();
				Motor.B.setSpeed(250);
				
				luz = sensorLuz.getLightValue();
				
				//distancia = sonar.getDistance();

		}
		distancia = sonar.getDistance();
		
		if ((luz <35)&&(distancia > 100)){
			lugarEquivocado();
			puerta1=1;//no entrar mas a puerta 1
			navigator.travel(20);
			
			Motor.A.stop();
			Motor.B.stop();
		}
			
		else {
			
			
		}
		
		while (distancia > 50){
			
			detectarDistanciaPared();
			distancia = sonar.getDistance();
			
		}
		
		Motor.A.stop();
		Motor.B.stop();
		
	
			
			
		
		
		
		
		
		/*	//MIENTRAS NO TOCO LA PARED DE COSTADO
			while (!(tocarBotoneraLateral()) && tocar==0){
				Motor.A.forward();
				Motor.A.setSpeed(50);
				tocar=1;
			}
			//voy paralelo de costado
		while (tocarBotoneraLateral())
		Motor.A.forward();
		Motor.A.setSpeed(50);
		Motor.B.forward();
		Motor.B.setSpeed(50);
		
		
		
		if (!(tocarBotoneraLateral())){
			//girar 100 para entrar a la puerta
			
			navigator.rotate(100);
			
			//navigator.travel(30);
			
			entro=1;
		}*/
		
	}}


	
	public void salvarMacaco(){
		LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
		navigator.reset();
		//navigator.travel(30);
		//Motor.A.setSpeed(50);
		//Motor.B.setSpeed(50);
		//navigator.rotate(100);
		//navigator.travel(30);
		//navigator.rotate(100);
		//navigator.travel(30);
		//navigator.rotate(100);
		//navigator.travel(30);
		navigator.rotate(-100);
		
		
		
	}

	public boolean tocarBotoneraDelantera(){
		
		//para usar la botonera
	    TSM tsm = new TSM(SensorPort.S2);
	    int i = 1;
	    //fin de botonera
	   boolean presionado; 
	    presionado=tsm.getInstance(i).isPressed();
	    return presionado;
		
	}
	
	public boolean tocarBotoneraLateral(){
		
		//para usar la botonera
	    TSM tsm = new TSM(SensorPort.S2);
	    int i = 0;
	    //fin de botonera
	    
	    boolean presionado; 
	    presionado=tsm.getInstance(i).isPressed();
	    return presionado;
		
	}
	

	public void pararConBotonera(){
		
		TouchSensor sensorContacto = new TouchSensor(SensorPort.S2);
		Motor.A.forward();
		while (!sensorContacto.isPressed());
		}
	
	
	public void abrirPinza(){
	
		Motor.C.rotateTo(-30);
		
	}
	
	public void cerrarPinza(){
		
		Motor.C.rotateTo(30);
	}

	public void buscarDistanciaPuertaRapida(){
		
		UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
		int distancia = sonar.getDistance();
		
		if (distancia>150){
			Motor.A.stop();
			Motor.B.stop();
		}
		else {
			Motor.B.forward();
			Motor.B.setSpeed(90);
			Motor.A.backward();
			Motor.A.setSpeed(90);
		}
		
		if (tocarBotoneraDelantera()){
		
		Motor.A.stop();
		Motor.B.stop();
		
		}
		
		}
		
	

public void encontrarPared(){}
	
	

	



public void detectarDistanciaPared(){

	UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	int distancia = sonar.getDistance();
    distancia = sonar.getDistance();
    if (distancia > 7){
		
		int seg = 100;
		

		while (distancia > 25) {
			
			
			long tiempoTranscurrido = 0, tiempoTranscurrido2 = 0;
			long primerTiempo=0, segundoTiempo=0, primerTiempo2=0, segundoTiempo2=0;
			primerTiempo =  System.currentTimeMillis();
			//para buscar la puerta
			while (distancia > 25  && seg > tiempoTranscurrido ){
				
				
				
				
				Motor.A.forward();
				Motor.A.setSpeed(110);
				Motor.B.backward();
				Motor.B.setSpeed(110);
				segundoTiempo =  System.currentTimeMillis();
				
				 
				tiempoTranscurrido = segundoTiempo - primerTiempo;
				
				
				distancia = sonar.getDistance();
				
			}
			tiempoTranscurrido = tiempoTranscurrido * 0;
			
			seg = seg * 2;
			primerTiempo2 =  System.currentTimeMillis();
			
			while (distancia > 25  && seg > tiempoTranscurrido2  ){
				
				if (distancia < 25) {
					
					Motor.A.stop();
					Motor.B.stop();
					
				
					
				}
				else {
				
				
						
						
						//Motor.B.forward();
						//Motor.B.setSpeed(90);
						//Motor.A.backward();
						//Motor.A.setSpeed(90);
						segundoTiempo2 =  System.currentTimeMillis();
						tiempoTranscurrido2 = segundoTiempo2 - primerTiempo2;
						distancia = sonar.getDistance(); }
	
			}
			
			seg = seg * 2;
			tiempoTranscurrido = tiempoTranscurrido * 0;
		}
		
		
		Motor.B.stop();
		Motor.A.stop();
		
 
}
    

	
	
	


}



public void lugarEquivocado(){
	
	LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
	navigator.reset();
	
	navigator.travel(30);
	navigator.rotate(100);
	navigator.travel(30);
	navigator.rotate(100);
	navigator.travel(30);
	navigator.rotate(100);
	navigator.travel(30);
	navigator.rotate(-100);
	
	
}




public void paraleloALaPared(){
	

	 TSM tsm = new TSM(SensorPort.S2);
	 int i = 0;
	
	 UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S4);
	LegacyPilot navigator = new LegacyPilot(5.6f, 11.4f, Motor.A, Motor.B);
	navigator.reset();
	
	int distancia = sonar.getDistance();
	while(!tocarBotoneraLateral()){
	
	while ((!tocarBotoneraLateral())&&(distancia>20)){
	
			navigator.rotate(-35);
			navigator.travel(3);
			navigator.rotate(33);
			distancia = sonar.getDistance();
            		
	}
	distancia = sonar.getDistance();
		if (distancia<20){
			navigator.rotate(90);
		}
	}
	Motor.A.stop();
	Motor.B.stop();
		
	
		
	
	}
	//para entrar por una puerta y ver el color del piso
	
	
		



	
	
	}

	




