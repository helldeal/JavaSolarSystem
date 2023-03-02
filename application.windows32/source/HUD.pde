PImage souris;
PImage LMB;
PImage RMB;
PImage LMB_RMB;

void HUD(){
 hint(DISABLE_DEPTH_TEST); 
  
  textSize(15);
  camera();
  noStroke();
  rectMode(CENTER);
  fill(255);
  textAlign(CENTER);
  text ("Press 'Tab' to set info ",width/2,30);
  textAlign(RIGHT);
  text ("Press 'V' to switch view",width-30,30);
  textAlign(LEFT);
  text ("'Esc' to EXIT",30,30);
  
  fill(255);
  image(souris,width-50,height-50,40,40);
  text("'LMB' to rotate",width-160,height-35);
  text("'RMB' to zoom",width-160,height-15);
   if (mouseButton == LEFT){image(LMB,width-50,height-50,40,40);fill(255,0,0);text("'LMB' to rotate",width-160,height-35);}
   if (mouseButton == RIGHT){image(RMB,width-50,height-50,40,40);fill(255,0,0);text("'RMB' to zoom",width-160,height-15);}
   
  fill(255);
  if(!Stat)text ("'F3'",30,60);
  noFill();
  noStroke();
    if(Stat){   
  fill(255);
  textAlign(LEFT);
  text ("fps "+round(frameRate), 30, 60);
  noFill();
  noStroke();
    }

  hint(ENABLE_DEPTH_TEST); 
  }
