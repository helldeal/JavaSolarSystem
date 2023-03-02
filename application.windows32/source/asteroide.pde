import java.util.List;
List<asteroide> asteroide = new ArrayList<asteroide>();
int aste = 2000;
class asteroide{
float distance;
float taille;
String texture;
float vitesse;
float yy;
float pos;
asteroide( float distance, float taille, String texture, float vitesse, float yy,float pos){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.pos = pos;
}
  
void ldisplay(){
  setuptex();
  yy = yy+vitesse;
  if (pos == 2){
  rotateZ(radians(-5));
  rotateX(radians(-10));
  rotateY(radians(yy));
  translate(distance+40,0,0);
  shape(asteS);
  translate(-distance-40,0,0);
  translate(distance,0,0);
  shape(asteS);
  translate(-distance,0,0);
  rotateY(radians(-yy));
  rotateX(radians(10));
  rotateZ(radians(5));
}
}
}
float refresh=0;
void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  astetex = loadImage("aste.jpg");
  asteS = createShape(SPHERE, 1);   
  asteS.setTexture(astetex);
  asteS.setStroke(false);
  }}
