class HyperSpaceVisual{
float x;
float y;
float z;
float vit;
HyperSpaceVisual (float x, float y, float z, float vit){
  this.x =x;
  this.y = y;
  this.z = z;
  this.vit = vit;
}
void display(){
  z = z+=vit;
  fill(255,200);
  stroke(255,200);
  line(x,y,z-1000,x,y,z);
  noStroke();
  lights();
  translate(x, y, z);
  translate(-x, -y, -z);
  if (z > 500){
    z = -5000;
  }
}
}
