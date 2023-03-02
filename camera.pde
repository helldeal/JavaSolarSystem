  int winSizeX =  1280;
  int winSizeY = 720;
int cx = winSizeX/2;
int cy = winSizeY/2;
//center
int cz = 0;

//camera positions
float camEyeX = 0;
float camEyeY = 0;
float camEyeZ = 0;
float viewZ = cz;
float viewY = cy;
float viewX = cx;
float camUpX = 0;
float camUpY = 1;
float camUpZ = 0;

//Polar coordinates
float theta = 0;      
float phi = 0;       
float rho = 350;   //distance from cam to point of view

float moveZ=0;
void updateCamPosition() {
    
    
  if(noclip==false){
  camEyeX = rho * cos(radians(theta)) * cos(radians(phi)) + cx;
  camEyeY = rho * sin(radians(theta)) + cy;
  camEyeZ = rho * cos(radians(theta)) * sin(radians(phi));
}
}

void mouseDragged() {
  if(noclip==false){
  if (mouseButton == LEFT && theta<=80 && theta >=-80){
    theta = theta + (pmouseY - mouseY);
    phi = phi - (pmouseX - mouseX);
  }

  if (mouseButton == RIGHT) {
    rho = rho - (pmouseY - mouseY);
  }
  if (theta>80)theta=80;
  if (theta<-80)theta=-80;
}
} 
