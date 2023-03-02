 class soleil{
  float taille;
  String texture;
  float yyy;
  String nom;
  soleil(String nom, float taille, String texture){
  this.taille = taille;
  this.texture = texture;
  this.nom = nom;
  }
  float refresh=0;
void setuptex(){ 
  if (refresh<1){
  refresh=refresh+1;
  soleiltex = loadImage(texture);
  soleilS = createShape(SPHERE, taille);   
  soleilS.setStroke(false);
  soleilS.setTexture(soleiltex);
}}
   void display(){
     
  
 
  
     setuptex();
  if (switchplanet == 1&&noclip==false){
       textAlign(CENTER);
       textSize(40);
       text("<< "+nom+" >>",width/2,height-50);
    camera(camEyeX, camEyeY, camEyeZ, viewX, viewY, viewZ, camUpX, camUpY, camUpZ);
    if (rho<taille*4){
    rho = taille*4;}
  updateCamPosition();
  }
  
  
  translate(width/2, height/2, 0);
  if(isInfo){
  stroke(255);
  textSize(40);
  fill(255);
  textAlign(LEFT);
text (nom, taille*1.5*2+10, -taille*1.5+10);
line(0,0,taille*1.5,-taille*1.5);
line(taille*1.5,-taille*1.5,taille*1.5*2,-taille*1.5);
  textSize(10);
noStroke();}
  shape(soleilS);
  
  
 }}
