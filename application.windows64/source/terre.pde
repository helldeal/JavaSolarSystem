class terre{
float distance;
float taille;
String texture;
float vitesse;
float yy;
 float yyy;
String nom;
terre(String nom,float distance, float taille, String texture, float vitesse, float yy){
  this.distance = distance;
  this.taille = taille;
  this.texture = texture;
  this.vitesse = vitesse;
  this.yy = yy;
  this.nom = nom;
}
float refresh=0;
void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  terretex = loadImage(texture);
  terreS = createShape(SPHERE, taille);   
  terreS.setStroke(false);
  terreS.setTexture(terretex);}}

void display(){
  setuptex();
  yy = yy+vitesse;
  rotateY(radians(yy));
  translate(distance,0,0);
  if(isInfo){
    stroke(255);
    fill(255);
    rotateY(-PI/2);
  textAlign(LEFT);
    text (nom, taille*1.5*2+3, -taille*1.5+3);
    line(0,0,taille*1.5,-taille*1.5);
    line(taille*1.5,-taille*1.5,taille*1.5*2,-taille*1.5);
    rotateY(PI/2);
    noStroke();
    noFill();}
  directionalLight(250, 250, 250, distance, 0, 0);
  directionalLight(5, 5, 5, -distance, 0, 0);
  yyy=yyy+0.1;
  rotateY(radians(yyy));
  shape(terreS);
  if (nom =="terre"){
    lune.ldisplay();
      }
  rotateY(radians(-yyy));
  translate(-distance,0,0);
  rotateY(radians(-yy));
  noLights();
   if (nom =="terre"){
     if (switchplanet == 4&&noclip==false){
       rotateX(radians(90));
       noFill();
       translate((width/2), (height/2), 0);
       HUD();
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
       camera(camEyeX+distance*sin(radians(yy+90)), camEyeY, camEyeZ+distance*cos(radians(yy+90)), viewX+distance*sin(radians(yy+90)), viewY, viewZ+distance*cos(radians(yy+90)), camUpX, camUpY, camUpZ); 
  if (rho<taille*4){
    rho = taille*4;}
       updateCamPosition();
       translate((width/2), (height/2), 0);
       noStroke();
     }}}}
