boolean isLeft, isRight, isUp, isDown, isForward, isBack,isBoost,isNoClip,isInfo,isStat; 

  float switchplanet=1;
boolean noclip=false;
boolean Stat=false;
void keyPressed() {
  setMove(keyCode, true);
  setMove(key, true);
  if (key == CODED){
    if (keyCode == LEFT)  {
      switchplanet  = switchplanet - 1;
      if (switchplanet<= 0) switchplanet = 9;
    }
    if (keyCode == RIGHT) {
      switchplanet= switchplanet + 1;
      if (switchplanet>= 10) switchplanet = 1;
    }
  }
   if (key == 'v'){
    noclip=!noclip;}
   if (keyCode == 99){
    Stat=!Stat;}
  }
 
void keyReleased() {
  setMove(keyCode, false);
  setMove(key, false);
}
 
boolean setMove(int k, boolean b) {
  switch (k) {
  case ' ':
    return isUp = b;
 
  case CONTROL:
    return isDown = b;
  case SHIFT:
    return isBoost = b;
 
  case 'q':
    return isLeft = b;
 
  case 'd':
    return isRight = b;
    
    case 'z':
    return isForward = b;
     case 's':
    return isBack = b;
    case 'v':
    return isNoClip = b;
    
    case TAB:
    return isInfo = b;
    
 
  default:
    return b;
  }
}
