
    int LoadHS=0;
    
      int Timer;

void vaisseau(){

if (noclip==true){ 
    if (cameraEnabled == true) {
      
  
  hint(DISABLE_DEPTH_TEST); 
  
  textSize(15);
  camera();
  noStroke();
  fill(255); 
  rectMode(CENTER);
  textAlign(CENTER);
  rect(30,height-30,40,40);
  if(!isBoost){
    LoadHS = 0;
    fill(255);
    text("Press 'Shift' to activate the space navigation",width/2,height/3+5);}
  if(isBoost&&isForward){
    if(LoadHS<300){
      LoadHS = LoadHS + 2;
      float TimerHS = map(LoadHS,0,300,3,0);
      fill(255,120);
      rect(width/2,height/3,150,20);
      rectMode(LEFT);
      float lgrect = map(LoadHS,0,300,0,150);
      fill(255);
      rect((width/2)-75,height/3-10,(width/2)-75+lgrect,height/3-10+20);
      fill(255,0,0);
      text(TimerHS,width/2,height/3+5);
}
    if (LoadHS>=300){
      for(int i=0; i<=stars; i++){  
      HSV.get(i).display();}
      Timer = Timer + 12;
      if(Timer>200)Timer=0;
      if (Timer<100){
      fill(255,0,0);}
      if (Timer>100){
      fill(255);}
      text("HYPERSPACE ACTIVATED",width/2,height/3+5);
    }
  }
  image(cockpit,0,0,width,height);
  fill(255); 
  rectMode(CENTER);
  textAlign(CENTER);
  text ("Press 'Tab' to set info ",width/2,30);
  textAlign(RIGHT);
  text ("Press 'V' to switch view",width-30,30);
  textAlign(LEFT);
  text ("'Esc' to EXIT",30,30);
  if(!Stat)text ("'F3'",30,60);
  textAlign(CENTER);
  fill(255,100);
  if(isLeft)fill(255,0,0,200);
  rect(50,height-50,40,40);
  fill(255);
  text("Q",50,height-45);
  fill(255,100);
  if(isBack)fill(255,0,0,200);
  rect(100,height-50,40,40);
  fill(255);
  text("S",100,height-45);
  fill(255,100);
  if(isRight)fill(255,0,0,200);
  rect(150,height-50,40,40);
  fill(255);
  text("D",150,height-45);
  fill(255,100);
  if(isForward)fill(255,0,0,200);
  rect(100,height-100,40,40);
  fill(255);
  text("Z",100,height-95);
   fill(255,100);
  if(isUp)fill(255,0,0,200);
  rect(250,height-100,60,40);
  fill(255);
  text("SPACE",250,height-95);
  fill(255,100);
  if(isDown)fill(255,0,0,200);
  rect(250,height-50,40,40);
  fill(255);
  text("CTRL",250,height-45);
  
  noFill();
  noStroke();

  hint(ENABLE_DEPTH_TEST); }
  

  mainCamera.camTransformations();
}
}
