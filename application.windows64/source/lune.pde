class sattelite{
float distance;
float taille;
String texture;
float vitesse;
float yy;
float pos;
sattelite(float distance, float taille, String texture, float vitesse, float yy,float pos){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.pos = pos;
}
  float refresh=0;
void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  lunetex = loadImage(texture);
  luneS = createShape(SPHERE, taille);   
  luneS.setStroke(false);
  luneS.setTexture(lunetex);
}}
void ldisplay(){
  setuptex();
  yy = yy+vitesse;
  if (pos == 1){
  rotateZ(radians(yy));
  translate(distance,0,0);
  shape(luneS);
  translate(-distance,0,0);
  rotateZ(radians(-yy));}
  if (pos == 2){
  rotateY(radians(yy));
  translate(distance,0,0);
  shape(luneS);
  translate(-distance,0,0);
  rotateY(radians(-yy));}
}}
